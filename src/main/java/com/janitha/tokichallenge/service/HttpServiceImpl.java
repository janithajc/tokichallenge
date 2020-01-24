package com.janitha.tokichallenge.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpServiceImpl implements HttpService {
//  @Value("${api.baseURL}")
  private String BASE_URL = "https://tokigames-challenge.herokuapp.com/api/flights";

  private final WebClient webClient = WebClient.create(BASE_URL);

  @Override
  public Mono<ClientResponse> get(String uri) {
    return webClient.get()
        .uri(uri).accept(MediaType.APPLICATION_JSON)
        .exchange();
  }
}
