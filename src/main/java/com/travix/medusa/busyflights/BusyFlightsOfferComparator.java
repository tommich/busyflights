package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

import java.util.Comparator;

public interface BusyFlightsOfferComparator extends Comparator<BusyFlightsResponse> {
        @Override
        int compare(BusyFlightsResponse o1, BusyFlightsResponse o2);
}
