package com.packeta.sdk;

import com.google.common.util.concurrent.RateLimiter;
import com.packeta.sdk.client.RequestHandler;
import com.packeta.sdk.client.handler.*;
import com.packeta.sdk.util.RateLimit;
import lombok.Getter;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Main entry point to Packeta SDK.
 * Provides access to all specialized handlers.
 */
@Getter
public class PacketaClient {
    private final PacketCreationHandler packetCreation;
    private final ClaimHandler claim;
    private final LabelHandler label;
    private final TrackingHandler tracking;
    private final CustomsHandler customs;
    private final FeedHandler feed;

    public PacketaClient(String apiPassword, String apiKey) {
        this(apiPassword, apiKey, "https://www.zasilkovna.cz/api/rest", "https://pickup-point.api.packeta.com/v5");
    }

    public PacketaClient(String apiPassword, String apiKey, String xmlBaseUrl, String feedBaseUrl) {
        this(apiPassword, apiKey, xmlBaseUrl, feedBaseUrl,
                new OkHttpClient.Builder()
                        .connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .build(),
                RateLimit.defaultPacketaLimiter());
    }

    public PacketaClient(String apiPassword, String apiKey, String xmlBaseUrl, String feedBaseUrl,
                         OkHttpClient httpClient, RateLimiter rateLimiter) {
        RequestHandler requestHandler = new RequestHandler(apiKey, apiPassword, xmlBaseUrl, feedBaseUrl, httpClient, rateLimiter);

        this.packetCreation = new PacketCreationHandler(requestHandler);
        this.claim = new ClaimHandler(requestHandler);
        this.label = new LabelHandler(requestHandler);
        this.tracking = new TrackingHandler(requestHandler);
        this.customs = new CustomsHandler();
        this.feed = new FeedHandler(requestHandler);
    }
}