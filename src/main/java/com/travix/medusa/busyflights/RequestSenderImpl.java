package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import org.springframework.web.client.RestTemplate;

public class RequestSenderImpl<T extends SearchEngineResponse> implements RequestSender<T> {
    private RestTemplate restTemplate = new RestTemplate();
    private final SearchEngineParamsProvider searchEngineParamsProvider;
    private final Class<T[]> tClass;

    public RequestSenderImpl(SearchEngineParamsProvider searchEngineParamsProvider, Class<T[]> tClass) {
        this.searchEngineParamsProvider = searchEngineParamsProvider;
        this.tClass = tClass;
    }

    @Override
    public T[] sendRequest(BusyFlightsRequest request) {
        return restTemplate.getForObject(searchEngineParamsProvider.getUrl(),
                tClass,
                searchEngineParamsProvider.getParamsValues(request)
        );
    }
}
