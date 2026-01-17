package com.packeta.sdk.model.claims;

import com.packeta.sdk.model.enums.Currency;
import com.packeta.sdk.model.enums.CountryCode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Attributes for claim with password.
 */
@JacksonXmlRootElement(localName = "claimWithPasswordAttributes")
@Data
public class ClaimWithPasswordAttributes {
    /**
     * Deprecated attribute.
     * Constraints: 10 digits.
     */
    @JacksonXmlProperty(localName = "id")
    @Deprecated
    private Long id; // unsignedLong, no

    /**
     * An unique ID of the order (from your e-shop).
     * Constraints: 1-36 alphanumeric.
     */
    @JacksonXmlProperty(localName = "number")
    private String number; // string, yes

    /**
     * Your customer's email.
     * Constraints: valid email.
     */
    @JacksonXmlProperty(localName = "email")
    private String email; // string, no

    /**
     * Your customer's phone.
     * Constraints: valid phone number, examples are in phone number formats.
     */
    @JacksonXmlProperty(localName = "phone")
    private String phone; // string, no

    /**
     * Packet's value (for insurance purposes).
     * Constraints: see max values in TOS.
     */
    @JacksonXmlProperty(localName = "value")
    private BigDecimal value; // decimal, yes

    /**
     * Packet value currency.
     * Constraints: CZK, EUR, HUF, PLN, RON.
     */
    @JacksonXmlProperty(localName = "currency")
    private Currency currency; // string, no

    /**
     * Sender indication. If the entered sender does not exist yet, a new one is created.
     */
    @JacksonXmlProperty(localName = "eshop")
    private String eshop; // string, yes

    /**
     * Country where packet will be consigned and in which language notification will be sent.
     * Constraints: 2 alphanumerical.
     */
    @JacksonXmlProperty(localName = "consignCountry")
    private CountryCode consignCountry; // string, no

    /**
     * If set to true, email and consignCountry attributes will become required and email with password and instructions will be sent to your customer.
     */
    @JacksonXmlProperty(localName = "sendEmailToCustomer")
    private Boolean sendEmailToCustomer; // bool, no

    /**
     * Defines additional security options.
     */
    @JacksonXmlProperty(localName = "security")
    private Security security; // Security, no
}