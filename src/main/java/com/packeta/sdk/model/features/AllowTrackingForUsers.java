package com.packeta.sdk.model.features;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.model.security.ApiKeys;
import lombok.Data;

/**
 * Packet collection.
 */
@JacksonXmlRootElement(localName = "allowTrackingForUsers")
@Data
public class AllowTrackingForUsers {
    /**
     * Packet collection.
     */
    @JacksonXmlProperty(localName = "apiKeys")
    private ApiKeys apiKeys; // ApiKeys, yes
}