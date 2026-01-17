package com.packeta.sdk.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dimensions of the packet in millimetres (mm). Is not required, except for certain carriers.
 */
@JacksonXmlRootElement(localName = "size")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {
    /**
     * Length of the packet.
     */
    @JacksonXmlProperty(localName = "length")
    private Integer length; // unsignedInt, yes

    /**
     * Width of the packet.
     */
    @JacksonXmlProperty(localName = "width")
    private Integer width; // unsignedInt, yes

    /**
     * Height of the packet.
     */
    @JacksonXmlProperty(localName = "height")
    private Integer height; // unsignedInt, yes

    public static Size fromSize(Integer length, Integer width, Integer height) {
        return new Size(length, width, height);
    }
}