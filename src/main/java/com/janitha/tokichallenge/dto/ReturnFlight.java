package com.janitha.tokichallenge.dto;

public class ReturnFlight {
  private Flight departing;
  private Flight returning;

  public ReturnFlight(Flight departing, Flight returning) {
    this.departing = departing;
    this.returning = returning;
  }

  public ReturnFlight() {
  }

  public Flight getDeparting() {
    return departing;
  }

  public void setDeparting(Flight departing) {
    this.departing = departing;
  }

  public Flight getReturning() {
    return returning;
  }

  public void setReturning(Flight returning) {
    this.returning = returning;
  }
}
