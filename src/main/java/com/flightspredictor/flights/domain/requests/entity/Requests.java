package com.flightspredictor.flights.domain.requests.entity;

import com.flightspredictor.flights.domain.requests.dto.ModelPredictionRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "request")
@Entity(name = "Requests")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime flightDateTime;
    private String opUniqueCarrier;
    private String origin;
    private String dest;
    private Double distance;

    public Requests(ModelPredictionRequest data) {
        this.id = null;
        this.opUniqueCarrier = data.op_unique_carrier();
        this.origin = data.origin();
        this.dest = data.dest();
        this.distance = data.distance();
    }

}
