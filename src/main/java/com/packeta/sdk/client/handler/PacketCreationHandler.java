package com.packeta.sdk.client.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.packeta.sdk.client.RequestHandler;
import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.model.claims.ClaimAttributes;
import com.packeta.sdk.model.claims.ClaimWithPasswordAttributes;
import com.packeta.sdk.model.packet.PacketAttributes;
import com.packeta.sdk.model.packet.PacketB2BAttributes;
import com.packeta.sdk.model.packet.PacketIdDetail;
import com.packeta.sdk.model.shipment.ShipmentIdDetail;
import com.packeta.sdk.util.XmlHelper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handler responsible for all packet creation related operations.
 * Covers:
 * - Standard packet creation (PUDOs, Carriers' PUDOs, Home Delivery)
 * - Claims (normal + with password)
 * - B2B multi-packet creation
 * - Shipment creation from packets
 * - Attribute validation (without creation)
 */
@RequiredArgsConstructor
public class PacketCreationHandler {

    private final RequestHandler rh;

    /**
     * Creates a single standard packet.
     * Supports Packeta PUDOs, Carriers' PUDOs, Home Delivery (with or without customs).
     *
     * @param attributes Full packet attributes
     * @return Created packet details (ID, barcode, etc.)
     * @throws PacketaApiException On any API error
     */
    public PacketIdDetail createPacket(PacketAttributes attributes) throws PacketaApiException {
        String innerXml = "<packetAttributes>" + XmlHelper.toXml(attributes) + "</packetAttributes>";
        return rh.xml("createPacket", innerXml, PacketIdDetail.class, "packetIdDetail");
    }

    /**
     * Creates one or more B2B packets.
     *
     * @param attributes B2B creation parameters (addressId, count, isReturn, etc.)
     * @return List of created PacketIdDetail objects
     * @throws PacketaApiException On any API error
     */
    public List<PacketIdDetail> createPacketsB2B(PacketB2BAttributes attributes) throws PacketaApiException {
        String innerXml = "<packetB2BAttributes>" + XmlHelper.toXml(attributes) + "</packetB2BAttributes>";
        return rh.xml("createPacketsB2B", innerXml,
                new TypeReference<>() {
                }, "packetIds");
    }

    /**
     * Creates a shipment (grouping) from existing packet IDs.
     *
     * @param packetIds     List of packet IDs to include in the shipment
     * @param customBarcode Optional custom barcode for the shipment (if supported)
     * @return Shipment details (ID, barcode, etc.)
     * @throws PacketaApiException On any API error
     */
    public ShipmentIdDetail createShipment(List<Long> packetIds, String customBarcode) throws PacketaApiException {
        if (packetIds == null || packetIds.isEmpty()) {
            throw new IllegalArgumentException("Packet IDs cannot be empty for shipment creation");
        }

        String idsXml = packetIds.stream()
                .map(id -> "<id>" + id + "</id>")
                .collect(Collectors.joining("", "<packetIds>", "</packetIds>"));

        StringBuilder innerXml = new StringBuilder("<createShipment>")
                .append(idsXml);

        if (customBarcode != null && !customBarcode.isBlank()) {
            innerXml.append("<customBarcode>").append(customBarcode).append("</customBarcode>");
        }

        innerXml.append("</createShipment>");

        return rh.xml("createShipment", innerXml.toString(), ShipmentIdDetail.class, "shipmentIdDetail");
    }

    /**
     * Validates packet attributes without creating a real packet.
     * Throws exception if validation fails (e.g., PacketAttributesFault).
     *
     * @param attributes Packet attributes to validate
     * @throws PacketaApiException If attributes are invalid
     */
    public void validatePacketAttributes(PacketAttributes attributes) throws PacketaApiException {
        String innerXml = "<packetAttributes>" + XmlHelper.toXml(attributes) + "</packetAttributes>";
        rh.xml("packetAttributesValid", innerXml, Void.class, null);
    }

    /**
     * Validates claim attributes without creating a real claim.
     * Throws exception if validation fails.
     *
     * @param attributes Claim attributes to validate
     * @throws PacketaApiException If attributes are invalid
     */
    public void validateClaimAttributes(ClaimAttributes attributes) throws PacketaApiException {
        String innerXml = "<claimAttributes>" + XmlHelper.toXml(attributes) + "</claimAttributes>";
        rh.xml("packetClaimAttributesValid", innerXml, Void.class, null);
    }

    /**
     * Validates claim-with-password attributes without creating a claim.
     *
     * @param attributes Claim with password attributes
     * @throws PacketaApiException If attributes are invalid
     */
    public void validateClaimWithPasswordAttributes(ClaimWithPasswordAttributes attributes) throws PacketaApiException {
        String innerXml = "<claimWithPasswordAttributes>" + XmlHelper.toXml(attributes) + "</claimWithPasswordAttributes>";
        rh.xml("packetClaimWithPasswordAttributesValid", innerXml, Void.class, null);
    }
}