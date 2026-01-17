package com.packeta.sdk.exception;

import lombok.Getter;

import java.util.List;

/**
 * Base exception for all Packeta API related errors.
 */
@Getter
public abstract class PacketaApiException extends Exception {

    private final String faultCode;
    private final String faultString;

    public PacketaApiException(String faultCode, String faultString) {
        super(String.format("[%s] %s", faultCode, faultString));
        this.faultCode = faultCode;
        this.faultString = faultString;
    }

    public PacketaApiException(String faultCode, String faultString, Throwable cause) {
        super(String.format("[%s] %s", faultCode, faultString), cause);
        this.faultCode = faultCode;
        this.faultString = faultString;
    }

    /**
     * @return true if the error is transient and the operation should be retried
     */
    public boolean isRetryable() {
        return false;
    }
}