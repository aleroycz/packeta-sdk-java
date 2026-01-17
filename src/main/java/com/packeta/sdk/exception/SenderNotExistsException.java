package com.packeta.sdk.exception;

import lombok.Getter;

/**
 * Sender/eshop with given name does not exist (and cannot be auto-created in this context).
 */
@Getter
public class SenderNotExistsException extends PacketaApiException {

    private final String eshopName;

    public SenderNotExistsException(String faultCode, String message, String eshopName) {
        super(faultCode, message);
        this.eshopName = eshopName;
    }
}