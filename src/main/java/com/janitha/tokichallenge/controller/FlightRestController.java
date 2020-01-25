package com.janitha.tokichallenge.controller;

import com.janitha.tokichallenge.dto.Flight;
import com.janitha.tokichallenge.dto.ReturnFlight;
import com.janitha.tokichallenge.service.FlightService;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/flights", produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightRestController {

  private final FlightService flightService;

  public FlightRestController(FlightService flightService) {
    this.flightService = flightService;
  }

  @GetMapping
  Publisher<Flight> getAll() {
    return this.flightService.getAll();
  }

  @GetMapping("/return")
  Publisher<ReturnFlight> returnFlights() {
    return this.flightService.getReturnFlights().sort();
  }
}
