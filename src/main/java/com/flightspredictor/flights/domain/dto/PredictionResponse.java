package com.flightspredictor.flights.domain.dto;

public record PredictionResponse(
        String prevision,
        Double probabilidad
) {}
