package com.packeta.sdk.model.carrier;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * A list of tracking URLs of external courier's tracking application.
 */
@JacksonXmlRootElement(localName = "courierTrackingUrl")
@Data
public class CourierTrackingUrl {
    /**
     * Language of the tracking web page.
     * Constraints: 2 letters.
     */
    @JacksonXmlProperty(localName = "lang")
    private String lang; // string, yes

    /**
     * Tracking URL.
     */
    @JacksonXmlProperty(localName = "url")
    private String url; // string, yes
}