package com.packeta.sdk.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;
import com.packeta.sdk.exception.*;
import com.packeta.sdk.model.PacketaErrorResponse;
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

        String fullXml = PacketaRequestBuilder.buildRequest(method, apiPassword, innerXml);
        log.debug("XML → {}:\n{}", method, fullXml);

        return SimpleRetry.withRetry(() -> {
            try {
                String respXml = postXml(fullXml);

                System.out.println("Response: \n" + respXml);

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

        String fullXml = PacketaRequestBuilder.buildRequest(method, apiPassword, innerXml);
        log.debug("XML → {}:\n{}", method, fullXml);

        return SimpleRetry.withRetry(() -> {
            try {
                String respXml = postXml(fullXml);

                System.out.println("Response: \n" + respXml);

                if (XmlHelper.isFaultResponse(respXml)) {
                    PacketaErrorResponse packetaErrorResponse = parseFault(respXml);
                    throw createSpecificException(packetaErrorResponse);
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

        String fullXml = PacketaRequestBuilder.buildRequest(method, apiPassword, innerXml);
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
    private PacketaApiException createSpecificException(PacketaErrorResponse packetaErrorResponse) {
        String code = packetaErrorResponse.getFaultCode();
        String msg = packetaErrorResponse.getFaultString();
        List<PacketaErrorResponse.AttributeFault> faults =
                packetaErrorResponse.getDetail().getAttributes() != null
                        ? packetaErrorResponse.getDetail().getAttributes()
                        : List.of();

        return switch (code) {
            case "PacketAttributesFault" -> new PacketAttributesFaultException(code, msg, faults);
            case "ExternalGatewayError", "externalCarrierError" -> new ExternalGatewayFaultException(code, msg);
            case "ArgumentsFault" -> new ArgumentsFaultException(code, msg);
            case "CancelNotAllowed" -> new CancelNotAllowedFaultException(code, msg);
            case "CustomBarcodeNotAllowed" -> new CustomBarcodeNotAllowedFaultException(code, msg);
            case "DateOutOfRange" -> new DateOutOfRangeFaultException(code, msg);
            case "DispatchOrderNotAllowed" -> new DispatchOrderNotAllowedFaultException(code, msg);
            case "IncorrectApiPassword" -> new IncorrectApiPasswordFaultException(code, msg);
            case "PacketIdFault" -> new PacketIdFaultException(code, msg);
            case "SenderNotExists" -> new SenderNotExistsException(
                    code,
                    msg,
                    packetaErrorResponse.getDetail() != null
                            ? packetaErrorResponse.getDetail().toString().trim()   // safe extraction
                            : null
            );

            case "UnknownLabelFormat" -> new UnknownLabelFormatFaultException(
                    code,
                    msg,
                    packetaErrorResponse.getDetail() != null
                            ? packetaErrorResponse.getDetail().toString().trim()
                            : null
            );
            case "PacketIdsFault" -> new PacketIdsFaultException(code, msg);
            case "NotSupported" -> new NotSupportedFaultException(code, msg);
            case "NoPacketIds" -> new NoPacketIdsFaultException(code, msg);
            case "InvalidCourierNumber" -> new InvalidCourierNumberException(code, msg);
            case "ShipmentNotFound" -> new ShipmentNotFoundFaultException(code, msg);
            default -> new PacketaApiExceptionCustom(code, msg);
        };
    }

    private PacketaErrorResponse parseFault(String xml) throws PacketaApiException {
        try {
            return XmlHelper.fromXml(xml, PacketaErrorResponse.class);
        } catch (PacketaApiException e) {
            // fallback for very old API behavior (unlikely in 2025/2026)
            try {
                return XmlHelper.fromXml(xml, PacketaErrorResponse.class, "fault");
            } catch (PacketaApiException ignored) {
                throw e; // throw the original "status" error
            }
        }
    }
}