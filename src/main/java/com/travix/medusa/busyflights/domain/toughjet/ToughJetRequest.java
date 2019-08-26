package com.travix.medusa.busyflights.domain.toughjet;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Arrays;

public class ToughJetRequest {

    private String from;
    private String to;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate outboundDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate inboundDate;
    private int numberOfAdults;

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public LocalDate getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final LocalDate outboundDate) {
        this.outboundDate = outboundDate;
    }

    public LocalDate getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final LocalDate inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public Object[] parameters() {
        return Arrays.asList(from, to).toArray();
    }

    @Override
    public String toString() {
        return "ToughJetRequest{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", outboundDate='" + outboundDate + '\'' +
                ", inboundDate='" + inboundDate + '\'' +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }
}
