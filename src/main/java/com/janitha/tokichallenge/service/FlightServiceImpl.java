package com.janitha.tokichallenge.service;

import com.janitha.tokichallenge.dto.ApiResponse;
import com.janitha.tokichallenge.dto.CheapApiResponse;
import com.janitha.tokichallenge.dto.Flight;
import com.janitha.tokichallenge.dto.ReturnFlight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class FlightServiceImpl implements FlightService {
  @Value("${api.cheapURI}")
  private String CHEAP_FLIGHT_URI;

  @Value("${api.businessURI}")
  private String BUSINESS_FLIGHT_URI;

  private HttpService httpService;

  public FlightServiceImpl(HttpService httpService) {
    this.httpService = httpService;
  }

  public Flux<ReturnFlight> getReturnFlights() {
    Flux<Flight> cheapFlights = getCheapFlights();
    Flux<Flight> businessFlights = getBusinessFlights();

    Flux<Flight> allFlights = cheapFlights.mergeWith(businessFlights);

    Map<Flight, Set<Flight>> returnFlights = new HashMap<>();

    return allFlights.collectList().flatMapMany(flights -> {
      flights.forEach(f1 ->
        flights.forEach(f2 -> {
          if(f1.getArrival().equals(f2.getDeparture()) &&
              f1.getDeparture().equals(f2.getArrival()) &&
              f1.getArrivalTime() < f2.getDepartureTime()) {
            returnFlights.putIfAbsent(f1, new HashSet<>());
            returnFlights.get(f1).add(f2);
          }
        }));

      return Flux.fromStream(returnFlights
          .keySet().stream()
          .map(flight -> new ReturnFlight(flight, returnFlights.get(flight))));
    });
  }

  public Flux<Flight> getAll() {
    return getCheapFlights().mergeWith(getBusinessFlights());
  }

  private Flux<Flight> getCheapFlights() {
    Mono<ClientResponse> cheapFlightResult = httpService.get(CHEAP_FLIGHT_URI);

    return cheapFlightResult.flatMap(clientResponse -> clientResponse.bodyToMono(CheapApiResponse.class))
        .flatMapMany(cheapApiResponse -> Flux.fromStream(Arrays.stream(cheapApiResponse.getData()).map(Flight::new)));
  }
  private Flux<Flight> getBusinessFlights() {
    Mono<ClientResponse> businessFlightResult = httpService.get(BUSINESS_FLIGHT_URI);

    return businessFlightResult.flatMap(clientResponse -> clientResponse.bodyToMono(ApiResponse.class))
        .flatMapMany(apiResponse -> Flux.fromArray(apiResponse.getData()));
  }
}
