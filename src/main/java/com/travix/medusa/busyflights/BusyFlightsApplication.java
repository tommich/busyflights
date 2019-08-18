package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsOfferByPriceComparator;
import com.travix.medusa.busyflights.web.busyflights.BusyFlightsService;
import com.travix.medusa.busyflights.web.busyflights.BusyFlightsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BusyFlightsApplication {

	@Bean
	BusyFlightsOfferComparator getBusyFlightsOfferComparator() {
		return new BusyFlightsOfferByPriceComparator();
	}

	@Bean
	public BusyFlightsService busyFlightsService() {
		return new BusyFlightsServiceImpl();
	}

	//TODO RequestSender could also be injected

	public static void main(String[] args) {
		SpringApplication.run(BusyFlightsApplication.class, args);
	}
}
