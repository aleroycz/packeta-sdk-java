package com.packeta.sdk.util;

import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.model.ApiPassword;
import lombok.experimental.UtilityClass;

/**
 * Utility to build Packeta API XML request envelopes with apiPassword.
 */
@UtilityClass
public class PacketaRequestBuilder {

    private static final String API_REQUEST_TEMPLATE = """
            <?xml version="1.0" encoding="UTF-8"?>
            <packetery>
                <apiPassword>%s</apiPassword>
                %s
            </packetery>
            """;

    /**
     * Builds a full Packeta XML request with the apiPassword wrapper.
     *
     * @param apiPassword  your API password
     * @param innerContent the inner XML (e.g., <createPacket>...</createPacket>)
     * @return complete XML request string
     */
    public static String buildRequest(String apiPassword, String innerContent) throws PacketaApiException {
        return String.format(API_REQUEST_TEMPLATE,
                XmlHelper.toXml(new ApiPassword(apiPassword)).trim(),
                innerContent);
    }

    /**
     * Builds a simple request for methods without parameters (e.g., getBranches).
     *
     * @param apiPassword your API password
     * @param methodName  the method name (e.g., getBranches)
     * @return complete XML request string
     */
    public static String buildSimpleRequest(String apiPassword, String methodName) throws PacketaApiException {
        return buildRequest(apiPassword, "<" + methodName + "/>");
    }
}