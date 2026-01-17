package com.packeta.sdk.exception;

/**
 * Requested date is out of allowed range (e.g. deliverOn too far in future/past).
 */
public class DateOutOfRangeFaultException extends PacketaApiException {

    public DateOutOfRangeFaultException(String faultCode, String message) {
        super(faultCode, message);
    }
}