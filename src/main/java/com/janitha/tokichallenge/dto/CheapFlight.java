package com.janitha.tokichallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CheapFlight {
  private String route;
  private Long departure;
  private Long arrival;
}
