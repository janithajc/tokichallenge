package com.janitha.tokichallenge.dto;

import java.util.Arrays;

public class CheapApiResponse {
  CheapFlight[] data;

  public CheapFlight[] getData() {
    return data;
  }

  public void setData(CheapFlight[] data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "CheapApiResponse{" +
        "data=" + Arrays.toString(data) +
        '}';
  }
}
