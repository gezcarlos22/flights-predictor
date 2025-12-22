package com.flightspredictor.flights.domain.dto;

import java.time.LocalDateTime;

public record PredictionRequest(
        String aerolinea,
        String origen,
        String destino,
        LocalDateTime fecha_partida,
        Double distancia_km
) {}
