package com.packeta.sdk.model.services;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * This attribute has not yet been implemented. This is reserved record for future use.
 * A service that specifies that an external carrier will forward a packet to us for delivery. This allows us to track the packet before we physically receive it.
 */
@JacksonXmlRootElement(localName = "firstMileCarrierService")
@Data
public class FirstMileCarrierService {
    /**
     * ID of external carrier.
     */
    @JacksonXmlProperty(localName = "addressId")
    private Integer addressId; // unsignedInt, yes

    /**
     * Packet barcode. If not supplied, we will consign the packet on your behalf. You can then obtain the carriers label. If supplied, trackingCode has to be supplied as well.
     * Constraints: maxLength=64.
     */
    @JacksonXmlProperty(localName = "barcode")
    private String barcode; // string, no

    /**
     * Packet tracking code. If supplied, barcode has to be supplied as well.
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