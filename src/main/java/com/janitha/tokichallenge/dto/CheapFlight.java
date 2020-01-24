package com.janitha.tokichallenge.dto;

public class CheapFlight {
  private String route;
  private Long arrival;
  private Long departure;

  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  public Long getArrival() {
    return arrival;
  }

  public void setArrival(Long arrival) {
    this.arrival = arrival;
  }

  public Long getDeparture() {
    return departure;
  }

  public void setDeparture(Long departure) {
    this.departure = departure;
  }
}
