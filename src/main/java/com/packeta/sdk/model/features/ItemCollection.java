package com.packeta.sdk.model.features;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.model.Item;

import java.util.ArrayList;

/**
 * It represents things in the packet. Is an array of type Item.
 */
@JacksonXmlRootElement(localName = "itemCollection")
public class ItemCollection extends ArrayList<Item> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    public ArrayList<Item> getItems() {
        return this;
    }
}