package com.packeta.sdk.exception;

import lombok.Getter;

/**
 * Thrown when a requested shipment is not found.
 * Corresponds to fault code: shipmentNotFound
 */
@Getter
public class ShipmentNotFoundFaultException extends PacketaApiException {

    private final String shipmentId; // Optional: the missing shipment ID/code

    public ShipmentNotFoundFaultException(String faultCode, String message) {
        super(faultCode, message);
        this.shipmentId = null;
    }

    public ShipmentNotFoundFaultException(String faultCode, String message, String shipmentId) {
        super(faultCode, message);
        this.shipmentId = shipmentId;
    }

}