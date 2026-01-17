package com.packeta.sdk.exception;

/**
 * Trying to cancel packet in state where cancellation is not allowed.
 */
public class CancelNotAllowedFaultException extends PacketaApiException {

    public CancelNotAllowedFaultException(String faultCode, String message) {
        super(faultCode, message);
    }
}