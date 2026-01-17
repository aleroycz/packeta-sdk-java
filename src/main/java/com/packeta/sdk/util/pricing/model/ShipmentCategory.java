package com.packeta.sdk.util.pricing.model;

import java.math.BigDecimal;

public record ShipmentCategory(BigDecimal weightKg, int maxSideMm, int sumSidesMm) {
    boolean fits(WeightBracket b) {
        double w = weightKg.doubleValue();
        if (w > b.maxWeight()) return false;

        int maxSideCm = maxSideMm / 10;
        int sumCm = sumSidesMm / 10;

        // Safety: if dimensions are suspiciously small (e.g. < 10 cm sum), probably error
        if (sumCm < 10 && maxSideMm > 0) {
            System.out.println("WARNING: Suspiciously small dimensions detected: sum " + sumCm + " cm");
        }

        return maxSideCm <= b.maxSideCm() && sumCm <= b.sumSidesCm();
    }
}
