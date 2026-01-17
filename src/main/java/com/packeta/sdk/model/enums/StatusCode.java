package com.packeta.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum StatusCode {
    RECEIVED_DATA(1, "received data"),
    ACCEPTED(2, "accepted"),
    UNKNOWN(999, "unknown");

    private final int code;
    private final String text;

    StatusCode(int code, String text) {
        this.code = code;
        this.text = text;
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}