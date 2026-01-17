package com.packeta.sdk.model.status.external;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

/**
 * An array of type ExternalStatusRecord.
 */
@JacksonXmlRootElement(localName = "externalStatusRecords")
public class ExternalStatusRecords extends ArrayList<ExternalStatusRecord> {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "externalStatusRecord")
    public ArrayList<ExternalStatusRecord> getExternalStatusRecords() {
        return this;
    }
}