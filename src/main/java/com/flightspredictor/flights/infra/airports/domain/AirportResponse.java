package com.flightspredictor.flights.infra.airports.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flightspredictor.flights.infra.airports.dto.external.Country;
import com.flightspredictor.flights.infra.airports.dto.external.Elevation;
import com.flightspredictor.flights.infra.airports.dto.external.GoogleMaps;
import com.flightspredictor.flights.infra.airports.dto.external.Location;
import lombok.Getter;

/*
* Clase intermedia para representar mejor el JSON de respuesta de la API
* y manejar mejor la deserialización de campos necesarios para su almacenamiento
* posterior en la base de datos.
 * */

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirportResponse {
    @JsonProperty("iata")
    String iata;

    @JsonProperty("fullName")
    String airportName;

    Country country;

    @JsonProperty("municipalityName")
    String cityName;

    Location location;
    Elevation elevation;

    @JsonProperty("timeZone")
    String timezone;

    GoogleMaps googleMaps;
}
