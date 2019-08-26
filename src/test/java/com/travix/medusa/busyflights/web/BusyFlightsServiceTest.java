package com.travix.medusa.busyflights.web;

import com.travix.medusa.busyflights.BusyFlightsOfferComparator;
import com.travix.medusa.busyflights.RequestSender;
import com.travix.medusa.busyflights.SearchEngineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsOfferByPriceComparator;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.web.busyflights.BusyFlightsService;
import com.travix.medusa.busyflights.web.busyflights.BusyFlightsServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BusyFlightsServiceTest {
    @Test
    public void testBusyFlightsServiceReturnsSortedResponses() {
        BusyFlightsOfferComparator busyFlightsOfferComparator = new BusyFlightsOfferByPriceComparator();
        List<RequestSender> requestSenders = new ArrayList<>();
        BusyFlightsResponse busyFlightsResponse1 = new BusyFlightsResponse(
                "carrier1",
                "ToughJet",
                new BigDecimal(3.0),
                "DA1",
                "AA1",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        BusyFlightsResponse busyFlightsResponse2 = new BusyFlightsResponse(
                "carrier2",
                "ToughJet",
                new BigDecimal(2.0),
                "DA2",
                "AA2",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        BusyFlightsResponse busyFlightsResponse3 = new BusyFlightsResponse(
                "carrier3",
                "CrazyAir",
                new BigDecimal(1.0),
                "DA3",
                "AA3",
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        SearchEngineResponse[] searchEngineResponses = {
                () -> busyFlightsResponse1,
                () -> busyFlightsResponse2,
                () -> busyFlightsResponse3
        };

        requestSenders.add(request -> searchEngineResponses);

        BusyFlightsService busyFlightsService = new BusyFlightsServiceImpl(busyFlightsOfferComparator, requestSenders);

        List<BusyFlightsResponse> actualResponses = busyFlightsService.getBusyFlights(new BusyFlightsRequest());

        List<BusyFlightsResponse> expectedResponses = Arrays.asList(
                busyFlightsResponse3,
                busyFlightsResponse2,
                busyFlightsResponse1
        );

        assertEquals(expectedResponses, actualResponses);

    }
}
