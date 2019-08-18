package com.travix.medusa.busyflights.domain.busyflights;

import com.travix.medusa.busyflights.BusyFlightsOfferComparator;

public class BusyFlightsOfferByPriceComparator implements BusyFlightsOfferComparator {
    @Override
    public int compare(BusyFlightsResponse o1, BusyFlightsResponse o2) {
        return o1.getFare().compareTo(o2.getFare());
    }
}
