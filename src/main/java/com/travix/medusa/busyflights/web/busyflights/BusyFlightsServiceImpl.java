package com.travix.medusa.busyflights.web.busyflights;

import com.travix.medusa.busyflights.BusyFlightsOfferComparator;
import com.travix.medusa.busyflights.RequestSender;
import com.travix.medusa.busyflights.RequestSenderImpl;
import com.travix.medusa.busyflights.SearchEngineResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

    private BusyFlightsOfferComparator busyFlightsOfferComparator;

    private List<RequestSender> requestSenders;

    @Autowired
    public BusyFlightsServiceImpl(BusyFlightsOfferComparator busyFlightsOfferComparator,
                                  List<RequestSender> requestSenders) {
        this.busyFlightsOfferComparator = busyFlightsOfferComparator;
        this.requestSenders = requestSenders;
        System.out.println(requestSenders);
    }

    @Override
    public List<BusyFlightsResponse> getBusyFlights(BusyFlightsRequest request) {

        final int numberOfPassengers = request.getNumberOfPassengers();


        List<BusyFlightsResponse> responses =
                requestSenders.stream()
                        .map(requestSender ->
                                CompletableFuture.supplyAsync(() ->
                                        requestSender.sendRequest(request)
                                ).thenApply(searchEngineResponses -> Stream.of(searchEngineResponses)
                                        .map(SearchEngineResponse::toBusyFlightsResponse)
                                        .collect(Collectors.toList())
                                ))
                        .map(CompletableFuture::join)
                        .flatMap(Collection::stream)
                        .sorted(busyFlightsOfferComparator)
                        .collect(Collectors.toList());

        // Final prices can be calculated as the number of passengers * unit price.
        responses.forEach(it -> it.setFare(it.getFare()
                .multiply(BigDecimal.valueOf(numberOfPassengers))));
        return responses;
    }
}
