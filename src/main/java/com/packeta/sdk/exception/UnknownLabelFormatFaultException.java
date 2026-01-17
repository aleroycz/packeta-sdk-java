package com.packeta.sdk.exception;

import lombok.Getter;

/**
 * Requested label format is not supported/unknown.
 */
@Getter
public class UnknownLabelFormatFaultException extends PacketaApiException {

    private final String requestedFormat;

    public UnknownLabelFormatFaultException(String faultCode, String message, String requestedFormat) {
        super(faultCode, message);
        this.requestedFormat = requestedFormat;
    }
}