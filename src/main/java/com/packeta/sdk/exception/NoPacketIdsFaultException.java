package com.packeta.sdk.exception;

/**
 * Thrown when no valid packet IDs were provided for an operation
 * (e.g. shipment creation with empty list).
 * Corresponds to fault code: noPacketIds
 */
public class NoPacketIdsFaultException extends PacketaApiException {

    public NoPacketIdsFaultException(String faultCode, String message) {
        super(faultCode, message);
    }
}