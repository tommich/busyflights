package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsOfferByPriceComparator;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.web.busyflights.BusyFlightsService;
import com.travix.medusa.busyflights.web.busyflights.BusyFlightsServiceImpl;
import com.travix.medusa.busyflights.web.crazyair.CrazyAirParamsProvider;
import com.travix.medusa.busyflights.web.toughjet.ToughJetParamsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BusyFlightsApplication {

	@Autowired
	ApplicationContext context;

	@Bean
	BusyFlightsOfferComparator getBusyFlightsOfferComparator() {
		return new BusyFlightsOfferByPriceComparator();
	}

	@Bean
	BusyFlightsService busyFlightsService() {
		return context.getBean(BusyFlightsServiceImpl.class);
	}

	@Bean
	List<RequestSender> requestSenders() {
		return Arrays.asList(
				new RequestSenderImpl<>(new CrazyAirParamsProvider(), CrazyAirResponse[].class),
				new RequestSenderImpl<>(new ToughJetParamsProvider(), ToughJetResponse[].class)
				//TODO: For more search engines just provide new  EngineProvider
				//      - implementation of ParamsProvider
				//  and EngineResponse class
				//      - implementation of SearchEngineResponse.
		);
	}


	public static void main(String[] args) {
		SpringApplication.run(BusyFlightsApplication.class, args);
	}
}
