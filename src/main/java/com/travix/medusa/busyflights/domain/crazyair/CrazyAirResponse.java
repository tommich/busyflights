package com.travix.medusa.busyflights.domain.crazyair;

import com.travix.medusa.busyflights.SearchEngineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import javax.validation.constraints.NotNull;

public class CrazyAirResponse implements SearchEngineResponse {


    @NotNull
    private String airline;
    @NotNull
    private double price;
    private String cabinclass;
    @NotNull
    private String departureAirportCode;
    @NotNull
    private String destinationAirportCode;
    @NotNull
    private String departureDate;
    @NotNull
    private String arrivalDate;

    public String getAirline() {
        return airline;
    }

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "CrazyAirResponse{" +
                "airline='" + airline + '\'' +
                ", price=" + price +
                ", cabinclass='" + cabinclass + '\'' +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                '}';
    }

    @Override
    public BusyFlightsResponse toBusyFlightsResponse() {
        return new BusyFlightsResponse(
                this.getAirline(),
                "CrazyAir",
                this.getPrice(),
                this.getDepartureAirportCode(),
                this.getDestinationAirportCode(),
                this.getDepartureDate(),
                this.getArrivalDate()
        );
    }
}
