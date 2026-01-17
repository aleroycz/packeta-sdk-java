package com.packeta.sdk.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.exception.PacketAttributesFaultException;
import lombok.Data;

import java.util.List;

/**
 * Represents the <fault> root element in Packeta error responses.
 * Used when parsing XML fault responses from the API.
 */
@JacksonXmlRootElement(localName = "response")
@Data
public class PacketaErrorResponse {
    @JacksonXmlProperty(localName = "status")
    private String status; // always "fault" here

    @JacksonXmlProperty(localName = "fault")
    private String faultCode;

    @JacksonXmlProperty(localName = "string")
    private String faultString;

    @JacksonXmlProperty(localName = "detail")
    private Detail detail;

    @Data
    public static class Detail {
        @JacksonXmlElementWrapper(localName = "attributes")
        @JacksonXmlProperty(localName = "fault")
        private List<AttributeFault> attributes;
    }

    @Data
    public static class AttributeFault {
        @JacksonXmlProperty(localName = "name")
        private String name;   // ← matches <name>addressId</name>

        @JacksonXmlProperty(localName = "fault")
        private String fault;  // ← matches <fault>error message</fault>
    }
}