package com.packeta.sdk.exception;

import com.packeta.sdk.model.PacketaErrorResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class PacketAttributesFaultException extends PacketaApiException {

    private final List<PacketaErrorResponse.AttributeFault> attributeFaults;

    public PacketAttributesFaultException(
            String faultCode,
            String message,
            List<PacketaErrorResponse.AttributeFault> attributeFaults) {
        super(faultCode, message);
        this.attributeFaults = attributeFaults != null ? List.copyOf(attributeFaults) : List.of();
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