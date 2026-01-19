package com.packeta.sdk.model.feed;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

// ─────────────────────────────────────────────────────────────────────────────
// CarrierPudo – nice colorful console representation
// ─────────────────────────────────────────────────────────────────────────────

@Data
public class CarrierPudo {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("points")
    private List<Point> points;

    private static final String RESET  = "\u001B[0m";
    private static final String CYAN   = "\u001B[36m";
    private static final String GREEN  = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";
    private static final String BOLD   = "\u001B[1m";

    @Override
    public String toString() {
        int pointCount = points != null ? points.size() : 0;

        StringBuilder sb = new StringBuilder();

        sb.append(CYAN).append("┌────────────────────── Pickup Points (PUDO) ──────────────────────┐").append(RESET).append("\n");
        sb.append("│ ").append(BOLD).append(PURPLE).append(String.format("%-40s", name != null ? name : "—")).append(RESET).append(" │\n");
        sb.append("├──────────────────────────────────────────────────────────────────────┤").append("\n");
        sb.append("│  ").append(String.format("%-18s", "Carrier ID")).append(": ").append(id != null ? id : "—").append(" ".repeat(40)).append("│\n");
        sb.append("│  ").append(String.format("%-18s", "Pickup Points")).append(": ")
                .append(GREEN).append(pointCount).append(RESET)
                .append(pointCount == 1 ? " point " : " points ")
                .append(" ".repeat(30)).append("│\n");

        if (pointCount > 0) {
            sb.append("├──────────────────────────────────────────────────────────────────────┤").append("\n");
            int maxPreview = Math.min(5, pointCount);
            for (int i = 0; i < maxPreview; i++) {
                Point p = points.get(i);
                String pointInfo = String.format("%s (%s)",
                        p.getCode() != null ? p.getCode() : "—",
                        p.getDisplayFrontend() != null ? "#" + p.getDisplayFrontend() : "?");
                sb.append("│  • ").append(YELLOW).append(String.format("%-54s", pointInfo)).append(RESET).append("│\n");
            }
            if (pointCount > maxPreview) {
                sb.append("│  … and ").append(pointCount - maxPreview)
                        .append(" more ").append(pointCount - maxPreview == 1 ? "point" : "points").append(" ".repeat(30)).append("│\n");
            }
        }

        sb.append("└──────────────────────────────────────────────────────────────────────┘").append(RESET);

        return sb.toString();
    }
}