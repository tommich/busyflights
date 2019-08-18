package com.travix.medusa.busyflights.web.toughjet;

import com.travix.medusa.busyflights.SearchEngineParamsProvider;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToughJetParamsProvider implements SearchEngineParamsProvider {
    @Override
    public Object[] getParamsValues(BusyFlightsRequest busyFlightsRequest) {
        return new Object[]{
                busyFlightsRequest.getOrigin(),
                busyFlightsRequest.getDestination(),
                busyFlightsRequest.getDepartureDate(),
                busyFlightsRequest.getReturnDate(),
                busyFlightsRequest.getNumberOfPassengers()
        };
    }

    @Override
    public List<String> getParams() {
        return Arrays.asList(
                "from",
                "to",
                "outboundDate",
                "inboundDate",
                "numberOfAdults"
        );
    }

    @Override
    public String getUrl() {
        return "http://localhost:8080/toughjet/flights?" +
                this.getParams().stream().map(param -> param + "={" + param + "}").collect(Collectors.joining("&"));
    }
}
