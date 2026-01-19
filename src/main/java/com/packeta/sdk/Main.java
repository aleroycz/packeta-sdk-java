package com.packeta.sdk;

import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.exception.PacketaApiExceptionCustom;
import com.packeta.sdk.model.Size;
import com.packeta.sdk.model.feed.Carrier;
import com.packeta.sdk.model.feed.CarriersPudosResponse;
import com.packeta.sdk.util.pricing.PriceCalculator;
import com.packeta.sdk.util.pricing.enums.Country;
import com.packeta.sdk.util.pricing.enums.TransportType;
import com.packeta.sdk.util.pricing.model.dto.CalculateForOrder;
import com.packeta.sdk.util.pricing.model.dto.CalculationResult;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    static final String RESET = "\u001B[0m";
    static final String BOLD = "\u001B[1m";
    static final String GREEN = "\u001B[32m";
    static final String CYAN = "\u001B[36m";
    static final String YELLOW = "\u001B[33m";
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001B[34m";

    public static void main(String[] args) throws PacketaApiExceptionCustom {

        PacketaClient client = new PacketaClient("", "");

        PriceCalculator priceCalculator = new PriceCalculator();

        CalculateForOrder order = CalculateForOrder.builder()
                .transportType(TransportType.TO_DETERMINE)
                .size(Size.fromSize(180, 210, 180))
                .weightKg(new BigDecimal("5.00"))
                .codAmount(new BigDecimal("0"))
                .insured(true)
                .build();

        CalculationResult result = priceCalculator.calculateBestForCountry(order, Country.CZ);

        System.out.println();
        System.out.println(BOLD + CYAN + "═══════════════════════════════════════════════════════════════" + RESET);
        System.out.println(BOLD + GREEN + "          PACKETA SHIPPING CALCULATION RESULT (CZ)" + RESET);
        System.out.println(BOLD + CYAN + "═══════════════════════════════════════════════════════════════" + RESET);
        System.out.println();

        System.out.printf("  %sService:%s %-45s%n", BOLD, RESET, result.getServiceName());
        System.out.printf("  %sTransport type:%s %-38s%n", BOLD, RESET, result.getTransportType());
        System.out.println();

        System.out.printf("  %sWeight:%s %s kg%n", BOLD, RESET, order.getWeightKg());
        System.out.printf("  %sDimensions:%s %s × %s × %s mm (%s × %s × %s cm)%n",
                BOLD, RESET,
                order.getSize() != null ? order.getSize().getLength() : "—",
                order.getSize() != null ? order.getSize().getWidth() : "—",
                order.getSize() != null ? order.getSize().getHeight() : "—",
                order.getSize() != null ? order.getSize().getLength() / 10 : "—",
                order.getSize() != null ? order.getSize().getWidth() / 10 : "—",
                order.getSize() != null ? order.getSize().getHeight() / 10 : "—");
        System.out.println();

        System.out.println(BOLD + "  Price Breakdown (CZK, without VAT):" + RESET);
        System.out.println("  ──────────────────────────────────────────────────────────────");
        System.out.printf("     Base price:                  %s%10.2f CZK%s%n", GREEN, result.getBasePrice(), RESET);
        System.out.printf("     Non-depot surcharge:         %s%10.2f CZK%s%n", YELLOW, result.getNonDepotSurcharge(), RESET);
        System.out.printf("     Fuel surcharge (5%%):         %s%10.2f CZK%s%n", YELLOW, result.getFuelSurcharge(), RESET);
        System.out.printf("     Toll surcharge:              %s%10.2f CZK%s%n", YELLOW, result.getTollSurcharge(), RESET);
        System.out.printf("     COD surcharge (%.1f%%):      %s%10.2f CZK%s%n",
                result.getCodSurchargePercent().multiply(BigDecimal.valueOf(100)),
                result.getCodSurchargeAmount().compareTo(BigDecimal.ZERO) > 0 ? YELLOW : RED,
                result.getCodSurchargeAmount(), RESET);
        System.out.printf("     Insurance:                   %s%10.2f CZK%s%n", BLUE, result.getInsurancePrice(), RESET);
        System.out.println("  ──────────────────────────────────────────────────────────────");
        System.out.printf("  %sTOTAL PRICE      :%s %s%12.2f CZK%s%n",
                BOLD, RESET, GREEN, result.getTotalPrice(), RESET);
        System.out.printf("  %sTOTAL PRICE (VAT):%s %s%12.2f CZK%s%n",
                BOLD, RESET, GREEN, result.getTotalPriceForCustomer(), RESET);

        System.out.println();
        System.out.println(BOLD + CYAN + "═══════════════════════════════════════════════════════════════" + RESET);
        System.out.println();

        System.out.println("Printing carriers :");

        try {
            CarriersPudosResponse carrierList = client.getFeed().getCarriers(List.of(106));
            System.out.println(carrierList);

            carrierList.getCarriers().forEach(System.out::println);

        } catch (PacketaApiException e) {
            throw new PacketaApiExceptionCustom(e.getFaultCode(), e.getFaultString(), e);
        }
    }

}