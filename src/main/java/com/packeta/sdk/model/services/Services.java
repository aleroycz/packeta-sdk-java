package com.packeta.sdk.model.services;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.model.shipment.returns.ReturnDestinationService;
import lombok.Data;

/**
 * This attribute has not yet been implemented. This is reserved record for future use.
 */
@JacksonXmlRootElement(localName = "services")
@Data
public class Services {
    /**
     * Specify external carrier that will deliver the packet into our network. Tracking starts before accepting packet into our network.
     */
    @JacksonXmlProperty(localName = "firstMileCarrier")
    private FirstMileCarrierService firstMileCarrier; // FirstMileCarrierService, no

    /**
     * Specify external carrier that will deliver the packet to the client. Allows sender to pass carrier data such as barcode or tracking code.
     */
    @JacksonXmlProperty(localName = "lastMileCarrier")
    private LastMileCarrierService lastMileCarrier; // LastMileCarrierService, no

    /**
     * Service to override default return address for a single packet.
     */
    @JacksonXmlProperty(localName = "returnDestination")
    private ReturnDestinationService returnDestination; // ReturnDestinationService, no
}