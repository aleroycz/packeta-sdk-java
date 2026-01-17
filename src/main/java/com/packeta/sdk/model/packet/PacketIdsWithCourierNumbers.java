package com.packeta.sdk.model.packet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of PacketIdWithCourierNumber structures, which contain packet IDs together with courier numbers.
 */
@JacksonXmlRootElement(localName = "packetIdsWithCourierNumbers")
public class PacketIdsWithCourierNumbers extends ArrayList<PacketIdWithCourierNumber> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "packetIdWithCourierNumber")
    public ArrayList<PacketIdWithCourierNumber> getPacketIdsWithCourierNumbers() {
        return this;
    }
}