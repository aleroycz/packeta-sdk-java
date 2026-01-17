package com.packeta.sdk.model.carrier;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of objects CourierInfoItem.
 */
@JacksonXmlRootElement(localName = "courierInfo")
public class CourierInfo extends ArrayList<CourierInfoItem> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "courierInfoItem")
    public ArrayList<CourierInfoItem> getCourierInfoItems() {
        return this;
    }
}