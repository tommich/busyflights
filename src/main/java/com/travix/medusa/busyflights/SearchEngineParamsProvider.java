package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

import java.util.List;

public interface SearchEngineParamsProvider {
    Object[] getParamsValues(BusyFlightsRequest busyFlightsRequest);

    List<String> getParams();

    String getUrl();
}
