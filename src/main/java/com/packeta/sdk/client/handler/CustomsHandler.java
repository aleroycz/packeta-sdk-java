package com.packeta.sdk.client.handler;

import com.packeta.sdk.model.attr.Attribute;
import com.packeta.sdk.model.attr.AttributeCollection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

/**
 * Utility class for creating customs-related attributes required for international shipments
 * with Packeta (Zásilkovna) API.
 * <p>
 * These attributes are typically used when creating packets that cross customs borders
 * (non-EU shipments) and are passed as part of {@link com.packeta.sdk.model.packet.PacketAttributes}.
 * </p>
 * <p>
 * <strong>Usage example:</strong>
 * <pre>{@code
 * AttributeCollection customs = CustomsHandler.createCustomsAttributes(
 *     150.75,              // delivery cost
 *     "INV-20250117-001",  // invoice number
 *     "2025-01-17"         // invoice date YYYY-MM-DD
 * );
 *
 * // Then attach to packet:
 * packetAttributes.setAttributes(customs);
 * }</pre>
 * </p>
 *
 * @since 1.0.0
 */
@AllArgsConstructor
public class CustomsHandler {

    /**
     * Creates a collection of customs attributes for international packet shipment.
     * <p>
     * Required/mandatory fields for customs declaration are usually:
     * <ul>
     *   <li>{@code deliveryCost} – value of shipping costs (almost always required)</li>
     *   <li>Invoice information (recommended/required in many cases)</li>
     * </ul>
     * </p>
     *
     * @param deliveryCost  the total shipping/delivery cost in the invoice currency
     *                      (must be positive number, usually with max 2 decimal places)
     * @param invoiceNumber optional invoice/commercial invoice number
     *                      (highly recommended for most customs authorities)
     * @param invoiceDate   optional date when the invoice was issued
     *                      (format usually {@code YYYY-MM-DD}, recommended when invoice number is provided)
     * @return populated {@link AttributeCollection} ready to be used in packet creation
     * @throws IllegalArgumentException if deliveryCost is negative or zero
     */
    public AttributeCollection createCustomsAttributes(
            double deliveryCost,
            String invoiceNumber,
            String invoiceDate) {

        if (deliveryCost <= 0) {
            throw new IllegalArgumentException("Delivery cost must be positive (was: " + deliveryCost + ")");
        }

        AttributeCollection coll = new AttributeCollection();

        coll.add(new Attribute("deliveryCost", BigDecimal.valueOf(deliveryCost).toPlainString()));

        if (invoiceNumber != null && !invoiceNumber.trim().isEmpty()) {
            coll.add(new Attribute("invoiceNumber", invoiceNumber.trim()));
        }

        if (invoiceDate != null && !invoiceDate.trim().isEmpty()) {
            coll.add(new Attribute("invoiceIssueDate", invoiceDate.trim()));
        }

        return coll;
    }
}