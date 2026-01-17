package com.packeta.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CountryCode {
    CZ, SK, HU, PL, RO;

    @JsonValue
    public String getValue() {
        return name().toLowerCase();
    }
}