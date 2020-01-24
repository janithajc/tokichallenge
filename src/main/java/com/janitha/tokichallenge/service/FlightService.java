package com.janitha.tokichallenge.service;

import com.janitha.tokichallenge.dto.Flight;
import com.janitha.tokichallenge.dto.ReturnFlight;
import reactor.core.publisher.Flux;

public interface FlightService {
  Flux<ReturnFlight> getReturnFlights();
  Flux<Flight> getAll();
}
