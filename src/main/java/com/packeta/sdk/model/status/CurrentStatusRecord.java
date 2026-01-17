package com.packeta.sdk.model.status;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * An extension of StatusRecord, so it contains the same and some additional fields.
 */
@JacksonXmlRootElement(localName = "currentStatusRecord")
@Data
@EqualsAndHashCode(callSuper = true)
public class CurrentStatusRecord extends StatusRecord {
    /**
     * Indicates whether the packet is on its way back to the sender.
     */
    @JacksonXmlProperty(localName = "isReturning")
    private Boolean isReturning; // boolean, yes

    /**
     * The last possible day to pick up the packet. After this date, it will start returning to the sender.
     */
    @JacksonXmlProperty(localName = "storedUntil")
    private LocalDate storedUntil; // date, yes

    /**
     * Numeric identifier of the chosen carrier method.
     */
    @JacksonXmlProperty(localName = "carrierId")
    private Integer carrierId; // unsignedInt, no

    /**
     * Name of the chosen carrier method, in english.
     */
    @JacksonXmlProperty(localName = "carrierName")
    private String carrierName; // string, no
}