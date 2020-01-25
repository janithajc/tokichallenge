package com.janitha.tokichallenge.service;


import com.janitha.tokichallenge.dto.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FlightServiceImplTest {

  private HttpService httpService = mock(HttpService.class);

  private FlightServiceImpl flightService = new FlightServiceImpl(httpService);

  @Test
  public void testGetReturnFlights() {
    ClientResponse mockRes = mock(ClientResponse.class);
    ApiResponse mockApiResponse = mock(ApiResponse.class);
    CheapApiResponse mockCheapApiResponse = mock(CheapApiResponse.class);

    // Possible return flights
    // bf1 -> bf2, bf1 -> cf2, bf2 -> cf2, cf1 -> cf2

    Flight[] mockFlights = getMockFlights();
    CheapFlight[] mockCheapFlights = getMockCheapFlights();

    when(mockApiResponse.getData()).thenReturn(mockFlights);
    when(mockCheapApiResponse.getData()).thenReturn(mockCheapFlights);

    when(mockRes.bodyToMono(ApiResponse.class)).thenReturn(Mono.just(mockApiResponse));
    when(mockRes.bodyToMono(CheapApiResponse.class)).thenReturn(Mono.just(mockCheapApiResponse));

    when(httpService.get(any())).thenReturn(Mono.just(mockRes));
    List<ReturnFlight> returnFlightList = flightService.getReturnFlights().collectList().block();

    assertNotNull(returnFlightList);
    assertEquals(4, returnFlightList.size());

  }

  @Test
  public void testGetAll() {
    ClientResponse mockRes = mock(ClientResponse.class);
    ApiResponse mockApiResponse = mock(ApiResponse.class);
    CheapApiResponse mockCheapApiResponse = mock(CheapApiResponse.class);

    Flight[] mockFlights = getMockFlights();
    CheapFlight[] mockCheapFlights = getMockCheapFlights();

    when(mockApiResponse.getData()).thenReturn(mockFlights);
    when(mockCheapApiResponse.getData()).thenReturn(mockCheapFlights);

    when(mockRes.bodyToMono(ApiResponse.class)).thenReturn(Mono.just(mockApiResponse));
    when(mockRes.bodyToMono(CheapApiResponse.class)).thenReturn(Mono.just(mockCheapApiResponse));

    when(httpService.get(any())).thenReturn(Mono.just(mockRes));
    List<Flight> flightList = flightService.getAll().collectList().block();

    assertNotNull(flightList);
    assertEquals(4, flightList.size());

  }

  private Flight[] getMockFlights() {
    Flight bf1 = new Flight("ABC", "DEF", 0L, 1L);
    Flight bf2 = new Flight("DEF", "ABC", 2L, 3L);

    return new Flight[]{bf1, bf2};
  }

  private CheapFlight[] getMockCheapFlights() {
    CheapFlight cf1 = new CheapFlight("ABC-DEF", 4L, 5L);
    CheapFlight cf2 = new CheapFlight("DEF-ABC", 6L, 7L);

    return new CheapFlight[]{cf1, cf2};
  }
}
