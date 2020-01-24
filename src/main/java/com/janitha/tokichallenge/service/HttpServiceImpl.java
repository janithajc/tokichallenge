package com.janitha.tokichallenge.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpServiceImpl implements HttpService {

  private final WebClient webClient;

  public HttpServiceImpl(@Value("${api.baseURL}") final String BASE_URL) {
    webClient = WebClient.create(BASE_URL);
  }

  @Override
  public Mono<ClientResponse> get(String uri) {
    return webClient.get()
        .uri(uri).accept(MediaType.APPLICATION_JSON)
        .exchange();
  }
}
