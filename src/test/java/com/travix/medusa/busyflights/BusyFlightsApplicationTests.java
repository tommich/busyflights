package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.web.busyflights.BusyFlightsController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BusyFlightsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mvc;

	//TODO: The test should check the result and not only print it.
//		Provide more granular tests for RequestSender class
	@Test
	public void getBusyFlightsOffers() throws Exception {
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders
				.get("http://localhost:8080/busyflights/flights?origin=adf&destination=adf&departureDate=2019-01-01&returnDate=2019-01-01&numberOfPassengers=1")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print());
	}
}
