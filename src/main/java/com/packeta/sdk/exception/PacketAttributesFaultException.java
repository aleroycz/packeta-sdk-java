package com.packeta.sdk.exception;

import lombok.Getter;

import java.util.List;

/**
 * One or more packet attributes are invalid (most common when creating packets).
 * Usually contains detailed list of field errors.
 */
@Getter
public class PacketAttributesFaultException extends PacketaApiException {

    private final List<AttributeFault> attributeFaults;

    public PacketAttributesFaultException(String faultCode, String message, List<AttributeFault> attributeFaults) {
        super(faultCode, message);
        this.attributeFaults = attributeFaults != null ? List.copyOf(attributeFaults) : List.of();
    }

    public record AttributeFault(String field, String message) {

        @Override
        public String toString() {
            return field != null ? field + ": " + message : message;
        }
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        if (!attributeFaults.isEmpty()) {
            sb.append("\nInvalid fields:\n");
            attributeFaults.forEach(f -> sb.append("  • ").append(f).append("\n"));
        }
        return sb.toString();
    }
}