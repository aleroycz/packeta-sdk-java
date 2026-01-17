package com.packeta.sdk.model.attr;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * It represents additional information about packet or packet item. Is an array of type Attribute.
 */
@JacksonXmlRootElement(localName = "attributeCollection")
public class AttributeCollection extends ArrayList<Attribute> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "attribute")
    public ArrayList<Attribute> getAttributes() {
        return this;
    }
}