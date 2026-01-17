package com.packeta.sdk.util.pricing.model.dto;

import com.packeta.sdk.util.pricing.enums.TransportType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class CalculationResult {

    private CalculateForOrder request;

    private String serviceName;
    private TransportType transportType;
    private BigDecimal basePrice;

    private BigDecimal nonDepotSurcharge;         // usually 10 CZK
    private BigDecimal fuelSurcharge;             // 5% of base in some countries
    private BigDecimal tollSurcharge;             // weight-based (2.10–4.80 CZK)

    private BigDecimal codSurchargePercent;       // 1.40% or country-specific
    private BigDecimal codSurchargeAmount;        // calculated: codAmount × percent

    private BigDecimal insurancePrice;            // fixed or tiered
    private BigDecimal totalPrice;                // final sum (with/without VAT)

    private BigDecimal codAmount;                 // just for reference

    public BigDecimal getTotalPriceForCustomer() {
        return BigDecimal.valueOf(
                basePrice.longValue() + codSurchargeAmount.longValue() +
                insurancePrice.longValue()
        ).multiply(new BigDecimal("1.21")); // DPH
    }
}