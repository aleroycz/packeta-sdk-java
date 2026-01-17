package com.packeta.sdk.exception;

/**
 * Generic fault when arguments are invalid/missing/incorrect format.
 */
public class ArgumentsFaultException extends PacketaApiException {

    public ArgumentsFaultException(String faultCode, String message) {
        super(faultCode, message);
    }
}