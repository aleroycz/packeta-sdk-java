package com.packeta.sdk.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.exception.PacketaApiExceptionCustom;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Utility class for XML serialization and deserialization using Jackson XmlMapper.
 * Configured specifically for Packeta's XML requirements (e.g., including XML declaration).
 */
@UtilityClass
public class XmlHelper {

    private static final XmlMapper XML_MAPPER = createXmlMapper();

    private static XmlMapper createXmlMapper() {
        XmlMapper mapper = new XmlMapper();
        mapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
         mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
        return mapper;
    }

    /**
     * Serializes an object to XML string, including the <?xml ?> declaration.
     *
     * @param object the object to serialize
     * @return XML string
     * @throws PacketaApiException if serialization fails
     */
    public static String toXml(Object object) throws PacketaApiException {
        try {
            return XML_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new PacketaApiExceptionCustom("XML_SERIALIZATION_ERROR",
                    "Failed to serialize object to XML: " + object.getClass().getSimpleName(), e);
        }
    }

    // ------------------------------------------------------------------------
    // Deserialization - Single object (Class<T>)
    // ------------------------------------------------------------------------

    /**
     * Deserializes XML string to the target type (single object).
     */
    public static <T> T fromXml(String xml, Class<T> targetType) throws PacketaApiExceptionCustom {
        try {
            return XML_MAPPER.readValue(xml, targetType);
        } catch (IOException e) {
            throw new PacketaApiExceptionCustom("XML_DESERIALIZATION_ERROR",
                    "Failed to deserialize XML to " + targetType.getSimpleName(), e);
        }
    }

    /**
     * Deserializes XML with a specific root element name (useful for results).
     */
    public static <T> T fromXml(String xml, Class<T> targetType, String rootName) throws PacketaApiExceptionCustom {
        try {
            return XML_MAPPER.readerFor(targetType)
                    .withRootName(rootName)
                    .readValue(xml);
        } catch (IOException e) {
            throw new PacketaApiExceptionCustom("XML_DESERIALIZATION_ERROR",
                    "Failed to deserialize XML (root: " + rootName + ") to " + targetType.getSimpleName(), e);
        }
    }

    // ------------------------------------------------------------------------
    // Deserialization - Collections / Complex types (TypeReference<T>)
    // ------------------------------------------------------------------------

    /**
     * Deserializes XML string to a collection or complex type using TypeReference.
     */
    public static <T> T fromXml(String xml, TypeReference<T> typeRef) throws PacketaApiExceptionCustom {
        try {
            return XML_MAPPER.readValue(xml, typeRef);
        } catch (IOException e) {
            throw new PacketaApiExceptionCustom("XML_DESERIALIZATION_ERROR",
                    "Failed to deserialize XML to " + typeRef.getType(), e);
        }
    }

    /**
     * Deserializes XML with a specific root element name using TypeReference.
     */
    public static <T> T fromXml(String xml, TypeReference<T> typeRef, String rootName) throws PacketaApiExceptionCustom {
        try {
            return XML_MAPPER.readerFor(typeRef)
                    .withRootName(rootName)
                    .readValue(xml);
        } catch (IOException e) {
            throw new PacketaApiExceptionCustom("XML_DESERIALIZATION_ERROR",
                    "Failed to deserialize XML (root: " + rootName + ") to " + typeRef.getType(), e);
        }
    }

    /**
     * Checks if the XML response contains a fault (error).
     *
     * @param xml the raw XML response
     * @return true if it contains <fault> or <faultCode>
     */
    public static boolean isFaultResponse(String xml) {
        return xml.contains("<fault>") || xml.contains("<faultCode>");
    }
}