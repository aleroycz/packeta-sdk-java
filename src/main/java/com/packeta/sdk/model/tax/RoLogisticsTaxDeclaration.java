package com.packeta.sdk.model.tax;

import com.packeta.sdk.model.enums.CountryCode;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * Romanian logistics tax requirement.
 */
@JacksonXmlRootElement(localName = "roLogisticsTaxDeclaration")
@Data
public class RoLogisticsTaxDeclaration {
    /**
     * Subject to tax per law effective 1.1.2026, for packets ≤150 EUR under CC H7. Full article.
     */
    @JacksonXmlProperty(localName = "isSubjectToTax")
    private Boolean isSubjectToTax; // boolean, no

    /**
     * The country of origin of the packet.
     * Constraints: ISO 3166-1 alpha-2
     * Required if isSubjectToTax set to true.
     */
    @JacksonXmlProperty(localName = "countryOfOrigin")
    private CountryCode countryOfOrigin; // string, If isSubjectToTax set to true
}