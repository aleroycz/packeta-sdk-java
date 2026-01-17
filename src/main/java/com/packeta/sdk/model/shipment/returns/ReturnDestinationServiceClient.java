package com.packeta.sdk.model.shipment.returns;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Client information for return.
 */
@JacksonXmlRootElement(localName = "returnDestinationServiceClient")
@Data
public class ReturnDestinationServiceClient {
    /**
     * API key of the client.
     * Constraints: length=16.
     */
    @JacksonXmlProperty(localName = "apiKey")
    private String apiKey; // string, yes

    /**
     * Sender indication. If the entered sender does not exist yet, a new one is created.
     */
    @JacksonXmlProperty(localName = "eshop")
    private String eshop; // string, yes
}