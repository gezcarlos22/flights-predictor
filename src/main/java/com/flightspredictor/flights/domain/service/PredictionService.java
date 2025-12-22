package com.flightspredictor.flights.domain.service;

import com.flightspredictor.flights.domain.dto.PredictionRequest;
import org.springframework.stereotype.Service;


@Service
public class PredictionService {
    public void predecirVuelo(PredictionRequest dto){
        System.out.println(dto);
    }
}
