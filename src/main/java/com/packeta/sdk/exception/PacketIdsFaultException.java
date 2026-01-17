package com.packeta.sdk.exception;

import lombok.Getter;

import java.util.List;

/**
 * Thrown when multiple packet IDs are invalid or not found.
 * Corresponds to fault code: packetIdsFault
 */
@Getter
public class PacketIdsFaultException extends PacketaApiException {

    private final List<String> invalidPacketIds; // Optional: list of problematic IDs

    public PacketIdsFaultException(String faultCode, String message) {
        super(faultCode, message);
        this.invalidPacketIds = null;
    }

    public PacketIdsFaultException(String faultCode, String message, List<String> invalidPacketIds) {
        super(faultCode, message);
        this.invalidPacketIds = invalidPacketIds != null ? List.copyOf(invalidPacketIds) : null;
    }

}