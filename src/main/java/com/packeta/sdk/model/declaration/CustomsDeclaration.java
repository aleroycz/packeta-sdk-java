package com.packeta.sdk.model.declaration;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.math.BigDecimal;

/**
 * This is deprecated. Use attributes and items.
 */
@Deprecated
@JacksonXmlRootElement(localName = "customsDeclaration")
@Data
public class CustomsDeclaration {
    /**
     * A cost charged to the customer for shipping in EUR.
     */
    @JacksonXmlProperty(localName = "deliveryCostEur")
    private BigDecimal deliveryCostEur; // decimal, yes

    /**
     * A cost charged to the customer for shipping in the currency of the destination country.
     */
    @JacksonXmlProperty(localName = "deliveryCost")
    private BigDecimal deliveryCost; // decimal, yes

    /**
     * An array describing customs declaration forms. One packet can consist of multiple goods, every one of each must have its own customs declaration form.
     */
    @JacksonXmlProperty(localName = "items")
    private CustomsDeclarationItems items; // CustomsDeclarationItems, yes
}