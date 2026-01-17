package com.packeta.sdk.model.status;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of type StatusRecord.
 */
@JacksonXmlRootElement(localName = "statusRecords")
public class StatusRecords extends ArrayList<StatusRecord> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "statusRecord")
    public ArrayList<StatusRecord> getStatusRecords() {
        return this;
    }
}