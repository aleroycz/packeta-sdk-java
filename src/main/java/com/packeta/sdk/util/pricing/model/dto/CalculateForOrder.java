package com.packeta.sdk.util.pricing.model.dto;

import com.packeta.sdk.model.Size;
import com.packeta.sdk.util.pricing.enums.TransportType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class CalculateForOrder {
    private BigDecimal weightKg;          // required
    private Size size;                    // optional – dimensions in mm
    private TransportType transportType;  // optional – null = find cheapest
    private BigDecimal codAmount;         // optional
    private boolean insured;              // default false
    private boolean hasCod;
}
