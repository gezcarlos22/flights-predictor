package com.flightspredictor.flights.infra.airports.dto;

import com.flightspredictor.flights.infra.airports.domain.AirportResponse;
import com.flightspredictor.flights.infra.airports.util.GoogleMapsUrlBuilder;
import jakarta.validation.constraints.NotNull;

public record AirportData(
        String airportIata,

        String airportName,
        String countryName,
        String cityName,
        Float latitude,
        Float longitude,
        Double elevation,
        String timeZone,
        String googleMaps
) {

    /*
    * Método que devuelve una descripción del aeropuerto
    * */
    public String airportSummary() {
        return String.format("Aeropuerto: %s, Ciudad: %s, País: %s, Ubicación: %s",
                airportName, cityName, countryName, googleMaps);
    }

    public AirportData(AirportResponse airport) {
        this(
                airport.getIata(),
                airport.getAirportName(),
                airport.getCountry().name() !=null ? airport.getCountry().name() : null,
                airport.getCityName(),
                airport.getLocation().lat() != null ? airport.getLocation().lat() : null,
                airport.getLocation().lon() != null ? airport.getLocation().lon() : null,
                airport.getElevation().meter() != null ? airport.getElevation().meter() : null,
                airport.getTimezone(),
                airport.getGoogleMaps() != null
                        ? airport.getGoogleMaps().googleMaps()
                        : null
        );
    }
}
