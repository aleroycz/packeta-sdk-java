package com.packeta.sdk.client.handler;

import com.packeta.sdk.client.RequestHandler;
import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.model.claims.ClaimAttributes;
import com.packeta.sdk.model.claims.ClaimWithPasswordAttributes;
import com.packeta.sdk.model.packet.PacketIdDetail;
import com.packeta.sdk.util.XmlHelper;
import lombok.RequiredArgsConstructor;

/**
 * Handler class responsible for creating claims (complaints) related to Packeta packets.
 * <p>
 * Provides methods to create standard claims and claims with additional password protection.
 * </p>
 *
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class ClaimHandler {

    private final RequestHandler rh;

    /**
     * Creates a new standard packet claim (complaint) based on the provided attributes.
     *
     * @param attr detailed attributes of the claim (reason, description, packet ID, etc.)
     * @return {@link PacketIdDetail} containing information about the newly created claim
     *         (including the generated claim ID)
     * @throws PacketaApiException if the API request fails, the server returns an error,
     *         or there are validation/business logic problems
     * @throws IllegalArgumentException if required claim attributes are missing or invalid
     * @see ClaimAttributes
     */
    public PacketIdDetail createClaim(ClaimAttributes attr) throws PacketaApiException {
        return rh.xml("createPacketClaim", XmlHelper.toXml(attr), PacketIdDetail.class, "result");
    }

    /**
     * Creates a new packet claim protected with a password.
     * <p>
     * This type of claim requires the password to be provided later (typically by the customer)
     * to view claim details or to proceed with certain actions.
     * </p>
     *
     * @param attr attributes of the claim including password protection information
     * @return {@link PacketIdDetail} containing information about the newly created claim
     * @throws PacketaApiException if the API request fails, the server returns an error,
     *         password requirements are not met, or other validation/business logic problems occur
     * @throws IllegalArgumentException if required attributes (including password) are missing or invalid
     * @see ClaimWithPasswordAttributes
     */
    public PacketIdDetail createClaimWithPassword(ClaimWithPasswordAttributes attr)
            throws PacketaApiException {
        return rh.xml("createPacketClaimWithPassword", XmlHelper.toXml(attr), PacketIdDetail.class, "result");
    }
}