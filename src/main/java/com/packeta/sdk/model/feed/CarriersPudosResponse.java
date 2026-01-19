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

    private static final String RESET = "\u001B[0m";
    private static final String CYAN  = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String BOLD  = "\u001B[1m";

    @Override
    public String toString() {
        int carrierCount = carriers != null ? carriers.size() : 0;

        StringBuilder sb = new StringBuilder();

        sb.append(CYAN)
                .append("╔════════════════════════════════════════════════════════════════════╗\n")
                .append("║                  ").append(BOLD).append("PUDO Carriers Response").append(RESET).append(CYAN).append("                    ║\n")
                .append("╚════════════════════════════════════════════════════════════════════╝").append(RESET).append("\n\n");

        sb.append("  Total carriers: ").append(GREEN).append(carrierCount).append(RESET).append("\n");

        if (carrierCount == 0) {
            sb.append("  (no carriers found)\n");
        } else {
            sb.append("\n");
            for (int i = 0; i < carrierCount; i++) {  // limit preview
                CarrierPudo c = carriers.get(i);
                String name = c.getName() != null ? c.getName() : "—";
                int points = c.getPoints() != null ? c.getPoints().size() : 0;
                sb.append(String.format("  %2d. %-38s %s %3d %s\n",
                        i + 1,
                        name.length() > 38 ? name.substring(0, 35) + "..." : name,
                        GREEN + "•" + RESET,
                        points,
                        points == 1 ? "point " : "points"));
            }
        }

        return sb.toString();
    }
}