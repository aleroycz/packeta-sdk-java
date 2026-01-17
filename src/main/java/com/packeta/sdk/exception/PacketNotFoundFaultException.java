package com.packeta.sdk.exception;

import lombok.Getter;

/**
 * Packet with given ID was not found.
 */
@Getter
public class PacketNotFoundFaultException extends PacketaApiException {

    private final Long packetId;

    public PacketNotFoundFaultException(String faultCode, String message, Long packetId) {
        super(faultCode, message);
        this.packetId = packetId;
    }
}