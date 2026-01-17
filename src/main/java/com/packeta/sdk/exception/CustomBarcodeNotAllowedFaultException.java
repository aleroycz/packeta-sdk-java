package com.packeta.sdk.exception;

/**
 * Custom barcode usage is not allowed for this account/sender.
 */
public class CustomBarcodeNotAllowedFaultException extends PacketaApiException {

    public CustomBarcodeNotAllowedFaultException(String faultCode, String message) {
        super(faultCode, message);
    }
}