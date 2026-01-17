package com.packeta.sdk.model.carrier;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * An object with additional information regarding packet's consignment to an external courier.
 */
@JacksonXmlRootElement(localName = "courierInfoItem")
@Data
public class CourierInfoItem {
    /**
     * Courier ID.
     */
    @JacksonXmlProperty(localName = "courierId")
    private Integer courierId; // unsignedInt, yes

    /**
     * Name of the courier.
     */
    @JacksonXmlProperty(localName = "courierName")
    private String courierName; // string, yes

    /**
     * Array of courier numbers, if available.
     */
    @JacksonXmlProperty(localName = "courierNumbers")
    private CourierNumbers courierNumbers; // CourierNumbers, no

    /**
     * Array of courier barcodes, if available.
     */
    @JacksonXmlProperty(localName = "courierBarcodes")
    private CourierBarcodes courierBarcodes; // CourierBarcodes, no

    /**
     * Array of courier tracking numbers, if available.
     */
    @JacksonXmlProperty(localName = "courierTrackingNumbers")
    private CourierTrackingNumbers courierTrackingNumbers; // CourierTrackingNumbers, no

    /**
     * Array of courier tracking urls, if available.
     */
    @JacksonXmlProperty(localName = "courierTrackingUrls")
    private CourierTrackingUrls courierTrackingUrls; // CourierTrackingUrls, no
}