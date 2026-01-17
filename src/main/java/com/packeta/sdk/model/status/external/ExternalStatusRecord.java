package com.packeta.sdk.model.status.external;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * External status record for tracking.
 */
@JacksonXmlRootElement(localName = "externalStatusRecord")
@Data
public class ExternalStatusRecord {
    /**
     * Date and time of the status change. The format is Y-m-d\TH:i:s, example: 2016-07-25T12:00:00.
     */
    @JacksonXmlProperty(localName = "dateTime")
    private OffsetDateTime dateTime; // dateTime, yes

    /**
     * External carrier identificator, example: czpacketahome.
     */
    @JacksonXmlProperty(localName = "carrierClass")
    private String carrierClass; // string, yes

    /**
     * Text representation of the status code from external carrier.
     */
    @JacksonXmlProperty(localName = "statusCode")
    private String statusCode; // string, yes

    /**
     * Text description of the status.
     */
    @JacksonXmlProperty(localName = "externalStatusName")
    private String externalStatusName; // string, yes

    /**
     * Additional note for status.
     */
    @JacksonXmlProperty(localName = "externalNote")
    private String externalNote; // string, no

    /**
     * External carrier's tracking code.
     */
    @JacksonXmlProperty(localName = "externalTrackingCode")
    private String externalTrackingCode; // string, no
}