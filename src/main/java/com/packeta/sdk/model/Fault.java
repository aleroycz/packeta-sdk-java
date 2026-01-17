package com.packeta.sdk.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.exception.PacketAttributesFaultException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the <fault> root element in Packeta error responses.
 * Used when parsing XML fault responses from the API.
 */
@JacksonXmlRootElement(localName = "fault")
@Data
public class Fault {

    @JacksonXmlProperty(localName = "faultCode")
    private String faultCode;

    @JacksonXmlProperty(localName = "faultString")
    private String faultString;

    /**
     * Optional detail message (sometimes present in specific faults).
     */
    @JacksonXmlProperty(localName = "detail")
    private String detail;

    /**
     * List of attribute-specific validation errors (mainly for packetAttributesFault).
     */
    @JacksonXmlElementWrapper(localName = "attributeFaults")
    @JacksonXmlProperty(localName = "attributeFault")
    private List<PacketAttributesFaultException.AttributeFault> attributeFaults = new ArrayList<>();

}