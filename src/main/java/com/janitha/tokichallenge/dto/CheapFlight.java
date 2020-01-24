package com.janitha.tokichallenge.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CheapFlight {
  private String route;
  private Long arrival;
  private Long departure;
}
