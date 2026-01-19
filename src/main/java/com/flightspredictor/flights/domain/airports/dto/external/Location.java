package com.flightspredictor.flights.domain.airports.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Location(
        @JsonProperty("lat") Double lat,
        @JsonProperty("lon") Double lon
) {
}
