package com.packeta.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {
    CZK, EUR, HUF, PLN, RON;

    @JsonValue
    public String getValue() {
        return name();
    }
}