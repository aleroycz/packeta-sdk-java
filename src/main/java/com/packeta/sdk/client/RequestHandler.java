package com.packeta.sdk.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;
import com.packeta.sdk.exception.*;
import com.packeta.sdk.model.Fault;
import com.packeta.sdk.util.PacketaRequestBuilder;
import com.packeta.sdk.util.SimpleRetry;
import com.packeta.sdk.util.XmlHelper;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Core request execution logic (XML API + JSON feeds).
 * Handles rate limiting, retries, fault parsing, logging.
 */
@RequiredArgsConstructor
public class RequestHandler {

    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);
    private static final MediaType XML = MediaType.get("application/xml; charset=utf-8");
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private final String apiKey;
    private final String apiPassword;
    private final String xmlBaseUrl;
    private final String feedBaseUrl;
    private final OkHttpClient httpClient;
    private final RateLimiter rateLimiter;

    public <T> T xml(String method, String innerXml, Class<T> type, String root) throws PacketaApiException {
        rateLimiter.acquire();

        String fullXml = PacketaRequestBuilder.buildRequest(apiPassword, innerXml);
        log.debug("XML → {}:\n{}", method, fullXml);

        return SimpleRetry.withRetry(() -> {
            try {
                String respXml = postXml(fullXml);

                if (XmlHelper.isFaultResponse(respXml)) {
                    throw createSpecificException(parseFault(respXml));
                }

                return root != null
                        ? XmlHelper.fromXml(respXml, type, root)
                        : XmlHelper.fromXml(respXml, type);
            } catch (PacketaApiException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException("Network/processing error", e);
            }
        }, 3, 500);
    }

    public <T> T xml(String method, String innerXml, TypeReference<T> typeRef, String rootName) throws PacketaApiException {
        rateLimiter.acquire();

        String fullXml = PacketaRequestBuilder.buildRequest(apiPassword, innerXml);
        log.debug("XML → {}:\n{}", method, fullXml);

        return SimpleRetry.withRetry(() -> {
            try {
                String respXml = postXml(fullXml);

                if (XmlHelper.isFaultResponse(respXml)) {
                    Fault fault = parseFault(respXml);
                    throw createSpecificException(fault);
                }

                return rootName != null
                        ? XmlHelper.fromXml(respXml, typeRef, rootName)
                        : XmlHelper.fromXml(respXml, typeRef);
            } catch (PacketaApiException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException("Network/processing error", e);
            }
        }, 3, 500);
    }

    public byte[] binaryXml(String method, String innerXml) throws PacketaApiException {
        rateLimiter.acquire();

        String fullXml = PacketaRequestBuilder.buildRequest(apiPassword, innerXml);
        log.debug("Binary XML → {}:\n{}", method, fullXml);

        return SimpleRetry.withRetry(() -> {
            try {
                RequestBody body = RequestBody.create(fullXml, XML);
                Request req = new Request.Builder()
                        .url(xmlBaseUrl)
                        .post(body)
                        .addHeader("Content-Type", "application/xml")
                        .build();

                try (Response r = httpClient.newCall(req).execute()) {
                    String err = r.body().string();
                    if (!r.isSuccessful()) {
                        if (XmlHelper.isFaultResponse(err)) throw createSpecificException(parseFault(err));
                        throw new IOException("HTTP " + r.code());
                    }
                    return r.body().bytes();
                }
            } catch (PacketaApiException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException("Network/processing error", e);
            }
        }, 3, 500);
    }

    public <T> T executeFeed(String endpoint, Class<T> resultType) throws PacketaApiException {
        rateLimiter.acquire();

        String url = feedBaseUrl + "/" + apiKey + endpoint;
        log.debug("Feed GET: {}", url);

        return SimpleRetry.withRetry(() -> {
            try {
                Request req = new Request.Builder()
                        .url(url)
                        .get()
                        .build();

                try (Response resp = httpClient.newCall(req).execute()) {
                    if (!resp.isSuccessful()) {
                        String err = resp.body().string();
                        throw new IOException("Feed HTTP error " + resp.code() + ": " + err);
                    }
                    return JSON_MAPPER.readValue(resp.body().string(), resultType);
                }
            } catch (IOException e) {
                log.error("Feed request failed: {}", url, e);
                throw new RuntimeException("Feed network/processing error", e);
            }
        }, 3, 500);
    }

    public <T> T executeFeed(String endpoint, TypeReference<T> typeRef) throws PacketaApiException {
        rateLimiter.acquire();

        String url = feedBaseUrl + "/" + apiKey + endpoint;
        log.debug("Feed GET: {}", url);

        return SimpleRetry.withRetry(() -> {
            try {
                Request req = new Request.Builder()
                        .url(url)
                        .get()
                        .build();

                try (Response resp = httpClient.newCall(req).execute()) {
                    if (!resp.isSuccessful()) {
                        String err = resp.body().string();
                        throw new IOException("Feed HTTP error " + resp.code() + ": " + err);
                    }
                    return JSON_MAPPER.readValue(resp.body().string(), typeRef);
                }
            } catch (IOException e) {
                log.error("Feed request failed: {}", url, e);
                throw new RuntimeException("Feed network/processing error", e);
            }
        }, 3, 500);
    }

    private String postXml(String xml) throws IOException {
        RequestBody body = RequestBody.create(xml, XML);
        Request req = new Request.Builder()
                .url(xmlBaseUrl)
                .post(body)
                .addHeader("Content-Type", "application/xml")
                .build();

        try (Response r = httpClient.newCall(req).execute()) {
            if (!r.isSuccessful()) throw new IOException("HTTP " + r.code());
            return r.body().string();
        }
    }

    // Fault → Exception mapping (same as before, just shortened)
    private PacketaApiException createSpecificException(Fault fault) {
        String code = fault.getFaultCode();
        String msg = fault.getFaultString();
        List<PacketAttributesFaultException.AttributeFault> attrFaults =
                fault.getAttributeFaults() != null ? fault.getAttributeFaults() : List.of();

        return switch (code) {
            case "packetAttributesFault" -> new PacketAttributesFaultException(code, msg, attrFaults);
            case "externalGatewayError", "externalCarrierError" -> new ExternalGatewayFaultException(code, msg);
            case "argumentsFault" -> new ArgumentsFaultException(code, msg);
            case "cancelNotAllowed" -> new CancelNotAllowedFaultException(code, msg);
            case "customBarcodeNotAllowed" -> new CustomBarcodeNotAllowedFaultException(code, msg);
            case "dateOutOfRange" -> new DateOutOfRangeFaultException(code, msg);
            case "dispatchOrderNotAllowed" -> new DispatchOrderNotAllowedFaultException(code, msg);
            case "incorrectApiPassword" -> new IncorrectApiPasswordFaultException(code, msg);
            case "packetIdFault" -> new PacketIdFaultException(code, msg);
            case "senderNotExists" -> new SenderNotExistsException(code, msg, fault.getDetail());
            case "unknownLabelFormat" -> new UnknownLabelFormatFaultException(code, msg, fault.getDetail());
            case "packetIdsFault" -> new PacketIdsFaultException(code, msg);
            case "notSupported" -> new NotSupportedFaultException(code, msg);
            case "noPacketIds" -> new NoPacketIdsFaultException(code, msg);
            case "invalidCourierNumber" -> new InvalidCourierNumberException(code, msg);
            case "shipmentNotFound" -> new ShipmentNotFoundFaultException(code, msg);
            default -> new PacketaApiExceptionCustom(code, msg);
        };
    }

    private Fault parseFault(String xml) throws PacketaApiException {
        return XmlHelper.fromXml(xml, Fault.class, "fault");
    }
}