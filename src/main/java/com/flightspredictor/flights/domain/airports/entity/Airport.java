package com.flightspredictor.flights.domain.airports.entity;

import com.flightspredictor.flights.domain.airports.dto.AirportData;
import com.flightspredictor.flights.domain.airports.util.GoogleMapsUrlBuilder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "airports")
@Entity(name = "Airport")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Abreviasión de tres letras asignadas por la Asociación Internacional de Transporte Aéreo
    private String airportIata;
    private String airportName;
    private String country;
    private String cityName;

    @Column(columnDefinition = "DECIMAL(10,4)")
    private Double longitude;
    @Column(columnDefinition = "DECIMAL(10,4)")
    private Double latitude;

    // Altura en metros sobre el nivel del mar (msnm)
    private Double elevation;

    // Zona horaria (America/Lima)
    private String timeZone;

    // Enlace directo a la ubicación del aeropuerto en google maps
    private String googleMaps;

    public Airport(AirportData data) {
        this.id = null;
        this.airportIata = data.airportIata();
        this.airportName = data.airportName();
        this.country = data.country();
        this.cityName = data.cityName();
        
        // Debug: Ver qué valores llegan
        System.out.println("Datos recibidos - Lat: " + data.latitude() + ", Lon: " + data.longitude());
        
        this.longitude = roundToDecimals(data.longitude(), 4);
        this.latitude = roundToDecimals(data.latitude(), 4);
        
        // Debug: Ver qué valores se guardan
        System.out.println("Datos guardados - Lat: " + this.latitude + ", Lon: " + this.longitude);
        
        this.elevation = data.elevation();
        this.timeZone = data.timeZone();
        this.googleMaps = GoogleMapsUrlBuilder.buildGoogleMapURl(latitude, longitude);
    }

    private Double roundToDecimals(Double value, int decimals) {
        if (value == null) return null;
        double factor = Math.pow(10, decimals);
        return Math.round(value * factor) / factor;
    }

    public String getCountryName() {
        return country;
    }
}
