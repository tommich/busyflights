package com.travix.medusa.busyflights.web.busyflights;

import com.travix.medusa.busyflights.BusyFlightsOfferComparator;
import com.travix.medusa.busyflights.RequestSender;
import com.travix.medusa.busyflights.SearchEngineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.web.crazyair.CrazyAirParamsProvider;
import com.travix.medusa.busyflights.web.toughjet.ToughJetParamsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

    @Autowired
    private BusyFlightsOfferComparator busyFlightsOfferComparator;

    @Override
    public List<BusyFlightsResponse> getBusyFlights(BusyFlightsRequest request) {
        //TODO: Make sending the request async and then wait for all the responses before sorting
        List<RequestSender> requestSenders = Arrays.asList(
                new RequestSender<>(new CrazyAirParamsProvider(), CrazyAirResponse[].class),
                new RequestSender<>(new ToughJetParamsProvider(), ToughJetResponse[].class)
                //TODO: For more search engines just provide new  EngineProvider
                //      - implementation of ParamsProvider
                //  and EngineResponse class
                //      - implementation of SearchEngineResponse.
        );

        final int numberOfPassengers = request.getNumberOfPassengers();


        List<BusyFlightsResponse> responses =
                requestSenders.stream()
                        .flatMap(requestSender -> Stream.of(requestSender.sendRequest(request))
                                .map(SearchEngineResponse::toBusyFlightsResponse))
                        .sorted(busyFlightsOfferComparator)
                        .collect(Collectors.toList());

        // Final prices can be calculated as the number of passengers * unit price.
        responses.forEach(it -> it.setFare(it.getFare() * numberOfPassengers));
        return responses;
    }
}
