package com.packeta.sdk.model.carrier;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of courierTrackingUrl.
 */
@JacksonXmlRootElement(localName = "courierTrackingUrls")
public class CourierTrackingUrls extends ArrayList<CourierTrackingUrl> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "courierTrackingUrl")
    public ArrayList<CourierTrackingUrl> getCourierTrackingUrls() {
        return this;
    }
}