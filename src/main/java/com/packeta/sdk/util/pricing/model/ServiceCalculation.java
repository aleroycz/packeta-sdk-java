package com.packeta.sdk.util.pricing.model;

import com.packeta.sdk.util.pricing.enums.ServiceType;
import com.packeta.sdk.util.pricing.enums.TransportType;
import com.packeta.sdk.util.pricing.model.dto.CalculateForOrder;
import com.packeta.sdk.util.pricing.model.dto.CalculationResult;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record ServiceCalculation(
        ServiceType service,
        ShipmentCategory category,
        CalculateForOrder request
) {
    public boolean isValid() {
        return service.findBracket(category)
                .map(category::fits)
                .orElse(false);
    }

    public BigDecimal getBasePrice() {
        return service.findBracket(category)
                .map(b -> BigDecimal.valueOf(b.price()))
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal getNonDepotSurcharge() {
        return BigDecimal.TEN;
    }

    public BigDecimal getFuelSurcharge() {
        BigDecimal base = getBasePrice();
        return base.multiply(BigDecimal.valueOf(0.05)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTollSurcharge() {
        double weight = request.getWeightKg().doubleValue();
        if (weight <= 5.00) return BigDecimal.valueOf(2.10);
        if (weight <= 10.00) return BigDecimal.valueOf(4.80);
        return BigDecimal.valueOf(4.80);
    }

    public BigDecimal getCodSurchargeAmount() {
        BigDecimal cod = request.getCodAmount();
        if (cod == null || cod.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        return cod.multiply(getCodSurchargePercent()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalPrice() {
        return getBasePrice()
                .add(getNonDepotSurcharge())
                .add(getFuelSurcharge())
                .add(getTollSurcharge())
                .add(getCodSurchargeAmount())
                .add(getInsurancePrice())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public CalculationResult toResult() {
        BigDecimal codSurchargeAmount = getCodSurchargeAmount();

        return CalculationResult.builder()
                .request(request)
                .serviceName(service.getDisplayName())
                .transportType(TransportType.valueOf(service.name()))
                .basePrice(getBasePrice())
                .nonDepotSurcharge(getNonDepotSurcharge())
                .fuelSurcharge(getFuelSurcharge())
                .tollSurcharge(getTollSurcharge())
                .codSurchargePercent(getCodSurchargePercent().multiply(BigDecimal.valueOf(100)))
                .codSurchargeAmount(codSurchargeAmount)
                .insurancePrice(getInsurancePrice())
                .codAmount(request.getCodAmount())
                .totalPrice(getTotalPrice())
                .build();
    }

    /**
     * Returns the COD surcharge percentage for the given service (as decimal, e.g. 0.014 = 1.4%)
     */
    public BigDecimal getCodSurchargePercent() {
        return switch (service) {
            // Czech Republic (CZ) – most services
            case Z_POINT_PP, Z_BOX, HOME_STANDARD, EVENING_HD -> BigDecimal.valueOf(1.40).movePointLeft(2);

            // Hungary (HU) – 1.40% by card
            case HU_Z_POINT_PP, HU_HOME_DELIVERY_HD, HU_EXPRESS_ONE_HD, HU_FOXPOST_BOX,
                 HU_HUNGARIAN_POST_BOX, HU_HUNGARIAN_POST_HD, HU_HUNGARIAN_POST_PP, HU_Z_BOX ->
                    BigDecimal.valueOf(1.40).movePointLeft(2);

            // Poland (PL)
            case PL_Z_POINT_PP, PL_HOME_DELIVERY_HD, PL_INPOST_PACZKOMATY_BOX, PL_POLISH_POST_PP ->
                    BigDecimal.valueOf(1.40).movePointLeft(2);

            // Romania (RO)
            case RO_Z_POINT_PP, RO_HOME_DELIVERY_HD, RO_CARGUS_HD, RO_FAN_COURIER_BOX, RO_FAN_COURIER_HD, RO_SAMEDAY_BOX ->
                    BigDecimal.valueOf(0.70).movePointLeft(2);  // common for many Romanian carriers

            // Slovakia (SK)
            case SK_Z_POINT_PP -> BigDecimal.valueOf(1.40).movePointLeft(2);

            // Austria (AT), Belgium (BE), Bulgaria (BG), Croatia (HR), Cyprus (CY), Denmark (DK),
            // Estonia (EE), Finland (FI), France (FR), Germany (DE), Greece (GR), Ireland (IE),
            // Italy (IT), Latvia (LV), Lithuania (LT), Luxembourg (LU), Netherlands (NL), Portugal (PT)
            // → most of them use 1.40% or no COD at all (default 1.40% where COD is possible)
            default -> BigDecimal.valueOf(1.40).movePointLeft(2);
        };
    }

    /**
     * Returns the insurance price based on whether insurance is requested and the COD amount.
     * Logic is tiered per country where data was provided.
     */
    public BigDecimal getInsurancePrice() {
        if (!request.isInsured()) return BigDecimal.ZERO;

        BigDecimal amount = request.getCodAmount() != null ? request.getCodAmount() : BigDecimal.ZERO;

        return switch (service) {
            // Czech Republic (CZ) – simple 21 CZK up to 20 000 CZK
            case Z_POINT_PP, Z_BOX, HOME_STANDARD, EVENING_HD -> BigDecimal.valueOf(21);

            // Hungary (HU) – 21 CZK up to 220 000 HUF (~900 EUR), 56 CZK higher
            case HU_Z_POINT_PP, HU_HOME_DELIVERY_HD, HU_EXPRESS_ONE_HD, HU_FOXPOST_BOX,
                 HU_HUNGARIAN_POST_BOX, HU_HUNGARIAN_POST_HD, HU_HUNGARIAN_POST_PP, HU_Z_BOX ->
                    amount.compareTo(BigDecimal.valueOf(220000)) <= 0 ? BigDecimal.valueOf(21) : BigDecimal.valueOf(56);

            // Poland (PL) – often 12–59 CZK depending on tier
            case PL_Z_POINT_PP, PL_HOME_DELIVERY_HD, PL_INPOST_PACZKOMATY_BOX, PL_POLISH_POST_PP ->
                    amount.compareTo(BigDecimal.valueOf(3000)) <= 0 ? BigDecimal.valueOf(12) :
                            amount.compareTo(BigDecimal.valueOf(8000)) <= 0 ? BigDecimal.valueOf(50) :
                                    BigDecimal.valueOf(59);

            // Romania (RO) – 29–59 CZK or free in some cases
            case RO_Z_POINT_PP, RO_HOME_DELIVERY_HD, RO_CARGUS_HD, RO_FAN_COURIER_BOX, RO_FAN_COURIER_HD, RO_SAMEDAY_BOX ->
                    amount.compareTo(BigDecimal.valueOf(3500)) <= 0 ? BigDecimal.ZERO :
                            amount.compareTo(BigDecimal.valueOf(8000)) <= 0 ? BigDecimal.valueOf(29) :
                                    BigDecimal.valueOf(59);

            // Slovakia (SK) – similar to CZ
            case SK_Z_POINT_PP -> BigDecimal.valueOf(21);

            // Austria (AT), Belgium (BE), Bulgaria (BG), Croatia (HR), Cyprus (CY), Denmark (DK),
            // Estonia (EE), Finland (FI), France (FR), Germany (DE), Greece (GR), Ireland (IE),
            // Italy (IT), Latvia (LV), Lithuania (LT), Luxembourg (LU), Netherlands (NL), Portugal (PT)
            // → mostly 21–250 CZK depending on amount (generic fallback)
            default -> {
                if (amount.compareTo(BigDecimal.valueOf(100)) <= 0) yield BigDecimal.valueOf(30);
                if (amount.compareTo(BigDecimal.valueOf(200)) <= 0) yield BigDecimal.valueOf(55);
                if (amount.compareTo(BigDecimal.valueOf(400)) <= 0) yield BigDecimal.valueOf(112);
                yield BigDecimal.valueOf(196); // up to 700 EUR
            }
        };
    }
}