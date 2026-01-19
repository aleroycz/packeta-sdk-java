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

    @Override
    public String toString() {
        // ANSI color codes
        final String RESET  = "\u001B[0m";
        final String RED    = "\u001B[31m";
        final String GREEN  = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE   = "\u001B[34m";
        final String CYAN   = "\u001B[36m";
        final String PURPLE = "\u001B[35m";
        final String BOLD   = "\u001B[1m";

        // Status indicators
        final String YES = GREEN + "✔ yes" + RESET;
        final String NO  = RED   + "✘ no"  + RESET;

        // Prepared formatted values
        String nameStr   = name   != null ? BOLD + PURPLE + name + RESET : "—";
        String countryStr   = country   != null ? BLUE    + country   + RESET : "—";
        String currencyStr  = currency  != null ? YELLOW  + currency  + RESET : "—";
        String labelStr     = labelRouting != null ? CYAN + labelRouting + RESET : "—";

        String codStr = (disallowsCod != null && disallowsCod)
                ? RED + "✖ NO COD" + RESET
                : GREEN + "COD allowed" + RESET;

        String maxWeightStr = (maxWeight != null)
                ? (maxWeight > 0 ? String.valueOf(maxWeight) : RED + "0" + RESET)
                : "—";

        // Layout configuration
        final int LABEL_WIDTH = 18;
        final int INNER_WIDTH = 50;
        final int TOTAL_WIDTH = INNER_WIDTH + 4; // including │   │ borders

        // Dynamic centered title
        String title = String.format(" Carrier #%d ", id);
        int titlePadding = Math.max(0, (INNER_WIDTH - title.length()) / 2);
        String titleLine = "┌"
                + "─".repeat(titlePadding)
                + title
                + "─".repeat(INNER_WIDTH - title.length() - titlePadding)
                + "┐";

        // ──────────────────────────────────────────────────────────────

        return String.format(
                CYAN + titleLine + RESET + "\n" +
                        "│ %-" + INNER_WIDTH + "s │\n" +
                        "├" + "─".repeat(TOTAL_WIDTH - 2) + "┤\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s kg │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "│ %-" + LABEL_WIDTH + "s : %s │\n" +
                        "└" + "─".repeat(TOTAL_WIDTH - 2) + "┘" + RESET,

                nameStr,

                "Available",          available != null && available ? YES : NO,
                "API Allowed",        apiAllowed != null && apiAllowed ? YES : NO,
                "Pickup Points",      pickupPoints != null && pickupPoints ? YES : NO,
                "Separate House No.", separateHouseNumber != null && separateHouseNumber ? YES : NO,
                "Customs Declarations", customsDeclarations != null && customsDeclarations ? YES : NO,
                "Requires Email",     requiresEmail != null && requiresEmail ? YES : NO,
                "Requires Phone",     requiresPhone != null && requiresPhone ? YES : NO,
                "Requires Size",      requiresSize != null && requiresSize ? YES : NO,
                "COD",                codStr,
                "Max Weight",         maxWeightStr,
                "Country / Currency", countryStr + "  " + currencyStr,
                "Label Routing",      labelStr
        );
    }
}