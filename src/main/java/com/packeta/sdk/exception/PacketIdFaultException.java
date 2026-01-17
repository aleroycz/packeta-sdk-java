package com.packeta.sdk.exception;

public class PacketIdFaultException extends PacketaApiException {
    public PacketIdFaultException(String faultCode, String faultString) {
        super(faultCode, faultString);
    }
}
