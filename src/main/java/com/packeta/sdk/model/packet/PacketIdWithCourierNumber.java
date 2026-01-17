package com.packeta.sdk.model.packet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Structure containing packet ID with courier number.
 */
@JacksonXmlRootElement(localName = "packetIdWithCourierNumber")
@Data
public class PacketIdWithCourierNumber {
    /**
     * A packet ID, e.g. an id returned by createPacket().
     * Constraints: 10 digits.
     */
    @JacksonXmlProperty(localName = "packetId")
    private Long packetId; // unsignedLong, yes

    /**
     * A courier number returned by packetCourierNumber().
     */
    @JacksonXmlProperty(localName = "courierNumber")
    private String courierNumber; // string, yes
}