package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.SearchEngineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ToughJetResponse implements SearchEngineResponse {

    //TODO response validation
    @NotNull
    private String carrier;
    @NotNull
    private double basePrice;
    @NotNull
    private double tax;
    @NotNull
    private double discount;
    @NotNull
    private String departureAirportName;
    @NotNull
    private String arrivalAirportName;
    @NotNull
    private LocalDateTime outboundDateTime;
    @NotNull
    private LocalDateTime inboundDateTime;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public @NotNull LocalDateTime getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final LocalDateTime outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public @NotNull LocalDateTime getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final LocalDateTime inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }


    @Override
    public String toString() {
        return "ToughJetResponse{" +
                "carrier='" + carrier + '\'' +
                ", basePrice=" + basePrice +
                ", tax=" + tax +
                ", discount=" + discount +
                ", departureAirportName='" + departureAirportName + '\'' +
                ", arrivalAirportName='" + arrivalAirportName + '\'' +
                ", outboundDateTime='" + outboundDateTime + '\'' +
                ", inboundDateTime='" + inboundDateTime + '\'' +
                '}';
    }

    @Override
    public BusyFlightsResponse toBusyFlightsResponse() {
        return new BusyFlightsResponse(
                this.getCarrier(),
                "ToughJet",
                //TODO discount should be in percentage
                BigDecimal.valueOf(this.getBasePrice() + this.getBasePrice() * tax - this.getDiscount())
                        .setScale(2, BigDecimal.ROUND_HALF_UP),
                this.getDepartureAirportName(),
                this.getArrivalAirportName(),
                this.getOutboundDateTime(),
                this.getInboundDateTime()
        );
    }
}
