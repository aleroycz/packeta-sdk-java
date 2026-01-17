package com.packeta.sdk.model.packet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Attributes for B2B packets.
 */
@JacksonXmlRootElement(localName = "packetB2BAttributes")
@Data
public class PacketB2BAttributes {
    /**
     * Address ID of destination Pickup Point.
     */
    @JacksonXmlProperty(localName = "addressId")
    private Integer addressId; // integer, yes

    /**
     * Count of packets to create, default 1.
     */
    @JacksonXmlProperty(localName = "count")
    private Integer count; // integer, no

    /**
     * Whether packet is return, default false.
     */
    @JacksonXmlProperty(localName = "isReturn")
    private Boolean isReturn; // boolean, no
}