package com.packeta.sdk.model.security;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of objects apiKey which contain a string value user's API key (16 characters).
 */
@JacksonXmlRootElement(localName = "apiKeys")
public class ApiKeys extends ArrayList<String> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "apiKey")
    public ArrayList<String> getApiKeys() {
        return this;
    }
}