package com.packeta.sdk.model.carrier;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of objects courierBarcode which contain a string barcode from the courier's label.
 */
@JacksonXmlRootElement(localName = "courierBarcodes")
public class CourierBarcodes extends ArrayList<String> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "courierBarcode")
    public ArrayList<String> getCourierBarcodes() {
        return this;
    }
}