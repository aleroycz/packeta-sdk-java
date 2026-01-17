package com.packeta.sdk.model.packet;

import com.packeta.sdk.model.features.ItemCollection;
import com.packeta.sdk.model.services.Services;
import com.packeta.sdk.model.Size;
import com.packeta.sdk.model.attr.AttributeCollection;
import com.packeta.sdk.model.declaration.CustomsDeclaration;
import com.packeta.sdk.model.enums.Currency;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.packeta.sdk.model.security.Security;
import com.packeta.sdk.model.tax.RoLogisticsTaxDeclaration;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Packet attributes for creation.
 */
@JacksonXmlRootElement(localName = "packetAttributes")
@Data
@Builder
public class PacketAttributes {
    /**
     * Deprecated attribute.
     * Constraints: 10 digits.
     */
    @JacksonXmlProperty(localName = "id")
    @Deprecated
    private Long id; // unsignedLong, no

    /**
     * ID of the third-party sender or member of Packeta affiliate program.
     * Constraints: 16 alphanumeric.
     */
    @JacksonXmlProperty(localName = "affiliateId")
    private String affiliateId; // string, no

    /**
     * A unique ID of the order (from your e-shop).
     * Constraints: 1-36 alphanumeric.
     */
    @JacksonXmlProperty(localName = "number")
    private String number; // string, yes

    /**
     * Recipient's name.
     * Constraints: 1-32 alphanumeric (regex /^[\p{L}\p{N} ,.'\-&()]+$/ui).
     */
    @JacksonXmlProperty(localName = "name")
    private String name; // string, yes

    /**
     * Recipient's surname.
     * Constraints: 1-32 alphanumeric (regex /^[\p{L}\p{N} ,.'\-&()]+$/ui).
     */
    @JacksonXmlProperty(localName = "surname")
    private String surname; // string, yes

    /**
     * Recipient's company.
     * Constraints: 1-32 alphanumeric.
     */
    @JacksonXmlProperty(localName = "company")
    private String company; // string, no

    /**
     * Recipient's email.
     * Constraints: valid email.
     * Required if no phone.
     */
    @JacksonXmlProperty(localName = "email")
    private String email; // string, if no phone

    /**
     * Recipient's phone.
     * Constraints: valid phone number, examples are in phone number formats.
     * Required if no email.
     */
    @JacksonXmlProperty(localName = "phone")
    private String phone; // string, if no email

    /**
     * Branch ID or an ID of the external carrier.
     * Constraints: valid active branch ID.
     */
    @JacksonXmlProperty(localName = "addressId")
    private Integer addressId; // unsignedInt, yes

    /**
     * Currency of COD and packet value.
     * Constraints: CZK, EUR, HUF, PLN, RON.
     */
    @JacksonXmlProperty(localName = "currency")
    private Currency currency; // string, no

    /**
     * COD amount. Further details can be found in the Common issues section.
     * Constraints: up to 2 decimal places, whole number for CZK, a multiple of 5 for HUF.
     */
    @JacksonXmlProperty(localName = "cod")
    private BigDecimal cod; // decimal, no

    /**
     * Packet's value (for insurance purposes).
     * Constraints: see max. values in TOS.
     */
    @JacksonXmlProperty(localName = "value")
    private BigDecimal value; // decimal, yes

    /**
     * Weight in kg.
     */
    @JacksonXmlProperty(localName = "weight")
    private BigDecimal weight; // decimal, yes

    /**
     * Date for scheduled delivery in future. Package can be delivered on this date or later. The format is YYYY-MM-DD.
     * Constraints: date within next 14 days.
     */
    @JacksonXmlProperty(localName = "deliverOn")
    private LocalDate deliverOn; // date, no

    /**
     * Sender indication. If the entered sender does not exist yet, a new one is created.
     * Required when using more senders.
     */
    @JacksonXmlProperty(localName = "eshop")
    private String eshop; // string, when using more senders

    /**
     * If set to 1, the packet will be handed over only to person older than 18 years. An identification will be required. Functionality is accessible just for Packeta internal pick-up points in CZ/SK/HU/RO, it is not accessible for couriers and external pick-up points.
     * Constraints: 0-1.
     */
    @JacksonXmlProperty(localName = "adultContent")
    private Boolean adultContent; // boolean, no

    /**
     * Sender's note. It will be displayed on the label, if supported by courier. It will be shortened up to 32 characters, if limited by courier.
     * Constraints: 1-128 alphanumeric (except '"' and ';' signs).
     */
    @JacksonXmlProperty(localName = "note")
    private String note; // string, no

    /**
     * Street.
     * Constraints: 1-32 alphanumeric.
     * Required on home delivery.
     */
    @JacksonXmlProperty(localName = "street")
    private String street; // string, on home delivery

    /**
     * House number.
     * Constraints: 1-16 alphanumeric.
     * Required on home delivery.
     */
    @JacksonXmlProperty(localName = "houseNumber")
    private String houseNumber; // string, on home delivery

    /**
     * City.
     * Constraints: 1-32 alphanumeric.
     * Required on home delivery.
     */
    @JacksonXmlProperty(localName = "city")
    private String city; // string, on home delivery

    /**
     * Province.
     * Constraints: 1-32 alphanumeric.
     */
    @JacksonXmlProperty(localName = "province")
    private String province; // string, no

    /**
     * ZIP code.
     * Constraints: valid ZIP.
     * Required on home delivery.
     */
    @JacksonXmlProperty(localName = "zip")
    private String zip; // string, on home delivery

    /**
     * Carrier services separated by a comma. Further details can be found in the Carrier Service section.
     * Constraints: alphanumeric, comma separated.
     */
    @JacksonXmlProperty(localName = "carrierService")
    private String carrierService; // string, no

    /**
     * A custom barcode. Only applicable if you have an agreement about using custom barcodes.
     * Constraints: 1-32 alphanumeric.
     */
    @JacksonXmlProperty(localName = "customerBarcode")
    private String customerBarcode; // string, no

    /**
     * Code of a carrier's pick up point. Required only if the chosen carrier offers them.
     * Constraints: 1-32 alphanumeric.
     * Required yes for some carriers.
     */
    @JacksonXmlProperty(localName = "carrierPickupPoint")
    private String carrierPickupPoint; // string, yes for some carriers

    /**
     * A collection of forms required for goods shipped outside of the European Union.
     * Type: CustomsDeclaration - deprecated (use attributes and items).
     * Required on home delivery outside EU.
     */
    @JacksonXmlProperty(localName = "customsDeclaration")
    private CustomsDeclaration customsDeclaration; // CustomsDeclaration, on home delivery outside EU

    /**
     * Some carriers require the dimensions of the packet.
     * Required yes for some carriers.
     */
    @JacksonXmlProperty(localName = "size")
    private Size size; // Size, yes for some carriers

    /**
     * Additional information which are specific for some carriers or other cases.
     * Required yes for some carriers.
     */
    @JacksonXmlProperty(localName = "attributes")
    private AttributeCollection attributes; // AttributeCollection, yes for some carriers

    /**
     * Additional information about content of packet (for example for customs proceedings).
     * Required yes for some carriers.
     */
    @JacksonXmlProperty(localName = "items")
    private ItemCollection items; // ItemCollection, yes for some carriers

    /**
     * Defines additional security options.
     */
    @JacksonXmlProperty(localName = "security")
    private Security security; // Security, no

    /**
     * Additional services associated with the packet, including carrier services and return destination options.
     */
    @JacksonXmlProperty(localName = "services")
    private Services services; // Services, no

    /**
     * Romanian logistics tax requirement.
     */
    @JacksonXmlProperty(localName = "roLogisticsTaxDeclaration")
    private RoLogisticsTaxDeclaration roLogisticsTaxDeclaration; // RoLogisticsTaxDeclaration, no
}