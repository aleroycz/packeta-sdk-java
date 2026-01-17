package com.packeta.sdk.spring;

import com.packeta.sdk.PacketaClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(PacketaClient.class)
@ConditionalOnMissingBean(PacketaClient.class)
@EnableConfigurationProperties(PacketaProperties.class)
public class PacketaAutoConfiguration {

    private final PacketaProperties props;

    public PacketaAutoConfiguration(PacketaProperties props) {
        this.props = props;
    }

    @Bean
    public PacketaClient packetaClient() {
        return new PacketaClient(
                props.getApiPassword(),
                props.getApiKey(),
                props.getXmlBaseUrl(),
                props.getFeedBaseUrl()
        );
    }
}