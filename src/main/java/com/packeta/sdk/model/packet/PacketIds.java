package com.packeta.sdk.model.packet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of packet IDs, a packet ID is 64-bit unsignedLong.
 */
@JacksonXmlRootElement(localName = "packetIds")
public class PacketIds extends ArrayList<Long> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "packetId")
    public ArrayList<Long> getPacketIds() {
        return this;
    }
}