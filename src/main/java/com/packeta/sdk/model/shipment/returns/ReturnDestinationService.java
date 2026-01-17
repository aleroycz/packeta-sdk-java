package com.packeta.sdk.model.shipment.returns;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Service to override default return address for a single packet.
 */
@JacksonXmlRootElement(localName = "returnDestinationService")
@Data
public class ReturnDestinationService {
    /**
     * Id of branch or external carrier.
     */
    @JacksonXmlProperty(localName = "addressId")
    private Integer addressId;

    /**
     * Id of carrier's pick-up point or box.
     * Constraints: maxLength=64, nillable.
     */
    @JacksonXmlProperty(localName = "carrierPickupPoint")
    private String carrierPickupPoint;

    /**
     * Address, required in the case of using an carrier HD or box.
     */
    @JacksonXmlProperty(localName = "returnAddress")
    private ReturnDestinationServiceAddress returnAddress;

    /**
     * Client information for return.
     */
    @JacksonXmlProperty(localName = "client")
    private ReturnDestinationServiceClient client;
}