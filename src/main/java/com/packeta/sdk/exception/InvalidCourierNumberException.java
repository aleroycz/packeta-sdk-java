package com.packeta.sdk.exception;

import lombok.Getter;

/**
 * Thrown when an invalid courier number is provided
 * (e.g. for carrier label printing).
 * Corresponds to fault code: invalidCourierNumber
 */
@Getter
public class InvalidCourierNumberException extends PacketaApiException {

    private final String courierNumber; // Optional: the invalid value

    public InvalidCourierNumberException(String faultCode, String message) {
        super(faultCode, message);
        this.courierNumber = null;
    }

    public InvalidCourierNumberException(String faultCode, String message, String courierNumber) {
        super(faultCode, message);
        this.courierNumber = courierNumber;
    }

}