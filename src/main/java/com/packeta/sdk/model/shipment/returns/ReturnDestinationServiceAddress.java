package com.packeta.sdk.model.shipment.returns;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Service to override default return address for a single packet. Note: Country is retrieved from addressId of the parent element (branch/carrier).
 */
@JacksonXmlRootElement(localName = "returnDestinationServiceAddress")
@Data
public class ReturnDestinationServiceAddress {
    @JacksonXmlProperty(localName = "name")
    private String name; // string, Yes

    @JacksonXmlProperty(localName = "surname")
    private String surname; // string, Yes

    @JacksonXmlProperty(localName = "street")
    private String street; // string, Yes

    @JacksonXmlProperty(localName = "houseNumber")
    private String houseNumber; // string, Yes

    @JacksonXmlProperty(localName = "city")
    private String city; // string, Yes

    /**
     * Constraints: maxLength=255.
     */
    @JacksonXmlProperty(localName = "zip")
    private String zip; // string, Yes

    /**
     * *The requirement of this parameter differ per carrier.
     * Constraints: email pattern.
     */
    @JacksonXmlProperty(localName = "email")
    private String email; // string, No

    /**
     * *The requirement of this parameter differ per carrier.
     * Constraints: maxLength=20.
     */
    @JacksonXmlProperty(localName = "phone")
    private String phone; // string, No
}