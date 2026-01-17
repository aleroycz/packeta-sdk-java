package com.packeta.sdk.util.pricing;

import com.packeta.sdk.model.Size;
import com.packeta.sdk.util.pricing.enums.Country;
import com.packeta.sdk.util.pricing.enums.ServiceType;
import com.packeta.sdk.util.pricing.model.ServiceCalculation;
import com.packeta.sdk.util.pricing.model.ShipmentCategory;
import com.packeta.sdk.util.pricing.model.dto.CalculateForOrder;
import com.packeta.sdk.util.pricing.model.dto.CalculationResult;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Packeta price calculator for shipments from the Czech Republic
 * (prices valid as of 17.1.2026 – without VAT)
 */
@Getter
public class PriceCalculator {
    /**
     * Calculates the best (cheapest) Packeta shipping option for given parameters.
     * If no transportType is specified, selects the cheapest valid option.
     */
    public CalculationResult calculate(CalculateForOrder request) {
        ShipmentCategory category = determineCategory(request);

        if (request.getTransportType() != null) {
            ServiceType service = ServiceType.fromTransportType(request.getTransportType());
            ServiceCalculation calc = new ServiceCalculation(service, category, request);
            if (calc.isValid()) {
                return calc.toResult();
            }
            throw new IllegalArgumentException(
                    "Requested transport type " + request.getTransportType() +
                            " cannot handle this shipment (weight/dimensions)");
        }

        return Arrays.stream(ServiceType.values())
                .map(service -> new ServiceCalculation(service, category, request))
                .filter(ServiceCalculation::isValid)
                .min(Comparator.comparing(ServiceCalculation::getTotalPrice))
                .map(ServiceCalculation::toResult)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No Packeta service can handle this shipment (too heavy/large)"));
    }

    /**
     * Find the best (cheapest) transport option for the given country.
     */
    public CalculationResult calculateBestForCountry(CalculateForOrder request, Country country) {
        ShipmentCategory category = determineCategory(request);

        return Arrays.stream(ServiceType.values())
                .filter(service -> service.getCountry() == country)
                .map(service -> new ServiceCalculation(service, category, request))
                .filter(ServiceCalculation::isValid)
                .min(Comparator.comparing(ServiceCalculation::getTotalPrice))
                .map(ServiceCalculation::toResult)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No valid service found for country " + country +
                                " with given weight/dimensions"));
    }

    private ShipmentCategory determineCategory(CalculateForOrder r) {
        BigDecimal weightKg = r.getWeightKg();
        Size size = r.getSize();

        int maxSide = 0;
        int sumSides = 0;

        if (size != null && size.getLength() != null && size.getWidth() != null && size.getHeight() != null) {
            maxSide = Math.max(size.getLength(), Math.max(size.getWidth(), size.getHeight()));
            sumSides = size.getLength() + size.getWidth() + size.getHeight();
            System.out.println("DEBUG: Raw mm → maxSide=" + maxSide + " mm, sumSides=" + sumSides + " mm");
            System.out.println("DEBUG: Converted cm → max=" + (maxSide / 10) + " cm, sum=" + (sumSides / 10) + " cm");
        } else {
            System.out.println("DEBUG: No dimensions provided → maxSide=0, sumSides=0");
        }

        return new ShipmentCategory(weightKg, maxSide, sumSides);
    }
}