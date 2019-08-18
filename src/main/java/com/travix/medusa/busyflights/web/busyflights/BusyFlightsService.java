package com.travix.medusa.busyflights.web.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.List;

public interface BusyFlightsService {
    List<BusyFlightsResponse> getBusyFlights(BusyFlightsRequest request);
}
