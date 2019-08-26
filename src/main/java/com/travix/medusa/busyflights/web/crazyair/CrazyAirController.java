package com.travix.medusa.busyflights.web.crazyair;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class CrazyAirController {

    @RequestMapping("/crazyair/flights")
    public List<CrazyAirResponse> getCrazyAirFlights(CrazyAirRequest request) {

        System.out.println(request);

        CrazyAirResponse crazyAirResponse1 = new CrazyAirResponse();
        crazyAirResponse1.setAirline("airline1");
        crazyAirResponse1.setPrice(1.0);
        crazyAirResponse1.setDepartureDate(LocalDateTime.now());
        crazyAirResponse1.setArrivalDate(LocalDateTime.now());
        crazyAirResponse1.setDepartureAirportCode("DA1");
        crazyAirResponse1.setDestinationAirportCode("DS1");
        crazyAirResponse1.setCabinclass("1");


        CrazyAirResponse crazyAirResponse2 = new CrazyAirResponse();
        crazyAirResponse2.setAirline("airline2");
        crazyAirResponse2.setPrice(3.0);
        crazyAirResponse2.setDepartureDate(LocalDateTime.now());
        crazyAirResponse2.setArrivalDate(LocalDateTime.now());
        crazyAirResponse2.setDepartureAirportCode("DA2");
        crazyAirResponse2.setDestinationAirportCode("DS2");
        crazyAirResponse2.setCabinclass("2");


        List<CrazyAirResponse> crazyAirResponses =
                Arrays.asList(
                        crazyAirResponse1,
                        crazyAirResponse2
                );

        System.out.println("crazy air responses:");
        crazyAirResponses.forEach(System.out::println);

        return crazyAirResponses;
    }

}
