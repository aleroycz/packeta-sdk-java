package com.packeta.sdk.model.declaration;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * It is deprecated. Use attributes and items.
 * Is an array of type CustomsDeclarationItem.
 */
@Deprecated
@JacksonXmlRootElement(localName = "customsDeclarationItems")
public class CustomsDeclarationItems extends ArrayList<CustomsDeclarationItem> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    public ArrayList<CustomsDeclarationItem> getItems() {
        return this;
    }
}