package com.packeta.sdk.model.shipment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * A unique ID of the shipment.
 */
@JacksonXmlRootElement(localName = "shipmentIdDetail")
@Data
public class ShipmentIdDetail {
    /**
     * A unique ID of the shipment.
     */
    @JacksonXmlProperty(localName = "id")
    private Integer id; // unsignedInt, yes

    /**
     * Empty string. Deprecated.
     */
    @JacksonXmlProperty(localName = "checksum")
    private String checksum; // string, yes

    /**
     * A shipment barcode in format: D-***-XM-&lt;id&gt;. Id is numeric value that may be prefixed with 0, length is not restricted.
     */
    @JacksonXmlProperty(localName = "barcode")
    private String barcode; // string, yes

    /**
     * Same value as barcode. Deprecated.
     */
    @JacksonXmlProperty(localName = "barcodeText")
    private String barcodeText; // string, yes
}