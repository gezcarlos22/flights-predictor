package com.flightspredictor.flights.infra.airports.client;

import com.flightspredictor.flights.infra.airports.domain.AirportResponse;
import com.flightspredictor.flights.infra.airports.util.AirportUrlBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


@Component
public class AirportApiClient {

    private final RestTemplate restTemplate;

    @Value("${api.market.key:}")
    private String apiKey;

    public AirportApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AirportResponse airportResponse (String iata) {

        String url = AirportUrlBuilder.buildAirportUrl(iata);

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-market-key", apiKey);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, AirportResponse.class).getBody();
    }
}
