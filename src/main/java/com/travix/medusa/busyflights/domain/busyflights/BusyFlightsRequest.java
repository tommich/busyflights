package com.travix.medusa.busyflights.domain.busyflights;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BusyFlightsRequest {

    @Size(min = 3, max = 3, message = "origin has to be a 3 letter IATA code(eg. LHR, AMS)")
    private String origin;
    @Size(min = 3, max = 3, message = "destination has to be a 3 letter IATA code(eg. LHR, AMS)")
    private String destination;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate departureDate;
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate returnDate;

    @Min(value = 1, message = "numberOfPassengers parameter cannot be lower than 1")
    @Max(value = 4, message = "numberOfPassengers parameter cannot be greater than 4")
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final LocalDate returnDate) {
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
