package com.packeta.sdk.model.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Response DTO from /carrier_point/json feed.
 */
@Data
public class CarriersPudosResponse {
    @JsonProperty("carriers")
    private List<CarrierPudo> carriers;
}
