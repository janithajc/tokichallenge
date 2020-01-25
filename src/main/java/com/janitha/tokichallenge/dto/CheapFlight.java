package com.janitha.tokichallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CheapFlight {
  private String route;
  private Long departure;
  private Long arrival;
}
