package com.packeta.sdk.model.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * DTO for Packeta Box (Z-BOX / locker) from /box/json feed.
 * Similar structure to Branch but with box-specific fields.
 */
@Data
public class Box {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("type")
    private String type; // e.g. "zbox"

    @JsonProperty("name")
    private String name;

    @JsonProperty("place")
    private String place;

    @JsonProperty("street")
    private String street;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("country")
    private String country;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("status")
    private Branch.Status status;

    @JsonProperty("codAllowed")
    private Integer codAllowed;

    @JsonProperty("displayFrontend")
    private Integer displayFrontend;

    @JsonProperty("directions")
    private String directions;

    @JsonProperty("directionsCar")
    private String directionsCar;

    @JsonProperty("directionsPublic")
    private String directionsPublic;

    @JsonProperty("wheelchairAccessible")
    private String wheelchairAccessible;

    @JsonProperty("creditCardPayment")
    private String creditCardPayment;

    @JsonProperty("dressingRoom")
    private Integer dressingRoom;

    @JsonProperty("claimAssistant")
    private Integer claimAssistant;

    @JsonProperty("packetConsignment")
    private Integer packetConsignment;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("url")
    private String url;

    @JsonProperty("maxWeight")
    private Integer maxWeight;

    @JsonProperty("hasKeypad")
    private Integer hasKeypad;

    @JsonProperty("labelRouting")
    private String labelRouting;

    @JsonProperty("labelName")
    private String labelName;

    @JsonProperty("photos")
    private List<Branch.Photo> photos;

    @JsonProperty("openingHours")
    private Branch.OpeningHours openingHours;
}