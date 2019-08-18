package com.travix.medusa.busyflights.web.toughjet;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ToughJetController {

    @RequestMapping("/toughjet/flights")
    public List<ToughJetResponse> getToughJetFlights(ToughJetRequest request) {

        System.out.println(request);

        ToughJetResponse toughJetResponse1 = new ToughJetResponse();
        toughJetResponse1.setCarrier("carrier 1");
        toughJetResponse1.setDepartureAirportName("departure airport name 1");
        toughJetResponse1.setArrivalAirportName("arrival airport name 1");
        toughJetResponse1.setBasePrice(2.0);
        toughJetResponse1.setTax(0.1);
        toughJetResponse1.setDiscount(0.1);
        toughJetResponse1.setInboundDateTime("in date 1");
        toughJetResponse1.setOutboundDateTime("out date 2");

        ToughJetResponse toughJetResponse2 = new ToughJetResponse();
        toughJetResponse2.setCarrier("carrier 2");
        toughJetResponse2.setDepartureAirportName("departure airport name 2");
        toughJetResponse2.setArrivalAirportName("arrival airport name 2");
        toughJetResponse2.setBasePrice(4.0);
        toughJetResponse2.setTax(0.1);
        toughJetResponse2.setDiscount(0.1);
        toughJetResponse2.setInboundDateTime("in date 1");
        toughJetResponse2.setOutboundDateTime("out date 2");

        List<ToughJetResponse> toughJetResponses =
                Arrays.asList(
                        toughJetResponse1,
                        toughJetResponse2);

        System.out.println("tough jet responses:");
        toughJetResponses.forEach(System.out::println);

        return toughJetResponses;
    }

}
