package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public interface RequestSender<T extends SearchEngineResponse> {
    T[] sendRequest(BusyFlightsRequest request);
}
