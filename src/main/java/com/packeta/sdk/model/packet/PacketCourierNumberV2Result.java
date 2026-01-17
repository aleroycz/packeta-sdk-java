package com.packeta.sdk.model.packet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Result for packet courier number V2.
 */
@JacksonXmlRootElement(localName = "packetCourierNumberV2Result")
@Data
public class PacketCourierNumberV2Result {
    /**
     * The courier's number.
     */
    @JacksonXmlProperty(localName = "courierNumber")
    private String courierNumber; // string, yes

    /**
     * Numeric identifier of the chosen carrier method.
     */
    @JacksonXmlProperty(localName = "carrierId")
    private Integer carrierId; // unsignedInt, no

    /**
     * Name of the chosen carrier method, in english.
     */
    @JacksonXmlProperty(localName = "carrierName")
    private String carrierName; // string, no
}