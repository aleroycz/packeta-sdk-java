package com.packeta.sdk.model.shipment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Packet collection.
 */
@JacksonXmlRootElement(localName = "shipmentPacketsResult")
@Data
public class ShipmentPacketsResult {
    /**
     * Packet collection.
     */
    @JacksonXmlProperty(localName = "packets")
    private PacketCollection packets; // PacketCollection, yes
}