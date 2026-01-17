package com.packeta.sdk.spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "packeta")
@Data
public class PacketaProperties {
    private String apiPassword;
    private String apiKey;
    private String xmlBaseUrl = "https://www.zasilkovna.cz/api/rest";
    private String feedBaseUrl = "https://pickup-point.api.packeta.com/v5";
}
