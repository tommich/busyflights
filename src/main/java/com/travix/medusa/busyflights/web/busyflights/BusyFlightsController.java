package com.travix.medusa.busyflights.web.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BusyFlightsController {

    @Autowired
    private
    BusyFlightsService busyFlightsService;

//http://localhost:8080/busyflights/flights?origin=adf&destination=adf&departureDate=adf&returnDate=adf&numberOfPassengers=2

    @RequestMapping("/busyflights/flights")
    public List<BusyFlightsResponse> getBusyFlights(@Valid BusyFlightsRequest request) {

        System.out.println("busy flights request");
        System.out.println(request);

        return busyFlightsService.getBusyFlights(request);
    }

}
