package com.packeta.sdk.exception;

public class PacketaApiExceptionCustom extends PacketaApiException {
    public PacketaApiExceptionCustom(String faultCode, String faultString) {
        super(faultCode, faultString);
    }

    public PacketaApiExceptionCustom(String faultCode, String faultString, Throwable cause) {
        super(faultCode, faultString, cause);
    }
}
