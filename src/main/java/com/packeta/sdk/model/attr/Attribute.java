package com.packeta.sdk.model.attr;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * It's represents additional information about packet or packet item (content of packet). See the list of attributes.
 */
@JacksonXmlRootElement(localName = "attribute")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    /**
     * Name of property.
     */
    @JacksonXmlProperty(localName = "key")
    private String key; // string, yes

    /**
     * Value of property.
     */
    @JacksonXmlProperty(localName = "value")
    private String value; // string, yes
}