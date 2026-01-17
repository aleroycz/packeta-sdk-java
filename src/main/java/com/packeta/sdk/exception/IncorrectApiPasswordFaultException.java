package com.packeta.sdk.exception;

/**
 * Incorrect/missing API password in request.
 */
public class IncorrectApiPasswordFaultException extends PacketaApiException {

    public IncorrectApiPasswordFaultException(String faultCode, String message) {
        super(faultCode, message);
    }
}