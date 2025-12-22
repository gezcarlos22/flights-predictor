package com.flightspredictor.flights.controller;

import com.flightspredictor.flights.domain.dto.PredictionRequest;
import com.flightspredictor.flights.domain.service.PredictionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/prediction")
public class PredictionController {
    
    @Autowired
    PredictionService predictionService;
    
    @PostMapping()
    public void predict(@RequestBody @Valid PredictionRequest dto) {
        predictionService.predecirVuelo(dto);
    }
}
