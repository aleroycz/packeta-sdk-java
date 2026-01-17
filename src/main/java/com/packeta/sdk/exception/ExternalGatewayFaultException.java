package com.packeta.sdk.exception;

import lombok.Getter;

/**
 * External carrier/gateway error - **usually retryable**.
 */
@Getter
public class ExternalGatewayFaultException extends PacketaApiException {

    public ExternalGatewayFaultException(String faultCode, String message) {
        super(faultCode, message);
    }

    @Override
    public boolean isRetryable() {
        return true;
    }
}