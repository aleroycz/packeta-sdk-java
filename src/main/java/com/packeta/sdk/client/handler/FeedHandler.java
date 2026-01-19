package com.packeta.sdk.client.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.packeta.sdk.client.RequestHandler;
import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.model.feed.Box;
import com.packeta.sdk.model.feed.Branch;
import com.packeta.sdk.model.feed.Carrier;
import com.packeta.sdk.model.feed.CarriersPudosResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handler for JSON data feeds (PUDOs, boxes, carriers, etc.).
 */
@RequiredArgsConstructor
public class FeedHandler {

    private final RequestHandler requestHandler;

    /**
     * Fetches Packeta pick-up points (branches).
     *
     * @param language Language code (e.g., "en")
     * @return List of branches
     * @throws PacketaApiException On errors
     */
    public List<Branch> getBranches(String language) throws PacketaApiException {
        String endpoint = "/branch/json?lang=" + language;
        return requestHandler.executeFeed(endpoint, new TypeReference<>() {
        });
    }

    /**
     * Fetches Packeta boxes.
     *
     * @param language Language code (e.g., "en")
     * @return List of boxes
     * @throws PacketaApiException On errors
     */
    public List<Box> getBoxes(String language) throws PacketaApiException {
        String endpoint = "/box/json?lang=" + language;
        return requestHandler.executeFeed(endpoint, new TypeReference<>() {
        });
    }

    /**
     * Fetches carriers (home delivery).
     *
     * @param language Language code (e.g., "en")
     * @return List of carriers
     * @throws PacketaApiException On errors
     */
    public List<Carrier> getCarriers(String language) throws PacketaApiException {
        String endpoint = "/carrier/json?lang=" + language;
        return requestHandler.executeFeed(endpoint, new TypeReference<>() {
        });
    }

    /**
     * Fetches carriers' PUDOs (pick-up points).
     *
     * @param carrierIds List of carrier IDs (optional, null for all)
     * @return Carriers PUDOs response
     * @throws PacketaApiException On errors
     */
    public CarriersPudosResponse getCarriers(List<Integer> carrierIds) throws PacketaApiException {
        String endpoint = "/carrier_point/json";

        if (carrierIds != null && !carrierIds.isEmpty()) {
            String idsParam = carrierIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));

            endpoint += "?id=" + idsParam;
        }

        return requestHandler.executeFeed(endpoint, CarriersPudosResponse.class);
    }
}