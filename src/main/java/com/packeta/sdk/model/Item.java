package com.packeta.sdk.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.model.attr.AttributeCollection;
import lombok.Data;

/**
 * It represent one kind of thing in the packet. Is an array of type Attribute.
 */
@JacksonXmlRootElement(localName = "item")
@Data
public class Item {
    // Note: Since it's described as an array of Attribute, but as a single item, perhaps it contains AttributeCollection?
    // Based on description, it might be a wrapper or directly attributes. Assuming it extends or contains AttributeCollection.
    // But to match, perhaps:
    @JacksonXmlProperty(localName = "attributes")
    private AttributeCollection attributes;
}