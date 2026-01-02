package com.flightspredictor.flights.infra.airports;

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

    // Código único de identificación de la Organización de Aviación Civil Internacional
    private String airport_icao;

    // Abreviasión de tres letras asignadas por la Asociación Internacional de Transporte Aéreo
    private String airport_iata;
    private String airport_name;
    private String city_name;

    // Altura en metros sobre el nivel del mar (msnm)
    private Double elevation;
    private Float longitude;
    private Float latitude;

    // Zona horaria (America/Lima)
    private String timezone;
}
