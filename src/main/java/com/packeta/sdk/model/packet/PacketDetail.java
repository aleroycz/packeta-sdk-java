package com.packeta.sdk.model.packet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Packet detail information.
 */
@JacksonXmlRootElement(localName = "packetDetail")
@Data
public class PacketDetail {
    /**
     * A unique ID packet.
     * Constraints: 10 digits.
     */
    @JacksonXmlProperty(localName = "id")
    private Long id; // unsignedLong, yes

    /**
     * The id prefixed by letter 'Z'. This format is used for generating a readable barcode.
     */
    @JacksonXmlProperty(localName = "barcode")
    private String barcode; // string, yes

    /**
     * The barcode in following format Z 123 4567 890. Used for printing, for better readability.
     */
    @JacksonXmlProperty(localName = "barcodeText")
    private String barcodeText; // string, yes

    /**
     * Password for submitting packet.
     */
    @JacksonXmlProperty(localName = "password")
    private String password; // string, yes
}