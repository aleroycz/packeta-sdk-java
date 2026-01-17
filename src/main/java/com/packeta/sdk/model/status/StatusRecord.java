package com.packeta.sdk.model.status;

import com.packeta.sdk.model.enums.StatusCode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * Represents a status record for packet tracking.
 */
@JacksonXmlRootElement(localName = "statusRecord")
@Data
public class StatusRecord {
    /**
     * Date and time of the status change. The format is Y-m-d\TH:i:s, example: 2016-07-25T12:00:00.
     */
    @JacksonXmlProperty(localName = "dateTime")
    private OffsetDateTime dateTime; // dateTime, yes

    /**
     * Integer status code, see the status code table for more info.
     */
    @JacksonXmlProperty(localName = "statusCode")
    private StatusCode statusCode; // unsignedInt, yes

    /**
     * Text representation of the code, see the status code table for more info.
     */
    @JacksonXmlProperty(localName = "codeText")
    private String codeText; // string, yes

    /**
     * Text description of the status.
     */
    @JacksonXmlProperty(localName = "statusText")
    private String statusText; // string, yes

    /**
     * ID of the position of the packet in the moment of the last status change. Defaults to 0 if the branch data is not available.
     */
    @JacksonXmlProperty(localName = "branchId")
    private Integer branchId; // unsignedInt, yes

    /**
     * If status change regards moving to different branch, this field contains the ID of the destination branch. Defaults to 0 if the field is not relevant.
     */
    @JacksonXmlProperty(localName = "destinationBranchId")
    private Integer destinationBranchId; // unsignedInt, yes

    /**
     * If the packet is being delivered by an external carrier and this status change indicates handing over of the packet to the carrier, you can find the carrier's tracking code here.
     */
    @JacksonXmlProperty(localName = "externalTrackingCode")
    private String externalTrackingCode; // string, ne (likely 'no')
}