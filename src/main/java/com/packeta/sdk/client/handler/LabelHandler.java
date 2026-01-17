package com.packeta.sdk.client.handler;

import com.packeta.sdk.client.RequestHandler;
import com.packeta.sdk.exception.PacketaApiException;
import com.packeta.sdk.model.enums.LabelFormat;
import com.packeta.sdk.model.packet.PacketIdWithCourierNumber;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handler responsible for generating various types of shipping labels in Packeta API.
 * <p>
 * Supports generation of:
 * <ul>
 *   <li>Packeta internal labels (PDF, ZPL)</li>
 *   <li>Carrier/transport company labels (PDF, PNG, ZPL)</li>
 *   <li>Batch printing of multiple labels</li>
 * </ul>
 * </p>
 *
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class LabelHandler {

    private final RequestHandler rh;

    /**
     * Generates a single Packeta shipping label in PDF format.
     *
     * @param packetId Packeta packet ID (e.g. "Z123456789")
     * @param format   desired label format (A6 on A4, A6 on A6, 105x148, etc.)
     * @return PDF file content as byte array
     * @throws PacketaApiException when packet doesn't exist, is not printable,
     *                             wrong format requested or other API error occurs
     */
    public byte[] printPacketaLabelPdf(String packetId, LabelFormat format) throws PacketaApiException {
        String xml = "<packetLabelPdf>" +
                "<packetId>" + packetId + "</packetId>" +
                "<format>" + format.getValue() + "</format>" +
                "<offset>0</offset>" +
                "</packetLabelPdf>";
        return rh.binaryXml("packetLabelPdf", xml);
    }

    /**
     * Generates multiple Packeta shipping labels in one PDF document (batch printing).
     *
     * @param packetIds list of Packeta packet IDs to print
     * @param format    desired label format for all labels in the batch
     * @return PDF file containing all requested labels as byte array
     * @throws PacketaApiException when any of the packets cannot be printed
     *                             or other API communication error occurs
     * @throws IllegalArgumentException if packetIds list is empty (in strict implementations)
     */
    public byte[] printPacketaLabelsPdf(List<String> packetIds, LabelFormat format) throws PacketaApiException {
        if (packetIds == null || packetIds.isEmpty()) {
            throw new IllegalArgumentException("List of packet IDs cannot be empty");
        }

        String ids = packetIds.stream()
                .map(id -> "<id>" + id + "</id>")
                .collect(Collectors.joining("", "<packetIds>", "</packetIds>"));

        String xml = "<packetsLabelsPdf>" + ids +
                "<format>" + format.getValue() + "</format>" +
                "<offset>0</offset></packetsLabelsPdf>";

        return rh.binaryXml("packetsLabelsPdf", xml);
    }

    /**
     * Generates a single Packeta shipping label in ZPL format (for Zebra printers).
     *
     * @param packetId Packeta packet ID
     * @param dpi      printer resolution (usually 203 or 300)
     * @return clean ZPL-II command string (after unescaping XML entities)
     * @throws PacketaApiException when label cannot be generated
     */
    public String printPacketaLabelZpl(String packetId, int dpi) throws PacketaApiException {
        String xml = "<packetLabelZpl>" +
                "<packetId>" + packetId + "</packetId>" +
                "<dpi>" + dpi + "</dpi>" +
                "</packetLabelZpl>";

        String escaped = rh.xml("packetLabelZpl", xml, String.class, "result");
        return unescapeZpl(escaped);
    }

    /**
     * Generates carrier-specific (transport company) label in PDF format.
     * Used mainly for packets handed over to external carriers (DPD, GLS, PPL, etc.).
     *
     * @param packetId      Packeta packet ID
     * @param courierNumber specific carrier shipment number
     *                      (usually obtained from {@code createPacket} response)
     * @return PDF file content of the carrier label
     * @throws PacketaApiException when carrier label is not available yet,
     *                             wrong courier number, etc.
     */
    public byte[] printCarrierLabelPdf(String packetId, String courierNumber) throws PacketaApiException {
        String xml = "<packetCourierLabelPdf>" +
                "<packetId>" + packetId + "</packetId>" +
                "<courierNumber>" + courierNumber + "</courierNumber>" +
                "</packetCourierLabelPdf>";
        return rh.binaryXml("packetCourierLabelPdf", xml);
    }

    /**
     * Generates carrier-specific label in PNG format (lower resolution, good for preview/email).
     *
     * @param packetId      Packeta packet ID
     * @param courierNumber carrier shipment number
     * @return PNG image content as byte array
     * @throws PacketaApiException in case of generation failure
     */
    public byte[] printCarrierLabelPng(String packetId, String courierNumber) throws PacketaApiException {
        String xml = "<packetCourierLabelPng>" +
                "<packetId>" + packetId + "</packetId>" +
                "<courierNumber>" + courierNumber + "</courierNumber>" +
                "</packetCourierLabelPng>";
        return rh.binaryXml("packetCourierLabelPng", xml);
    }

    /**
     * Generates multiple carrier labels in one PDF document (batch).
     *
     * @param packets list of pairs (packetId + corresponding courierNumber)
     * @return PDF containing all requested carrier labels
     * @throws PacketaApiException when any label cannot be generated
     */
    public byte[] printMultipleCarrierLabelsPdf(List<PacketIdWithCourierNumber> packets)
            throws PacketaApiException {

        if (packets == null || packets.isEmpty()) {
            throw new IllegalArgumentException("List of packets cannot be empty");
        }

        String items = packets.stream()
                .map(p -> "<packetIdWithCourierNumber>" +
                        "<packetId>" + p.getPacketId() + "</packetId>" +
                        "<courierNumber>" + p.getCourierNumber() + "</courierNumber>" +
                        "</packetIdWithCourierNumber>")
                .collect(Collectors.joining("", "<packetIdsWithCourierNumbers>", "</packetIdsWithCourierNumbers>"));

        String xml = "<packetsCourierLabelsPdf>" +
                items +
                "<offset>0</offset>" +
                "<format>A6 on A6</format>" +  // most common for carrier batch
                "</packetsCourierLabelsPdf>";

        return rh.binaryXml("packetsCourierLabelsPdf", xml);
    }

    /**
     * Generates carrier-specific label in ZPL format.
     *
     * @param packetId      Packeta packet ID
     * @param courierNumber carrier shipment number
     * @param dpi           printer resolution (203 or 300 most common)
     * @return ZPL-II command string ready for printer
     * @throws PacketaApiException on generation failure
     */
    public String printCarrierLabelZpl(String packetId, String courierNumber, int dpi)
            throws PacketaApiException {

        String xml = "<packetCourierLabelZpl>" +
                "<packetId>" + packetId + "</packetId>" +
                "<courierNumber>" + courierNumber + "</courierNumber>" +
                "<dpi>" + dpi + "</dpi>" +
                "</packetCourierLabelZpl>";

        String escaped = rh.xml("packetCourierLabelZpl", xml, String.class, "result");
        return unescapeZpl(escaped);
    }

    /**
     * Internal utility method that converts XML-escaped string back to plain text.
     * Used mainly for ZPL content that contains special characters.
     *
     * @param s XML-escaped string
     * @return unescaped plain string
     */
    private String unescapeZpl(String s) {
        return s.replace("&lt;", "<")
                .replace("&gt;", ">")
                .replace("&amp;", "&")
                .replace("&quot;", "\"")
                .replace("&apos;", "'");
    }
}