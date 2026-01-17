package com.packeta.sdk.model.packet;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.model.carrier.CourierInfo;
import lombok.Data;

/**
 * Object with a packet's additional information.
 */
@JacksonXmlRootElement(localName = "packetInfoResult")
@Data
public class PacketInfoResult {
    /**
     * Destination branch ID.
     */
    @JacksonXmlProperty(localName = "branchId")
    private Integer branchId; // unsignedInt, yes

    /**
     * Verified weight of the packet which is used in the invoice (if available).
     */
    @JacksonXmlProperty(localName = "invoicedWeightGrams")
    private Integer invoicedWeightGrams; // unsignedInt, no

    /**
     * Info about courier consignment, if the packet is heading to a courier and has been consigned.
     */
    @JacksonXmlProperty(localName = "courierInfo")
    private CourierInfo courierInfo; // CourierInfo, no

    /**
     * Unique ID of the order (from your e-shop). For claims: original packet barcode with RET prefix.
     * Constraints: 1-36 alphanumeric.
     */
    @JacksonXmlProperty(localName = "number")
    private String number; // string, no
}