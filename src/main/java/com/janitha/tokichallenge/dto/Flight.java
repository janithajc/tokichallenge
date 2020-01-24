package com.janitha.tokichallenge.dto;

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

  public Flight() {
  }

  public String getDeparture() {
    return departure;
  }

  public void setDeparture(String departure) {
    this.departure = departure;
  }

  public String getArrival() {
    return arrival;
  }

  public void setArrival(String arrival) {
    this.arrival = arrival;
  }

  public Long getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Long departureTime) {
    this.departureTime = departureTime;
  }

  public Long getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(Long arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  @Override
  public String toString() {
    return "Flight{" +
        "departure='" + departure + '\'' +
        ", arrival='" + arrival + '\'' +
        ", departureTime=" + departureTime +
        ", arrivalTime=" + arrivalTime +
        '}';
  }
}
