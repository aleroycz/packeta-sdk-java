package com.packeta.sdk.model.carrier;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of objects courierTrackingNumber which contain a string number that is used on courier's online tracking application.
 */
@JacksonXmlRootElement(localName = "courierTrackingNumbers")
public class CourierTrackingNumbers extends ArrayList<String> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "courierTrackingNumber")
    public ArrayList<String> getCourierTrackingNumbers() {
        return this;
    }
}