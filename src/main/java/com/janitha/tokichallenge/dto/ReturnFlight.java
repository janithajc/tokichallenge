package com.janitha.tokichallenge.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ReturnFlight implements Comparable<ReturnFlight> {
  private Flight departing;
  private Flight returning;

  public ReturnFlight(Flight departing, Flight returning) {
    this.departing = departing;
    this.returning = returning;
  }

  @Override
  public int compareTo(ReturnFlight o) {
    return Long.compare(this.departing.getDepartureTime(), o.departing.getDepartureTime());
  }
}
