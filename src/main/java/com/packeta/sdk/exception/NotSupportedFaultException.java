package com.packeta.sdk.exception;

/**
 * Thrown when a requested operation or feature is not supported
 * (e.g. label format, carrier method, etc.).
 * Corresponds to fault code: notSupported
 */
public class NotSupportedFaultException extends PacketaApiException {

    public NotSupportedFaultException(String faultCode, String message) {
        super(faultCode, message);
    }
}