package com.janitha.tokichallenge.dto;

import java.util.Arrays;

public class ApiResponse {
  Flight[] data;

  public Flight[] getData() {
    return data;
  }

  public void setData(Flight[] data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "CheapApiResponse{" +
        "data=" + Arrays.toString(data) +
        '}';
  }
}
