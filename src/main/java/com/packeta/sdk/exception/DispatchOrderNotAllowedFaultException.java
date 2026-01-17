package com.packeta.sdk.exception;

/**
 * Trying to create dispatch order when not allowed (e.g. wrong state, missing permissions).
 */
public class DispatchOrderNotAllowedFaultException extends PacketaApiException {

    public DispatchOrderNotAllowedFaultException(String faultCode, String message) {
        super(faultCode, message);
    }
}