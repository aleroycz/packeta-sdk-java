package com.packeta.sdk.model.carrier;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of objects courierNumber which contain a string identifier of the external courier's number of the packet.
 */
@JacksonXmlRootElement(localName = "courierNumbers")
public class CourierNumbers extends ArrayList<String> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "courierNumber")
    public ArrayList<String> getCourierNumbers() {
        return this;
    }
}