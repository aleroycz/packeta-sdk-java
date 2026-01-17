package com.packeta.sdk.model.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DTO for carrier (home delivery) from /carrier/json feed.
 */
@Data
public class Carrier {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("available")
    private Boolean available;

    @JsonProperty("pickupPoints")
    private Boolean pickupPoints;

    @JsonProperty("apiAllowed")
    private Boolean apiAllowed;

    @JsonProperty("separateHouseNumber")
    private Boolean separateHouseNumber;

    @JsonProperty("customsDeclarations")
    private Boolean customsDeclarations;

    @JsonProperty("requiresEmail")
    private Boolean requiresEmail;

    @JsonProperty("requiresPhone")
    private Boolean requiresPhone;

    @JsonProperty("requiresSize")
    private Boolean requiresSize;

    @JsonProperty("disallowsCod")
    private Boolean disallowsCod;

    @JsonProperty("country")
    private String country;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("maxWeight")
    private Integer maxWeight;

    @JsonProperty("labelRouting")
    private String labelRouting;

    @JsonProperty("labelName")
    private String labelName;
}