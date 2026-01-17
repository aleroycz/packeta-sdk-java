package com.packeta.sdk.model.packet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of type PacketIdDetail.
 */
@JacksonXmlRootElement(localName = "packetCollection")
public class PacketCollection extends ArrayList<PacketIdDetail> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "packet")
    public ArrayList<PacketIdDetail> getPackets() {
        return this;
    }
}