package com.packeta.sdk.util.pricing.enums;

import com.packeta.sdk.util.pricing.model.ShipmentCategory;
import com.packeta.sdk.util.pricing.model.WeightBracket;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public enum ServiceType {
    // CZECH REPUBLIC
    Z_POINT_PP("CZ Packeta Z-Point PP", new WeightBracket[]{
            new WeightBracket(5.00, 62.00, 70, 120),
            new WeightBracket(10.00, 120.00, 120, 150),
            new WeightBracket(15.00, 120.00, 120, 150),
    }, 15.00),

    Z_BOX("CZ Z-Box", new WeightBracket[]{
            new WeightBracket(5.00, 62.00, 70, 120),
            new WeightBracket(10.00, 120.00, 120, 150),
            new WeightBracket(15.00, 120.00, 120, 150),
    }, 15.00),

    HOME_STANDARD("CZ Packeta Home", new WeightBracket[]{
            new WeightBracket(1.00, 89.00, 70, 120),
            new WeightBracket(2.00, 89.00, 70, 120),
            new WeightBracket(5.00, 89.00, 70, 120),
            new WeightBracket(10.00, 130.00, 120, 150),
            new WeightBracket(15.00, 130.00, 120, 150),
            new WeightBracket(30.00, 250.00, 999, 999),
    }, 30.00),

    EVENING_HD("CZ Evening Delivery HD", new WeightBracket[]{
            new WeightBracket(5.00, 130.00, 70, 120),
            new WeightBracket(10.00, 180.00, 120, 150),
            new WeightBracket(15.00, 180.00, 120, 150),
            new WeightBracket(30.00, 180.00, 999, 999),
    }, 30.00),

    // HUNGARY (HU)
    HU_Z_POINT_PP("HU Packeta Z-Point PP", new WeightBracket[]{
            new WeightBracket(5.00, 85.00, 70, 120),
            new WeightBracket(10.00, 160.00, 120, 150),
            new WeightBracket(15.00, 160.00, 120, 150),
    }, 15.00),

    HU_HOME_DELIVERY_HD("HU Home Delivery HD", new WeightBracket[]{
            new WeightBracket(1.00, 130.00, 70, 120),
            new WeightBracket(2.00, 130.00, 70, 120),
            new WeightBracket(5.00, 150.00, 70, 120),
            new WeightBracket(10.00, 170.00, 70, 120),
            new WeightBracket(15.00, 230.00, 120, 150),
            new WeightBracket(30.00, 300.00, 999, 999),
            new WeightBracket(50.00, 400.00, 999, 999),
    }, 50.00),

    HU_EXPRESS_ONE_HD("HU Express One HD", new WeightBracket[]{
            new WeightBracket(1.00, 130.00, 70, 120),
            new WeightBracket(2.00, 130.00, 70, 120),
            new WeightBracket(5.00, 140.00, 70, 120),
            new WeightBracket(10.00, 175.00, 70, 120),
            new WeightBracket(15.00, 190.00, 120, 150),
            new WeightBracket(30.00, 255.00, 999, 999),
            new WeightBracket(50.00, 380.00, 999, 999),
    }, 50.00),

    HU_FOXPOST_BOX("HU FoxPost Box", new WeightBracket[]{
            new WeightBracket(5.00, 85.00, 70, 120),
            new WeightBracket(10.00, 160.00, 120, 150),
            new WeightBracket(15.00, 160.00, 120, 150),
    }, 15.00),

    HU_HUNGARIAN_POST_BOX("HU Hungarian Post Box", new WeightBracket[]{
            new WeightBracket(1.00, 130.00, 50, 116),
            new WeightBracket(2.00, 130.00, 50, 116),
            new WeightBracket(5.00, 150.00, 50, 116),
            new WeightBracket(10.00, 170.00, 50, 116),
            new WeightBracket(15.00, 270.00, 50, 116),
    }, 15.00),

    HU_HUNGARIAN_POST_HD("HU Hungarian Post HD", new WeightBracket[]{
            new WeightBracket(1.00, 130.00, 70, 120),
            new WeightBracket(2.00, 130.00, 70, 120),
            new WeightBracket(5.00, 150.00, 70, 120),
            new WeightBracket(10.00, 170.00, 70, 120),
            new WeightBracket(15.00, 270.00, 120, 150),
            new WeightBracket(30.00, 399.00, 999, 999),
    }, 30.00),

    HU_HUNGARIAN_POST_PP("HU Hungarian Post PP", new WeightBracket[]{
            new WeightBracket(1.00, 130.00, 70, 120),
            new WeightBracket(2.00, 130.00, 70, 120),
            new WeightBracket(5.00, 150.00, 70, 120),
            new WeightBracket(10.00, 170.00, 70, 120),
            new WeightBracket(15.00, 270.00, 120, 150),
            new WeightBracket(20.00, 399.00, 999, 999),
    }, 20.00),

    HU_Z_BOX("HU Z-Box Box", new WeightBracket[]{
            new WeightBracket(5.00, 85.00, 61, 142),
            new WeightBracket(10.00, 160.00, 120, 150),
            new WeightBracket(15.00, 160.00, 120, 150),
    }, 15.00),

    // POLAND (PL)
    PL_Z_POINT_PP("PL Packeta Z-Point PP", new WeightBracket[]{
            new WeightBracket(5.00, 65.00, 70, 120),
            new WeightBracket(10.00, 128.00, 120, 150),
            new WeightBracket(15.00, 128.00, 120, 150),
    }, 15.00),

    PL_HOME_DELIVERY_HD("PL Home Delivery HD", new WeightBracket[]{
            new WeightBracket(1.00, 140.00, 70, 120),
            new WeightBracket(2.00, 140.00, 70, 120),
            new WeightBracket(5.00, 140.00, 70, 120),
            new WeightBracket(10.00, 150.00, 70, 120),
            new WeightBracket(15.00, 180.00, 120, 150),
            new WeightBracket(30.00, 180.00, 999, 999),
            new WeightBracket(50.00, 300.00, 999, 999),
    }, 50.00),

    PL_INPOST_PACZKOMATY_BOX("PL InPost Paczkomaty Box", new WeightBracket[]{
            new WeightBracket(5.00, 160.00, 64, 139),
            new WeightBracket(10.00, 160.00, 64, 139),
            new WeightBracket(15.00, 170.00, 64, 139),
    }, 15.00),

    PL_POLISH_POST_PP("PL Polish Post PP", new WeightBracket[]{
            new WeightBracket(10.00, 130.00, 70, 190),
            new WeightBracket(20.00, 170.00, 70, 190),
            new WeightBracket(30.00, 170.00, 70, 190),
    }, 30.00),

    // ROMANIA (RO)
    RO_Z_POINT_PP("RO Packeta Z-Point PP", new WeightBracket[]{
            new WeightBracket(5.00, 95.00, 70, 120),
            new WeightBracket(10.00, 180.00, 120, 150),
            new WeightBracket(15.00, 180.00, 120, 150),
    }, 15.00),

    RO_HOME_DELIVERY_HD("RO Home Delivery HD", new WeightBracket[]{
            new WeightBracket(1.00, 110.00, 70, 120),
            new WeightBracket(2.00, 115.00, 70, 120),
            new WeightBracket(5.00, 125.00, 70, 120),
            new WeightBracket(10.00, 145.00, 70, 120),
            new WeightBracket(15.00, 280.00, 120, 150),
            new WeightBracket(30.00, 280.00, 999, 999),
            new WeightBracket(50.00, 660.00, 999, 999),
    }, 50.00),

    RO_CARGUS_HD("RO Cargus HD", new WeightBracket[]{
            new WeightBracket(1.00, 115.00, 70, 120),
            new WeightBracket(2.00, 125.00, 70, 120),
            new WeightBracket(5.00, 145.00, 70, 120),
            new WeightBracket(10.00, 180.00, 70, 120),
            new WeightBracket(15.00, 309.00, 120, 150),
            new WeightBracket(30.00, 390.00, 999, 999),
    }, 30.00),

    RO_FAN_COURIER_BOX("RO FAN Courier Box", new WeightBracket[]{
            new WeightBracket(5.00, 100.00, 45, 129),
            new WeightBracket(10.00, 135.00, 45, 129),
            new WeightBracket(15.00, 135.00, 45, 129),
    }, 15.00),

    RO_FAN_COURIER_HD("RO FAN Courier HD", new WeightBracket[]{
            new WeightBracket(1.00, 115.00, 70, 120),
            new WeightBracket(2.00, 120.00, 70, 120),
            new WeightBracket(5.00, 125.00, 70, 120),
            new WeightBracket(10.00, 150.00, 70, 120),
            new WeightBracket(15.00, 300.00, 120, 150),
            new WeightBracket(30.00, 300.00, 999, 999),
    }, 30.00),

    RO_SAMEDAY_BOX("RO Sameday Box", new WeightBracket[]{
            new WeightBracket(5.00, 100.00, 47, 129),
            new WeightBracket(10.00, 110.00, 47, 129),
            new WeightBracket(15.00, 120.00, 47, 129),
    }, 15.00),

    // SLOVAKIA (SK)
    SK_Z_POINT_PP("SK Packeta Z-Point PP", new WeightBracket[]{
            new WeightBracket(5.00, 75.00, 70, 120),
            new WeightBracket(10.00, 140.00, 120, 150),
            new WeightBracket(15.00, 140.00, 120, 150),
    }, 15.00),

    // AUSTRIA (AT)
    AT_AUSTRIAN_POST_HD("AT Austrian Post HD", new WeightBracket[]{
            new WeightBracket(1.00, 220.00, 999, 999),
            new WeightBracket(2.00, 220.00, 999, 999),
            new WeightBracket(5.00, 220.00, 999, 999),
            new WeightBracket(10.00, 250.00, 999, 999),
            new WeightBracket(15.00, 260.00, 999, 999),
            new WeightBracket(30.00, 350.00, 999, 999),
    }, 30.00),

    AT_DPD_HD("AT DPD HD", new WeightBracket[]{
            new WeightBracket(1.00, 200.00, 70, 120),
            new WeightBracket(2.00, 200.00, 70, 120),
            new WeightBracket(5.00, 200.00, 70, 120),
            new WeightBracket(10.00, 230.00, 70, 120),
            new WeightBracket(15.00, 230.00, 120, 150),
            new WeightBracket(30.00, 275.00, 999, 999),
    }, 30.00),

    // BELGIUM (BE)
    BE_BELGIAN_POST_HD("BE Belgian Post HD", new WeightBracket[]{
            new WeightBracket(1.00, 270.00, 999, 999),
            new WeightBracket(2.00, 270.00, 999, 999),
            new WeightBracket(5.00, 280.00, 999, 999),
            new WeightBracket(10.00, 320.00, 999, 999),
            new WeightBracket(15.00, 380.00, 999, 999),
            new WeightBracket(30.00, 450.00, 999, 999),
    }, 30.00),

    BE_BELGIAN_POST_PP("BE Belgian Post PP", new WeightBracket[]{
            new WeightBracket(1.00, 260.00, 999, 999),
            new WeightBracket(2.00, 260.00, 999, 999),
            new WeightBracket(5.00, 260.00, 999, 999),
            new WeightBracket(10.00, 300.00, 999, 999),
            new WeightBracket(15.00, 350.00, 999, 999),
            new WeightBracket(30.00, 400.00, 999, 999),
    }, 30.00),

    BE_DUTCH_POST_HD("BE Dutch Post HD", new WeightBracket[]{
            new WeightBracket(0.50, 220.00, 999, 999),
            new WeightBracket(1.00, 240.00, 999, 999),
            new WeightBracket(2.00, 250.00, 999, 999),
            new WeightBracket(5.00, 320.00, 999, 999),
            new WeightBracket(10.00, 420.00, 999, 999),
            new WeightBracket(15.00, 520.00, 999, 999),
            new WeightBracket(20.00, 630.00, 999, 999),
    }, 20.00),

    // BULGARIA (BG)
    BG_HOME_DELIVERY_HD("BG Home Delivery HD", new WeightBracket[]{
            new WeightBracket(1.00, 140.00, 70, 120),
            new WeightBracket(2.00, 150.00, 70, 120),
            new WeightBracket(5.00, 200.00, 70, 120),
            new WeightBracket(10.00, 230.00, 70, 120),
            new WeightBracket(15.00, 340.00, 70, 120),
            new WeightBracket(20.00, 350.00, 999, 999),
            new WeightBracket(30.00, 800.00, 999, 999),
            new WeightBracket(40.00, 900.00, 999, 999),
            new WeightBracket(50.00, 1200.00, 999, 999),
    }, 50.00),

    BG_BOXNOW_BOX("BG BoxNow Box", new WeightBracket[]{
            new WeightBracket(5.00, 105.00, 61, 142),
            new WeightBracket(10.00, 135.00, 62, 143),
            new WeightBracket(15.00, 135.00, 62, 143),
    }, 15.00),

    BG_ECONT_BOX("BG Econt Box", new WeightBracket[]{
            new WeightBracket(1.00, 135.00, 70, 120),
            new WeightBracket(2.00, 135.00, 70, 120),
            new WeightBracket(5.00, 150.00, 70, 120),
            new WeightBracket(10.00, 220.00, 70, 120),
            new WeightBracket(15.00, 230.00, 70, 120),
            new WeightBracket(20.00, 260.00, 999, 999),
            new WeightBracket(30.00, 480.00, 999, 999),
            new WeightBracket(40.00, 550.00, 999, 999),
            new WeightBracket(50.00, 650.00, 999, 999),
    }, 50.00),

    BG_ECONT_HD("BG Econt HD", new WeightBracket[]{
            new WeightBracket(1.00, 160.00, 70, 120),
            new WeightBracket(2.00, 160.00, 70, 120),
            new WeightBracket(5.00, 200.00, 70, 120),
            new WeightBracket(10.00, 290.00, 70, 120),
            new WeightBracket(15.00, 360.00, 70, 120),
            new WeightBracket(20.00, 410.00, 999, 999),
            new WeightBracket(30.00, 800.00, 999, 999),
            new WeightBracket(40.00, 900.00, 999, 999),
            new WeightBracket(50.00, 1200.00, 999, 999),
    }, 50.00),

    BG_ECONT_PP("BG Econt PP", new WeightBracket[]{
            new WeightBracket(1.00, 135.00, 70, 120),
            new WeightBracket(2.00, 135.00, 70, 120),
            new WeightBracket(5.00, 150.00, 70, 120),
            new WeightBracket(10.00, 220.00, 70, 120),
            new WeightBracket(15.00, 230.00, 70, 120),
            new WeightBracket(20.00, 260.00, 999, 999),
            new WeightBracket(30.00, 480.00, 999, 999),
            new WeightBracket(40.00, 550.00, 999, 999),
            new WeightBracket(50.00, 650.00, 999, 999),
    }, 50.00),

    BG_SAMEDAY_BOX("BG Sameday Box", new WeightBracket[]{
            new WeightBracket(1.00, 110.00, 47, 100),
            new WeightBracket(2.00, 115.00, 47, 110),
            new WeightBracket(5.00, 170.00, 47, 129),
            new WeightBracket(10.00, 210.00, 47, 129),
            new WeightBracket(15.00, 240.00, 47, 129),
    }, 15.00),

    BG_SAMEDAY_HD("BG Sameday HD", new WeightBracket[]{
            new WeightBracket(1.00, 130.00, 70, 120),
            new WeightBracket(2.00, 135.00, 70, 120),
            new WeightBracket(5.00, 180.00, 70, 120),
            new WeightBracket(10.00, 240.00, 70, 120),
            new WeightBracket(15.00, 250.00, 120, 150),
            new WeightBracket(20.00, 300.00, 120, 150),
            new WeightBracket(25.00, 350.00, 120, 150),
            new WeightBracket(30.00, 400.00, 999, 999),
    }, 30.00),

    BG_SPEEDY_HD("BG Speedy HD", new WeightBracket[]{
            new WeightBracket(1.00, 140.00, 70, 120),
            new WeightBracket(2.00, 150.00, 70, 120),
            new WeightBracket(5.00, 200.00, 70, 120),
            new WeightBracket(10.00, 230.00, 70, 120),
            new WeightBracket(15.00, 340.00, 120, 150),
            new WeightBracket(20.00, 350.00, 999, 999),
    }, 20.00),

    BG_SPEEDY_PP("BG Speedy PP", new WeightBracket[]{
            new WeightBracket(1.00, 135.00, 70, 120),
            new WeightBracket(2.00, 139.00, 70, 120),
            new WeightBracket(5.00, 159.00, 70, 120),
            new WeightBracket(10.00, 289.00, 70, 120),
            new WeightBracket(15.00, 299.00, 120, 150),
            new WeightBracket(20.00, 299.00, 999, 999),
    }, 20.00),

    // CROATIA (HR)
    HR_BOXNOW_BOX("HR BoxNow Box", new WeightBracket[]{
            new WeightBracket(5.00, 85.00, 61, 142),
            new WeightBracket(10.00, 120.00, 62, 143),
            new WeightBracket(15.00, 120.00, 62, 143),
    }, 15.00),

    HR_CROATIAN_POST_HD("HR Croatian Post HD", new WeightBracket[]{
            new WeightBracket(1.00, 140.00, 70, 120),
            new WeightBracket(2.00, 150.00, 70, 120),
            new WeightBracket(5.00, 160.00, 70, 120),
            new WeightBracket(10.00, 180.00, 70, 120),
            new WeightBracket(15.00, 210.00, 120, 150),
            new WeightBracket(30.00, 300.00, 999, 999),
            new WeightBracket(50.00, 2450.00, 999, 999),
    }, 50.00),

    HR_CROATIAN_POST_PP("HR Croatian Post PP", new WeightBracket[]{
            new WeightBracket(1.00, 140.00, 70, 120),
            new WeightBracket(2.00, 150.00, 70, 120),
            new WeightBracket(5.00, 160.00, 70, 120),
            new WeightBracket(10.00, 180.00, 70, 120),
            new WeightBracket(15.00, 210.00, 120, 150),
            new WeightBracket(30.00, 300.00, 999, 999),
            new WeightBracket(50.00, 2450.00, 999, 999),
    }, 50.00),

    HR_OVERSEAS_HD("HR Overseas HD", new WeightBracket[]{
            new WeightBracket(1.00, 130.00, 100, 150),
            new WeightBracket(2.00, 140.00, 100, 150),
            new WeightBracket(5.00, 150.00, 100, 150),
            new WeightBracket(10.00, 180.00, 100, 150),
            new WeightBracket(15.00, 200.00, 100, 150),
            new WeightBracket(30.00, 250.00, 999, 999),
    }, 30.00),

    HR_OVERSEAS_PP("HR Overseas PP", new WeightBracket[]{
            new WeightBracket(1.00, 120.00, 50, 125),
            new WeightBracket(2.00, 125.00, 50, 125),
            new WeightBracket(5.00, 150.00, 50, 125),
            new WeightBracket(10.00, 170.00, 50, 125),
            new WeightBracket(15.00, 200.00, 50, 125),
            new WeightBracket(30.00, 250.00, 999, 999),
    }, 30.00),

    // CYPRUS (CY)
    CY_BOXNOW_BOX("CY BoxNow Box", new WeightBracket[]{
            new WeightBracket(1.00, 185.00, 61, 142),
            new WeightBracket(2.00, 190.00, 61, 142),
            new WeightBracket(5.00, 195.00, 61, 142),
            new WeightBracket(7.00, 195.00, 62, 143),
    }, 7.00),

    // DENMARK (DK)
    DK_POST_NORD_HD("DK Post Nord HD", new WeightBracket[]{
            new WeightBracket(1.00, 320.00, 70, 120),
            new WeightBracket(2.00, 320.00, 70, 120),
            new WeightBracket(5.00, 320.00, 70, 120),
            new WeightBracket(10.00, 360.00, 70, 120),
            new WeightBracket(15.00, 360.00, 120, 150),
            new WeightBracket(30.00, 360.00, 999, 999),
            new WeightBracket(100.00, 3000.00, 999, 999),
    }, 100.00),

    DK_POST_NORD_PP("DK Post Nord PP", new WeightBracket[]{
            new WeightBracket(1.00, 300.00, 70, 120),
            new WeightBracket(2.00, 300.00, 70, 120),
            new WeightBracket(5.00, 300.00, 70, 120),
            new WeightBracket(10.00, 340.00, 70, 120),
            new WeightBracket(15.00, 350.00, 120, 150),
            new WeightBracket(20.00, 350.00, 999, 999),
            new WeightBracket(100.00, 1700.00, 999, 999),
    }, 100.00),

    // ESTONIA (EE)
    EE_LITHUANIAN_POST_HD("EE Lithuanian Post HD", new WeightBracket[]{
            new WeightBracket(2.00, 230.00, 999, 999),
            new WeightBracket(5.00, 250.00, 999, 999),
            new WeightBracket(10.00, 300.00, 999, 999),
            new WeightBracket(15.00, 300.00, 999, 999),
            new WeightBracket(20.00, 320.00, 999, 999),
            new WeightBracket(30.00, 350.00, 999, 999),
    }, 30.00),

    EE_OMNIVA_BOX("EE Omniva Box", new WeightBracket[]{
            new WeightBracket(5.00, 220.00, 64, 142),
            new WeightBracket(10.00, 220.00, 64, 142),
            new WeightBracket(15.00, 220.00, 64, 142),
            new WeightBracket(30.00, 220.00, 64, 142),
    }, 30.00),

    EE_OMNIVA_HD("EE Omniva HD", new WeightBracket[]{
            new WeightBracket(1.00, 270.00, 70, 120),
            new WeightBracket(2.00, 290.00, 70, 120),
            new WeightBracket(5.00, 300.00, 70, 120),
            new WeightBracket(10.00, 320.00, 70, 120),
            new WeightBracket(15.00, 350.00, 120, 150),
            new WeightBracket(30.00, 400.00, 999, 999),
    }, 30.00),

    EE_OMNIVA_PP("EE Omniva PP", new WeightBracket[]{
            new WeightBracket(1.00, 250.00, 70, 120),
            new WeightBracket(2.00, 260.00, 70, 120),
            new WeightBracket(5.00, 260.00, 70, 120),
            new WeightBracket(10.00, 320.00, 70, 120),
            new WeightBracket(15.00, 380.00, 120, 150),
            new WeightBracket(30.00, 500.00, 999, 999),
    }, 30.00),

    EE_VENIPAK_BOX("EE Venipak Box", new WeightBracket[]{
            new WeightBracket(2.00, 180.00, 61, 119),
            new WeightBracket(5.00, 180.00, 61, 119),
            new WeightBracket(10.00, 210.00, 61, 119),
            new WeightBracket(15.00, 210.00, 61, 119),
    }, 15.00),

    EE_VENIPAK_HD("EE Venipak HD", new WeightBracket[]{
            new WeightBracket(2.00, 230.00, 70, 120),
            new WeightBracket(5.00, 250.00, 70, 120),
            new WeightBracket(10.00, 330.00, 70, 120),
            new WeightBracket(15.00, 410.00, 120, 150),
            new WeightBracket(30.00, 520.00, 999, 999),
            new WeightBracket(50.00, 600.00, 999, 999),
    }, 50.00),

    EE_VENIPAK_PP("EE Venipak PP", new WeightBracket[]{
            new WeightBracket(2.00, 180.00, 70, 120),
            new WeightBracket(5.00, 180.00, 70, 120),
            new WeightBracket(10.00, 210.00, 70, 120),
    }, 10.00),

    // FINLAND (FI)
    FI_MATKAHUOLTO_BOX("FI Matkahuolto Box", new WeightBracket[]{
            new WeightBracket(2.00, 240.00, 70, 167),
            new WeightBracket(5.00, 240.00, 70, 167),
            new WeightBracket(10.00, 310.00, 70, 167),
            new WeightBracket(15.00, 370.00, 70, 167),
    }, 15.00),

    FI_MATKAHUOLTO_HD("FI Matkahuolto HD", new WeightBracket[]{
            new WeightBracket(1.00, 410.00, 70, 120),
            new WeightBracket(2.00, 410.00, 70, 120),
            new WeightBracket(5.00, 430.00, 70, 120),
            new WeightBracket(10.00, 500.00, 70, 120),
            new WeightBracket(15.00, 550.00, 120, 150),
            new WeightBracket(30.00, 610.00, 999, 999),
            new WeightBracket(50.00, 730.00, 999, 999),
    }, 50.00),

    FI_MATKAHUOLTO_PP("FI Matkahuolto PP", new WeightBracket[]{
            new WeightBracket(2.00, 240.00, 70, 120),
            new WeightBracket(5.00, 240.00, 70, 120),
            new WeightBracket(10.00, 310.00, 70, 120),
            new WeightBracket(15.00, 370.00, 120, 150),
            new WeightBracket(30.00, 430.00, 999, 999),
    }, 30.00),

    FI_POST_NORD_HD("FI Post Nord HD", new WeightBracket[]{
            new WeightBracket(1.00, 560.00, 70, 120),
            new WeightBracket(2.00, 560.00, 70, 120),
            new WeightBracket(5.00, 570.00, 70, 120),
            new WeightBracket(10.00, 580.00, 70, 120),
            new WeightBracket(15.00, 600.00, 120, 150),
            new WeightBracket(30.00, 620.00, 999, 999),
            new WeightBracket(100.00, 3500.00, 999, 999),
    }, 100.00),

    FI_POST_NORD_PP("FI Post Nord PP", new WeightBracket[]{
            new WeightBracket(1.00, 350.00, 70, 120),
            new WeightBracket(2.00, 370.00, 70, 120),
            new WeightBracket(5.00, 400.00, 70, 120),
            new WeightBracket(10.00, 420.00, 70, 120),
            new WeightBracket(15.00, 450.00, 120, 150),
            new WeightBracket(20.00, 480.00, 999, 999),
            new WeightBracket(100.00, 1700.00, 999, 999),
    }, 100.00),

    // FRANCE (FR)
    FR_COLIS_PRIVE_HD("FR Colis Privé HD", new WeightBracket[]{
            new WeightBracket(0.50, 190.00, 70, 120),
            new WeightBracket(1.00, 210.00, 70, 120),
            new WeightBracket(2.00, 225.00, 70, 120),
            new WeightBracket(5.00, 300.00, 70, 120),
            new WeightBracket(10.00, 410.00, 70, 120),
            new WeightBracket(15.00, 520.00, 70, 120),
            new WeightBracket(30.00, 820.00, 999, 999),
    }, 30.00),

    FR_COLISSIMO_HD("FR Colissimo HD", new WeightBracket[]{
            new WeightBracket(0.25, 200.00, 70, 120),
            new WeightBracket(0.50, 220.00, 70, 120),
            new WeightBracket(0.75, 230.00, 70, 120),
            new WeightBracket(1.00, 250.00, 70, 120),
            new WeightBracket(2.00, 300.00, 70, 120),
            new WeightBracket(5.00, 350.00, 70, 120),
            new WeightBracket(10.00, 470.00, 70, 120),
            new WeightBracket(15.00, 570.00, 70, 120),
            new WeightBracket(30.00, 890.00, 999, 999),
    }, 30.00),

    FR_COLISSIMO_PP("FR Colissimo PP", new WeightBracket[]{
            new WeightBracket(0.25, 190.00, 70, 120),
            new WeightBracket(0.50, 200.00, 70, 120),
            new WeightBracket(0.75, 220.00, 70, 120),
            new WeightBracket(1.00, 240.00, 70, 120),
            new WeightBracket(2.00, 270.00, 70, 120),
            new WeightBracket(5.00, 350.00, 70, 120),
            new WeightBracket(10.00, 500.00, 70, 120),
            new WeightBracket(15.00, 600.00, 70, 120),
            new WeightBracket(30.00, 1000.00, 999, 999),
    }, 30.00),

    FR_MONDIAL_RELAY_PP("FR Mondial Relay PP", new WeightBracket[]{
            new WeightBracket(1.00, 175.00, 70, 120),
            new WeightBracket(2.00, 175.00, 70, 120),
            new WeightBracket(5.00, 220.00, 70, 120),
            new WeightBracket(10.00, 310.00, 70, 120),
            new WeightBracket(15.00, 410.00, 70, 120),
            new WeightBracket(30.00, 680.00, 999, 999),
    }, 30.00),

    // GERMANY (DE)
    DE_HOME_DELIVERY_HD("DE Home Delivery HD", new WeightBracket[]{
            new WeightBracket(1.00, 170.00, 70, 120),
            new WeightBracket(2.00, 180.00, 70, 120),
            new WeightBracket(5.00, 190.00, 70, 120),
            new WeightBracket(10.00, 200.00, 70, 120),
            new WeightBracket(15.00, 250.00, 120, 150),
            new WeightBracket(30.00, 260.00, 999, 999),
    }, 30.00),

    DE_HERMES_HD("DE Hermes HD", new WeightBracket[]{
            new WeightBracket(1.00, 150.00, 70, 120),
            new WeightBracket(2.00, 160.00, 70, 120),
            new WeightBracket(5.00, 170.00, 70, 120),
            new WeightBracket(10.00, 230.00, 70, 120),
            new WeightBracket(15.00, 280.00, 120, 150),
            new WeightBracket(30.00, 340.00, 999, 999),
    }, 30.00),

    DE_HERMES_PP("DE Hermes PP", new WeightBracket[]{
            new WeightBracket(1.00, 140.00, 70, 120),
            new WeightBracket(2.00, 140.00, 70, 120),
            new WeightBracket(5.00, 150.00, 70, 120),
            new WeightBracket(10.00, 210.00, 70, 120),
            new WeightBracket(15.00, 260.00, 120, 150),
            new WeightBracket(30.00, 320.00, 999, 999),
    }, 30.00),

    // GREECE (GR)
    GR_ACS_HD("GR ACS HD", new WeightBracket[]{
            new WeightBracket(1.00, 159.00, 70, 120),
            new WeightBracket(2.00, 179.00, 70, 120),
            new WeightBracket(5.00, 245.00, 70, 120),
            new WeightBracket(10.00, 360.00, 70, 120),
            new WeightBracket(15.00, 520.00, 70, 120),
            new WeightBracket(20.00, 680.00, 999, 999),
    }, 20.00),

    GR_ACS_PP("GR ACS PP", new WeightBracket[]{
            new WeightBracket(1.00, 159.00, 70, 120),
            new WeightBracket(2.00, 179.00, 70, 120),
            new WeightBracket(5.00, 245.00, 70, 120),
            new WeightBracket(10.00, 360.00, 70, 120),
            new WeightBracket(15.00, 520.00, 70, 120),
            new WeightBracket(20.00, 680.00, 999, 999),
    }, 20.00),

    GR_BOXNOW_BOX("GR BoxNow Box", new WeightBracket[]{
            new WeightBracket(5.00, 130.00, 61, 142),
            new WeightBracket(10.00, 140.00, 62, 143),
            new WeightBracket(15.00, 160.00, 62, 143),
    }, 15.00),

    GR_ELTA_COURIER_HD("GR Elta Courier HD", new WeightBracket[]{
            new WeightBracket(1.00, 145.00, 70, 120),
            new WeightBracket(2.00, 145.00, 70, 120),
            new WeightBracket(5.00, 155.00, 70, 120),
            new WeightBracket(10.00, 290.00, 70, 120),
            new WeightBracket(15.00, 395.00, 120, 150),
            new WeightBracket(20.00, 500.00, 120, 150),
            new WeightBracket(30.00, 710.00, 999, 999),
    }, 30.00),

    GR_ELTA_COURIER_PP("GR Elta Courier PP", new WeightBracket[]{
            new WeightBracket(1.00, 130.00, 70, 120),
            new WeightBracket(2.00, 130.00, 70, 120),
            new WeightBracket(5.00, 135.00, 70, 120),
            new WeightBracket(10.00, 275.00, 70, 120),
            new WeightBracket(15.00, 375.00, 120, 150),
            new WeightBracket(20.00, 480.00, 120, 150),
            new WeightBracket(30.00, 690.00, 999, 999),
    }, 30.00),

    GR_SPEEDEX_HD("GR Speedex HD", new WeightBracket[]{
            new WeightBracket(1.00, 140.00, 70, 120),
            new WeightBracket(2.00, 150.00, 70, 120),
            new WeightBracket(5.00, 220.00, 70, 120),
            new WeightBracket(10.00, 350.00, 70, 120),
            new WeightBracket(15.00, 500.00, 70, 120),
            new WeightBracket(30.00, 980.00, 999, 999),
            new WeightBracket(50.00, 1400.00, 999, 999),
            new WeightBracket(100.00, 2700.00, 999, 999),
    }, 100.00),

    GR_TAXYDROMIKI_HD("GR Taxydromiki HD", new WeightBracket[]{
            new WeightBracket(1.00, 149.00, 70, 120),
            new WeightBracket(2.00, 159.00, 70, 120),
            new WeightBracket(5.00, 199.00, 70, 120),
            new WeightBracket(10.00, 290.00, 70, 120),
            new WeightBracket(15.00, 450.00, 70, 120),
            new WeightBracket(30.00, 980.00, 999, 999),
    }, 30.00),

    // IRELAND (IE)
    IE_FASTWAY_COURIERS_HD("IE Fastway Couriers HD", new WeightBracket[]{
            new WeightBracket(1.00, 300.00, 70, 120),
            new WeightBracket(2.00, 360.00, 70, 120),
            new WeightBracket(5.00, 550.00, 70, 120),
            new WeightBracket(10.00, 920.00, 70, 120),
            new WeightBracket(15.00, 1270.00, 120, 150),
            new WeightBracket(30.00, 2290.00, 999, 999),
    }, 30.00),

    IE_FEDEX_HD_CONNECT_PLUS("IE FedEx HD Connect Plus", new WeightBracket[]{
            new WeightBracket(0.50, 380.00, 70, 120),
            new WeightBracket(1.00, 380.00, 70, 120),
            new WeightBracket(1.50, 410.00, 70, 120),
            new WeightBracket(2.00, 430.00, 70, 120),
            new WeightBracket(2.50, 460.00, 70, 120),
            new WeightBracket(3.00, 490.00, 70, 120),
            new WeightBracket(4.00, 520.00, 70, 120),
            new WeightBracket(5.00, 520.00, 70, 120),
            new WeightBracket(10.00, 670.00, 70, 120),
            new WeightBracket(15.00, 830.00, 70, 120),
            new WeightBracket(20.00, 950.00, 999, 999),
            // extend up to 65 kg if needed
    }, 65.00),

    IE_FEDEX_HD_PRIORITY("IE FedEx HD Priority", new WeightBracket[]{
            new WeightBracket(0.50, 450.00, 70, 120),
            new WeightBracket(1.00, 450.00, 70, 120),
            new WeightBracket(1.50, 450.00, 70, 120),
            new WeightBracket(2.00, 480.00, 70, 120),
            new WeightBracket(2.50, 530.00, 70, 120),
            new WeightBracket(3.00, 550.00, 70, 120),
            new WeightBracket(4.00, 600.00, 70, 120),
            new WeightBracket(5.00, 650.00, 70, 120),
            new WeightBracket(10.00, 1030.00, 70, 120),
            new WeightBracket(15.00, 1740.00, 70, 120),
            // extend up to 65 kg if needed
    }, 65.00),

    // ITALY (IT)
    IT_BARTOLINI_BOX("IT Bartolini Box", new WeightBracket[]{
            new WeightBracket(1.00, 175.00, 70, 120),
            new WeightBracket(2.00, 175.00, 70, 120),
            new WeightBracket(5.00, 220.00, 70, 120),
            new WeightBracket(10.00, 280.00, 70, 120),
            new WeightBracket(15.00, 320.00, 70, 120),
    }, 15.00),

    IT_BARTOLINI_HD("IT Bartolini HD", new WeightBracket[]{
            new WeightBracket(1.00, 185.00, 70, 120),
            new WeightBracket(2.00, 205.00, 70, 120),
            new WeightBracket(5.00, 265.00, 70, 120),
            new WeightBracket(10.00, 335.00, 70, 120),
            new WeightBracket(15.00, 400.00, 70, 120),
            new WeightBracket(30.00, 480.00, 999, 999),
            new WeightBracket(50.00, 620.00, 999, 999),
            new WeightBracket(100.00, 1200.00, 999, 999),
    }, 100.00),

    IT_BARTOLINI_PP("IT Bartolini PP", new WeightBracket[]{
            new WeightBracket(1.00, 175.00, 70, 120),
            new WeightBracket(2.00, 199.00, 70, 120),
            new WeightBracket(5.00, 255.00, 70, 120),
            new WeightBracket(10.00, 320.00, 70, 120),
            new WeightBracket(15.00, 380.00, 70, 120),
            new WeightBracket(30.00, 460.00, 999, 999),
            new WeightBracket(50.00, 590.00, 999, 999),
            new WeightBracket(100.00, 1100.00, 999, 999),
    }, 100.00),

    IT_HR_PARCEL_HD("IT HR Parcel HD", new WeightBracket[]{
            new WeightBracket(1.00, 170.00, 70, 120),
            new WeightBracket(2.00, 190.00, 70, 120),
            new WeightBracket(5.00, 250.00, 70, 120),
            new WeightBracket(10.00, 300.00, 70, 120),
            new WeightBracket(15.00, 350.00, 70, 120),
            new WeightBracket(30.00, 440.00, 999, 999),
            new WeightBracket(50.00, 610.00, 999, 999),
            new WeightBracket(100.00, 1100.00, 999, 999),
    }, 100.00),

    IT_ITALIAN_POST_HD("IT Italian Post HD", new WeightBracket[]{
            new WeightBracket(1.00, 210.00, 70, 120),
            new WeightBracket(3.00, 210.00, 70, 120),
            new WeightBracket(5.00, 230.00, 70, 120),
            new WeightBracket(10.00, 290.00, 120, 150),
            new WeightBracket(15.00, 330.00, 120, 150),
            new WeightBracket(30.00, 380.00, 120, 150),
            new WeightBracket(50.00, 640.00, 120, 150),
            new WeightBracket(70.00, 680.00, 120, 150),
            new WeightBracket(100.00, 750.00, 120, 150),
    }, 100.00),

    IT_ITALIAN_POST_PP("IT Italian Post PP", new WeightBracket[]{
            new WeightBracket(1.00, 170.00, 70, 120),
            new WeightBracket(3.00, 170.00, 70, 120),
            new WeightBracket(5.00, 190.00, 70, 120),
            new WeightBracket(10.00, 280.00, 70, 120),
            new WeightBracket(15.00, 320.00, 70, 120),
            new WeightBracket(30.00, 350.00, 120, 150),
            new WeightBracket(50.00, 640.00, 120, 150),
            new WeightBracket(70.00, 670.00, 120, 150),
            new WeightBracket(100.00, 750.00, 120, 150),
    }, 100.00),

    IT_ITALIAN_POST_PUNTO_POSTE_PP("IT Italian Post Punto Poste PP", new WeightBracket[]{
            new WeightBracket(1.00, 170.00, 70, 129),
            new WeightBracket(3.00, 170.00, 70, 129),
            new WeightBracket(5.00, 190.00, 70, 129),
            new WeightBracket(10.00, 280.00, 70, 129),
            new WeightBracket(15.00, 320.00, 70, 129),
            new WeightBracket(30.00, 350.00, 120, 129),
            new WeightBracket(50.00, 640.00, 120, 129),
            new WeightBracket(70.00, 670.00, 120, 129),
            new WeightBracket(100.00, 670.00, 120, 129),
    }, 100.00),

    // LATVIA (LV)
    LV_OMNIVA_HD("LV Omniva HD", new WeightBracket[]{
            new WeightBracket(1.00, 270.00, 70, 120),
            new WeightBracket(2.00, 300.00, 70, 120),
            new WeightBracket(5.00, 300.00, 70, 120),
            new WeightBracket(10.00, 320.00, 70, 120),
            new WeightBracket(15.00, 340.00, 120, 150),
            new WeightBracket(30.00, 450.00, 999, 999),
    }, 30.00),

    LV_VENIPAK_BOX("LV Venipak Box", new WeightBracket[]{
            new WeightBracket(2.00, 160.00, 61, 119),
            new WeightBracket(5.00, 160.00, 61, 119),
            new WeightBracket(10.00, 190.00, 61, 119),
            new WeightBracket(15.00, 190.00, 61, 119),
    }, 15.00),

    LV_VENIPAK_HD("LV Venipak HD", new WeightBracket[]{
            new WeightBracket(2.00, 190.00, 70, 120),
            new WeightBracket(5.00, 200.00, 70, 120),
            new WeightBracket(10.00, 270.00, 70, 120),
            new WeightBracket(15.00, 330.00, 120, 150),
            new WeightBracket(30.00, 410.00, 999, 999),
            new WeightBracket(50.00, 480.00, 999, 999),
    }, 50.00),

    LV_VENIPAK_PP("LV Venipak PP", new WeightBracket[]{
            new WeightBracket(2.00, 160.00, 70, 120),
            new WeightBracket(5.00, 160.00, 70, 120),
            new WeightBracket(10.00, 190.00, 70, 120),
    }, 10.00),

    // LITHUANIA (LT)
    LT_LITHUANIAN_POST_BOX("LT Lithuanian Post Box", new WeightBracket[]{
            new WeightBracket(30.00, 120.00, 74, 170),
    }, 30.00),

    LT_LITHUANIAN_POST_HD("LT Lithuanian Post HD", new WeightBracket[]{
            new WeightBracket(2.00, 160.00, 70, 120),
            new WeightBracket(5.00, 170.00, 70, 120),
            new WeightBracket(10.00, 200.00, 70, 120),
            new WeightBracket(15.00, 240.00, 70, 120),
            new WeightBracket(30.00, 250.00, 999, 999),
    }, 30.00),

    LT_OMNIVA_BOX("LT Omniva Box", new WeightBracket[]{
            new WeightBracket(5.00, 210.00, 64, 115),
            new WeightBracket(10.00, 220.00, 64, 115),
            new WeightBracket(15.00, 250.00, 64, 115),
            new WeightBracket(30.00, 250.00, 64, 115),
    }, 30.00),

    LT_OMNIVA_HD("LT Omniva HD", new WeightBracket[]{
            new WeightBracket(1.00, 270.00, 70, 120),
            new WeightBracket(2.00, 300.00, 70, 120),
            new WeightBracket(5.00, 300.00, 70, 120),
            new WeightBracket(10.00, 320.00, 70, 120),
            new WeightBracket(15.00, 350.00, 120, 150),
            new WeightBracket(30.00, 400.00, 999, 999),
    }, 30.00),

    LT_VENIPAK_BOX("LT Venipak Box", new WeightBracket[]{
            new WeightBracket(2.00, 130.00, 61, 119),
            new WeightBracket(5.00, 130.00, 61, 119),
            new WeightBracket(10.00, 160.00, 61, 119),
            new WeightBracket(15.00, 160.00, 61, 119),
    }, 15.00),

    LT_VENIPAK_HD("LT Venipak HD", new WeightBracket[]{
            new WeightBracket(2.00, 170.00, 70, 120),
            new WeightBracket(5.00, 190.00, 70, 120),
            new WeightBracket(10.00, 250.00, 70, 120),
            new WeightBracket(15.00, 300.00, 120, 150),
            new WeightBracket(30.00, 350.00, 999, 999),
            new WeightBracket(50.00, 400.00, 999, 999),
    }, 50.00),

    LT_VENIPAK_PP("LT Venipak PP", new WeightBracket[]{
            new WeightBracket(2.00, 130.00, 70, 120),
            new WeightBracket(5.00, 130.00, 70, 120),
            new WeightBracket(10.00, 160.00, 70, 120),
    }, 10.00),

    // LUXEMBOURG (LU)
    LU_DPD_HD("LU DPD HD", new WeightBracket[]{
            new WeightBracket(0.50, 350.00, 70, 120),
            new WeightBracket(1.00, 360.00, 70, 120),
            new WeightBracket(2.00, 370.00, 70, 120),
            new WeightBracket(5.00, 450.00, 70, 120),
            new WeightBracket(10.00, 600.00, 70, 120),
            new WeightBracket(15.00, 800.00, 120, 150),
            new WeightBracket(20.00, 900.00, 999, 999),
    }, 20.00),

    LU_LUXEMBOURG_POST_HD("LU Luxembourg Post HD", new WeightBracket[]{
            new WeightBracket(1.00, 340.00, 70, 120),
            new WeightBracket(2.00, 350.00, 70, 120),
            new WeightBracket(5.00, 430.00, 70, 120),
            new WeightBracket(10.00, 560.00, 70, 120),
            new WeightBracket(15.00, 650.00, 70, 120),
            new WeightBracket(30.00, 1000.00, 999, 999),
    }, 30.00),

    // NETHERLANDS (NL)
    NL_DHL_HD("NL DHL HD", new WeightBracket[]{
            new WeightBracket(1.00, 260.00, 70, 120),
            new WeightBracket(2.00, 260.00, 70, 120),
            new WeightBracket(5.00, 310.00, 70, 120),
            new WeightBracket(10.00, 340.00, 70, 120),
            new WeightBracket(15.00, 350.00, 70, 120),
            new WeightBracket(30.00, 500.00, 999, 999),
    }, 30.00),

    NL_DHL_PP("NL DHL PP", new WeightBracket[]{
            new WeightBracket(1.00, 250.00, 70, 120),
            new WeightBracket(2.00, 250.00, 70, 120),
            new WeightBracket(5.00, 260.00, 70, 120),
            new WeightBracket(10.00, 280.00, 70, 120),
            new WeightBracket(15.00, 280.00, 70, 120),
            new WeightBracket(30.00, 370.00, 999, 999),
    }, 30.00),

    NL_DUTCH_POST_HD("NL Dutch Post HD", new WeightBracket[]{
            new WeightBracket(0.50, 220.00, 70, 120),
            new WeightBracket(1.00, 240.00, 70, 120),
            new WeightBracket(2.00, 250.00, 70, 120),
            new WeightBracket(5.00, 320.00, 70, 120),
            new WeightBracket(10.00, 420.00, 70, 120),
            new WeightBracket(15.00, 520.00, 70, 120),
            new WeightBracket(20.00, 630.00, 999, 999),
    }, 20.00),

    // PORTUGAL (PT)
    PT_MRW_HD("PT MRW HD", new WeightBracket[]{
            new WeightBracket(1.00, 190.00, 70, 120),
            new WeightBracket(2.00, 190.00, 70, 120),
            new WeightBracket(5.00, 200.00, 70, 120),
            new WeightBracket(10.00, 290.00, 70, 120),
            new WeightBracket(15.00, 320.00, 120, 150),
            new WeightBracket(30.00, 480.00, 999, 999),
    }, 30.00),

    PT_MRW_PP("PT MRW PP", new WeightBracket[]{
            new WeightBracket(1.00, 170.00, 70, 120),
            new WeightBracket(2.00, 170.00, 70, 120),
            new WeightBracket(5.00, 180.00, 70, 120),
            new WeightBracket(10.00, 270.00, 70, 120),
            new WeightBracket(15.00, 290.00, 120, 150),
            new WeightBracket(30.00, 460.00, 999, 999),
    }, 30.00);

    @Getter
    private final String displayName;
    private final WeightBracket[] brackets;
    private final double maxWeightKg;

    ServiceType(String displayName, WeightBracket[] brackets, double maxWeightKg) {
        this.displayName = displayName;
        this.brackets = brackets;
        this.maxWeightKg = maxWeightKg;
    }

    public static ServiceType fromTransportType(TransportType type) {
        return ServiceType.valueOf(type.name());
    }

    public boolean isCompatible(ShipmentCategory cat) {
        return cat.weightKg().compareTo(BigDecimal.valueOf(maxWeightKg)) <= 0;
    }

    public Optional<WeightBracket> findBracket(ShipmentCategory cat) {
        return Arrays.stream(brackets)
                .filter(b -> cat.weightKg().compareTo(BigDecimal.valueOf(b.maxWeight())) <= 0)
                .max(Comparator.comparingDouble(WeightBracket::maxWeight));
    }

    public Country getCountry() {
        return switch (this) {
            case Z_POINT_PP, Z_BOX, HOME_STANDARD, EVENING_HD -> Country.CZ;

            case HU_Z_POINT_PP, HU_HOME_DELIVERY_HD, HU_EXPRESS_ONE_HD, HU_FOXPOST_BOX,
                 HU_HUNGARIAN_POST_BOX, HU_HUNGARIAN_POST_HD, HU_HUNGARIAN_POST_PP, HU_Z_BOX -> Country.HU;

            case PL_Z_POINT_PP, PL_HOME_DELIVERY_HD, PL_INPOST_PACZKOMATY_BOX, PL_POLISH_POST_PP -> Country.PL;

            case RO_Z_POINT_PP, RO_HOME_DELIVERY_HD, RO_CARGUS_HD, RO_FAN_COURIER_BOX,
                 RO_FAN_COURIER_HD, RO_SAMEDAY_BOX -> Country.RO;

            case SK_Z_POINT_PP -> Country.SK;

            case AT_AUSTRIAN_POST_HD, AT_DPD_HD -> Country.AT;

            case BE_BELGIAN_POST_HD, BE_BELGIAN_POST_PP, BE_DUTCH_POST_HD -> Country.BE;

            case BG_HOME_DELIVERY_HD, BG_BOXNOW_BOX, BG_ECONT_BOX, BG_ECONT_HD, BG_ECONT_PP,
                 BG_SAMEDAY_BOX, BG_SAMEDAY_HD, BG_SPEEDY_HD, BG_SPEEDY_PP -> Country.BG;

            case HR_BOXNOW_BOX, HR_CROATIAN_POST_HD, HR_CROATIAN_POST_PP,
                 HR_OVERSEAS_HD, HR_OVERSEAS_PP -> Country.HR;

            case CY_BOXNOW_BOX -> Country.CY;

            case DK_POST_NORD_HD, DK_POST_NORD_PP -> Country.DK;

            case EE_LITHUANIAN_POST_HD, EE_OMNIVA_BOX, EE_OMNIVA_HD, EE_OMNIVA_PP,
                 EE_VENIPAK_BOX, EE_VENIPAK_HD, EE_VENIPAK_PP -> Country.EE;

            case FI_MATKAHUOLTO_BOX, FI_MATKAHUOLTO_HD, FI_MATKAHUOLTO_PP,
                 FI_POST_NORD_HD, FI_POST_NORD_PP -> Country.FI;

            case FR_COLIS_PRIVE_HD, FR_COLISSIMO_HD, FR_COLISSIMO_PP, FR_MONDIAL_RELAY_PP -> Country.FR;

            case DE_HOME_DELIVERY_HD, DE_HERMES_HD, DE_HERMES_PP -> Country.DE;

            case GR_ACS_HD, GR_ACS_PP, GR_BOXNOW_BOX, GR_ELTA_COURIER_HD, GR_ELTA_COURIER_PP,
                 GR_SPEEDEX_HD, GR_TAXYDROMIKI_HD -> Country.GR;

            case IE_FASTWAY_COURIERS_HD, IE_FEDEX_HD_CONNECT_PLUS, IE_FEDEX_HD_PRIORITY -> Country.IE;

            case IT_BARTOLINI_BOX, IT_BARTOLINI_HD, IT_BARTOLINI_PP,
                 IT_HR_PARCEL_HD, IT_ITALIAN_POST_HD, IT_ITALIAN_POST_PP, IT_ITALIAN_POST_PUNTO_POSTE_PP -> Country.IT;

            case LV_OMNIVA_HD, LV_VENIPAK_BOX, LV_VENIPAK_HD, LV_VENIPAK_PP -> Country.LV;

            case LT_LITHUANIAN_POST_BOX, LT_LITHUANIAN_POST_HD, LT_OMNIVA_BOX, LT_OMNIVA_HD,
                 LT_VENIPAK_BOX, LT_VENIPAK_HD, LT_VENIPAK_PP -> Country.LT;

            case LU_DPD_HD, LU_LUXEMBOURG_POST_HD -> Country.LU;

            case NL_DHL_HD, NL_DHL_PP, NL_DUTCH_POST_HD -> Country.NL;

            case PT_MRW_HD, PT_MRW_PP -> Country.PT;
        };
    }
}