package com.packeta.sdk.model.security;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.model.features.AllowTrackingForUsers;
import lombok.Data;

/**
 * Represents additional security options for allowing public tracking or specified users to view packet tracking.
 */
@JacksonXmlRootElement(localName = "security")
@Data
public class Security {
    /**
     * Allow each user to view the tracking of the packet.
     */
    @JacksonXmlProperty(localName = "allowPublicTracking")
    private Boolean allowPublicTracking; // boolean, no

    /**
     * Allow specified users to view the tracking of the packet.
     */
    @JacksonXmlProperty(localName = "allowTrackingForUsers")
    private AllowTrackingForUsers allowTrackingForUsers; // AllowTrackingForUsers, no
}