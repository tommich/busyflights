package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BusyFlightsRequest {

    @Size(min = 3, max = 3)
    private String origin;
    @Size(min = 3, max = 3)
    private String destination;


//    TODO: Improve the validation
    @NotNull
    private String departureDate;
    @NotNull
    private String returnDate;

    //TODO send errors to the front end together with the messages
    @Min(value = 1, message = "numberOfPassangers parameter cannot be lower than 1")
    @Max(value = 4, message = "numberOfPassangers parameter cannot be greater than 4")
    private int numberOfPassengers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "BusyFlightsRequest{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
