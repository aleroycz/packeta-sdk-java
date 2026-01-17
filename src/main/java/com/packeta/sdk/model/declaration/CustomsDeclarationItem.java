package com.packeta.sdk.model.declaration;

import com.packeta.sdk.model.enums.CountryCode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * This is deprecated. Use attributes and items.
 */
@Deprecated
@JacksonXmlRootElement(localName = "customsDeclarationItem")
@Data
public class CustomsDeclarationItem {
    /**
     * Harmonized System code (see http://www.tariffnumber.com/).
     */
    @JacksonXmlProperty(localName = "customsCode")
    private String customsCode; // string, yes

    /**
     * Value of the product in EUR.
     */
    @JacksonXmlProperty(localName = "valueEur")
    private BigDecimal valueEur; // decimal, yes

    /**
     * Value of the product in the currency of the destination country.
     */
    @JacksonXmlProperty(localName = "value")
    private BigDecimal value; // decimal, yes

    /**
     * Product EAN code.
     */
    @JacksonXmlProperty(localName = "ean")
    private String ean; // string, yes

    /**
     * Product name in English.
     */
    @JacksonXmlProperty(localName = "productNameEn")
    private String productNameEn; // string, yes

    /**
     * Product name in the language of the destination country.
     */
    @JacksonXmlProperty(localName = "productName")
    private String productName; // string, yes

    /**
     * Count of units. If you have multiple units of the same product, specify just one CustomsDeclarationItem for the product and set this value to count of units e.g. if you want to send 1000 screws then your product is a screw and the units count is 1000.
     */
    @JacksonXmlProperty(localName = "unitsCount")
    private Integer unitsCount; // unsignedInt, yes

    /**
     * Country of origin (COO) - country where the product was made.
     */
    @JacksonXmlProperty(localName = "countryOfOrigin")
    private CountryCode countryOfOrigin; // string, yes

    /**
     * Currency of product value. Required by the Swiss Post.
     */
    @JacksonXmlProperty(localName = "currency")
    private String currency; // string, no

    /**
     * Current product's invoice number. Required by the Swiss Post.
     */
    @JacksonXmlProperty(localName = "invoiceNumber")
    private String invoiceNumber; // string, no

    /**
     * Current product's invoice issue date in format Y-m-d, example: 2018-09-25. Required by the Swiss Post.
     */
    @JacksonXmlProperty(localName = "invoiceIssueDate")
    private LocalDate invoiceIssueDate; // date, no

    /**
     * Weight of the product(s) in grams. Required by the Swiss Post.
     */
    @JacksonXmlProperty(localName = "weight")
    private Integer weight; // unsignedInt, no

    /**
     * Does the current product classify as food or book? Required by the Swiss Post.
     */
    @JacksonXmlProperty(localName = "isFoodBook")
    private Boolean isFoodBook; // boolean, no

    /**
     * Does the current product classify as Volatile Organic Compound? Required by the Swiss Post.
     */
    @JacksonXmlProperty(localName = "isVoc")
    private Boolean isVoc; // boolean, no
}