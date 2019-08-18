package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface SearchEngineResponse {
    BusyFlightsResponse toBusyFlightsResponse();
}
