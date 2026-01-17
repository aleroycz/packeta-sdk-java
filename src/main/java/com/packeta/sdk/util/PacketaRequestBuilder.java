package com.packeta.sdk.util;

import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.model.ApiPassword;
import lombok.experimental.UtilityClass;

/**
 * Builds Packeta REST XML requests where root = method name
 */
@UtilityClass
public class PacketaRequestBuilder {

    private static final String REQUEST_TEMPLATE = """
            <?xml version="1.0" encoding="UTF-8"?>
            <%s>
                <apiPassword>%s</apiPassword>
                %s
            </%s>
            """;

    /**
     * Builds full XML request with method name as root.
     *
     * @param methodName   e.g. "packetTracking", "createPacket"
     * @param apiPassword  **plain** API password (will be hashed inside)
     * @param innerContent inner XML params (without apiPassword)
     * @return complete request string
     */
    public static String buildRequest(String methodName, String apiPassword, String innerContent)
            throws PacketaApiException {

        return String.format(REQUEST_TEMPLATE,
                methodName,
                apiPassword,
                innerContent,
                methodName);
    }

    /**
     * Convenience for methods without extra parameters.
     */
    public static String buildSimpleRequest(String methodName, String apiPassword)
            throws PacketaApiException {
        return buildRequest(methodName, apiPassword, "");
    }
}