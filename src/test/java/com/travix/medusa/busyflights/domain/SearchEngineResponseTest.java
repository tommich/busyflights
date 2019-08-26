package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


public class SearchEngineResponseTest {
    @Test
    public void testCrazyAirResponseIsMappedToBusyFlightsResponse() {
        LocalDateTime departureDateTime = LocalDateTime.now();
        LocalDateTime arrivalDateTime = LocalDateTime.now();

        CrazyAirResponse crazyAirResponse1 = new CrazyAirResponse();
        crazyAirResponse1.setAirline("airline1");
        crazyAirResponse1.setPrice(1.0);
        crazyAirResponse1.setDepartureDate(departureDateTime);
        crazyAirResponse1.setArrivalDate(arrivalDateTime);
        crazyAirResponse1.setDepartureAirportCode("DA1");
        crazyAirResponse1.setDestinationAirportCode("DS1");
        crazyAirResponse1.setCabinclass("1");

        BusyFlightsResponse busyFlightsResponse = crazyAirResponse1.toBusyFlightsResponse();

        assertEquals("CrazyAir", busyFlightsResponse.getSupplier());
        assertEquals("airline1", busyFlightsResponse.getAirline());
        assertEquals(BigDecimal.valueOf(1.0).setScale(2, BigDecimal.ROUND_HALF_UP), busyFlightsResponse.getFare());
        assertEquals(departureDateTime, busyFlightsResponse.getDepartureDate());
        assertEquals(arrivalDateTime, busyFlightsResponse.getArrivalDate());
        assertEquals("DA1", busyFlightsResponse.getDepartureAirportCode());
        assertEquals("DS1", busyFlightsResponse.getDestinationAirportCode());
    }


    @Test
    public void testToughJetResponseIsMappedToBusyFlightsResponse() {
        LocalDateTime departureDateTime = LocalDateTime.now();
        LocalDateTime arrivalDateTime = LocalDateTime.now();

        ToughJetResponse toughJetResponse1 = new ToughJetResponse();
        toughJetResponse1.setCarrier("carrier1");
        toughJetResponse1.setBasePrice(200.0);
        toughJetResponse1.setTax(0.1);
        toughJetResponse1.setDiscount(0.1);
        toughJetResponse1.setOutboundDateTime(departureDateTime);
        toughJetResponse1.setInboundDateTime(arrivalDateTime);
        toughJetResponse1.setDepartureAirportName("DA1");
        toughJetResponse1.setArrivalAirportName("AA1");

        BusyFlightsResponse busyFlightsResponse = toughJetResponse1.toBusyFlightsResponse();

        assertEquals("ToughJet", busyFlightsResponse.getSupplier());
        assertEquals("carrier1", busyFlightsResponse.getAirline());
        assertEquals(BigDecimal.valueOf(198).setScale(2, BigDecimal.ROUND_HALF_UP), busyFlightsResponse.getFare());
        assertEquals(departureDateTime, busyFlightsResponse.getDepartureDate());
        assertEquals(arrivalDateTime, busyFlightsResponse.getArrivalDate());
        assertEquals("DA1", busyFlightsResponse.getDepartureAirportCode());
        assertEquals("AA1", busyFlightsResponse.getDestinationAirportCode());
    }


}
