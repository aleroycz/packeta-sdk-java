package com.packeta.sdk.model.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Point {
    @JsonProperty("code")
    private String code;

    @JsonProperty("coordinates")
    private Coordinates coordinates;

    @JsonProperty("street")
    private String street;

    @JsonProperty("streetNumber")
    private String streetNumber;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("country")
    private String country;

    @JsonProperty("payment")
    private String payment;

    @JsonProperty("displayFrontend")
    private Integer displayFrontend;
}
