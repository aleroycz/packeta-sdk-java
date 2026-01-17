package com.packeta.sdk.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LabelFormat {
    A6_ON_A4("A6 on A4"),
    A7_ON_A4("A7 on A4");

    private final String value;

    LabelFormat(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}