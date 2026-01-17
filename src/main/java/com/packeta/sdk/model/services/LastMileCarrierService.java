package com.packeta.sdk.model.services;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * This attribute has not yet been implemented. This is a reserved record for future use.
 * Allows to configure the carrier delivering the packet. The carrier is supplied trough root addressId attribute. The current usage is to support the clients who use assigned offline barcodes obtained from the carrier.
 */
@JacksonXmlRootElement(localName = "lastMileCarrierService")
@Data
public class LastMileCarrierService {
    /**
     * ID of external carrier.
     */
    @JacksonXmlProperty(localName = "addressId")
    private Integer addressId; // unsignedInt, yes

    /**
     * Packet barcode.
     * Constraints: maxLength=64.
     */
    @JacksonXmlProperty(localName = "barcode")
    private String barcode; // string, no

    /**
     * Packet tracking code.
     * Constraints: maxLength=64.
     */
    @JacksonXmlProperty(localName = "trackingCode")
    private String trackingCode; // string, no

    /**
     * The foreign ID. The identifier used for communication with carrier trough their API. Usually same as trackingCode which is also the default value for this attribute.
     * Constraints: maxLength=64.
     */
    @JacksonXmlProperty(localName = "foreignId")
    private String foreignId; // string, no
}