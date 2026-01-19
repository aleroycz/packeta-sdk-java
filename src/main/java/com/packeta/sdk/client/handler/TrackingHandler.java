package com.packeta.sdk.client.handler;

import com.packeta.sdk.client.RequestHandler;
import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.model.status.CurrentStatusRecord;
import com.packeta.sdk.model.status.StatusRecords;
import com.packeta.sdk.model.status.external.ExternalStatusRecords;
import lombok.RequiredArgsConstructor;

/**
 * Handler for packet tracking and status queries in the Packeta (Zásilkovna) API.
 *
 * Provides methods to retrieve:
 * <ul>
 *   <li>Complete tracking history of a packet</li>
 *   <li>Current (latest) status of a packet</li>
 *   <li>Carrier-specific (external) tracking events for packets handed over to transport partners</li>
 * </ul>
 *
 *
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class TrackingHandler {

    private final RequestHandler rh;

    /**
     * Retrieves the complete tracking history of a Packeta packet.
     *
     * Returns all status records from creation to the most recent event.
     * This is the most detailed tracking information available from Packeta.
     *
     *
     * @param packetId Packeta packet identifier (e.g. "Z1234567890", "3130000123456")
     * @return {@link StatusRecords} containing the full history of status changes
     * @throws PacketaApiException if the packet does not exist,
     *                             access is denied, or other API error occurs
     * @throws IllegalArgumentException if packetId is null or empty (in strict validation mode)
     */
    public StatusRecords packetTracking(String packetId) throws PacketaApiException {
        if (packetId == null || packetId.trim().isEmpty()) {
            throw new IllegalArgumentException("Packet ID cannot be null or empty");
        }

        String xml = "<packetId>" + packetId + "</packetId>";
        return rh.xml("packetTracking", xml, StatusRecords.class, "result");
    }

    /**
     * Retrieves only the current (most recent) status of a Packeta packet.
     * <p>
     * This method is lighter than {@link #packetTracking(String)} when you only need
     * the latest status (e.g. "delivered", "in transit", "at pickup point", etc.).
     * </p>
     *
     * @param packetId Packeta packet identifier
     * @return {@link CurrentStatusRecord} containing the latest status information
     * @throws PacketaApiException if the packet is not found or API request fails
     */
    public CurrentStatusRecord packetStatus(String packetId) throws PacketaApiException {
        if (packetId == null || packetId.trim().isEmpty()) {
            throw new IllegalArgumentException("Packet ID cannot be null or empty");
        }

        String xml = "<packetId>" + packetId + "</packetId>";
        return rh.xml("packetStatus", xml, CurrentStatusRecord.class, "result");
    }

    /**
     * Retrieves carrier-specific (external carrier) tracking events for a packet.
     * <p>
     * Used mainly for packets that have been handed over to an external transport partner
     * (DPD, GLS, PPL, UPS, etc.). Contains status updates coming directly from the carrier.
     * </p>
     * <p>
     * Note: Not all packets have external tracking data – returns empty result if not available.
     * </p>
     *
     * @param packetId Packeta packet identifier
     * @return {@link ExternalStatusRecords} containing carrier-specific tracking events
     * @throws PacketaApiException when API request fails or packet is not found
     */
    public ExternalStatusRecords packetCourierTracking(String packetId) throws PacketaApiException {
        if (packetId == null || packetId.trim().isEmpty()) {
            throw new IllegalArgumentException("Packet ID cannot be null or empty");
        }

        String xml = "<packetId>" + packetId + "</packetId>";
        return rh.xml("packetCourierTracking", xml, ExternalStatusRecords.class, "result");
    }
}