package com.packeta.sdk.model.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * DTO for Packeta branch (pick-up point) from /branch/json feed.
 */
@Data
public class Branch {
    @JsonProperty("id")
    private Integer id;

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
    private Status status;

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

    @JsonProperty("labelRouting")
    private String labelRouting;

    @JsonProperty("labelName")
    private String labelName;

    @JsonProperty("photos")
    private List<Photo> photos;

    @JsonProperty("openingHours")
    private OpeningHours openingHours;

    // Nested classes
    @Data
    public static class Status {
        @JsonProperty("statusId")
        private Integer statusId;

        @JsonProperty("description")
        private String description;
    }

    @Data
    public static class Photo {
        @JsonProperty("thumbnail")
        private String thumbnail;

        @JsonProperty("normal")
        private String normal;
    }

    @Data
    public static class OpeningHours {
        @JsonProperty("regular")
        private Regular regular;

        @JsonProperty("upcoming")
        private Upcoming upcoming;

        @JsonProperty("exceptions")
        private List<Exception> exceptions;
    }

    @Data
    public static class Regular {
        private String monday;
        private String tuesday;
        private String wednesday;
        private String thursday;
        private String friday;
        private String saturday;
        private String sunday;
    }

    @Data
    public static class Upcoming {
        private String monday;
        private String tuesday;
        private String wednesday;
        private String thursday;
        private String friday;
        private String saturday;
        private String sunday;
        @JsonProperty("startDate")
        private String startDate;
    }

    @Data
    public static class Exception {
        @JsonProperty("date")
        private String date;

        @JsonProperty("hours")
        private String hours;
    }
}