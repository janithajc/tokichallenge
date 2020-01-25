package com.janitha.tokichallenge.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Flight {
  private String departure;
  private String arrival;
  private Long departureTime;
  private Long arrivalTime;

  public Flight(CheapFlight cheapFlight) {
    String [] routeArr = cheapFlight.getRoute().split("-");
    this.departure = routeArr[0];
    this.arrival = routeArr[1];
    departureTime = cheapFlight.getDeparture();
    arrivalTime = cheapFlight.getArrival();
  }
}
