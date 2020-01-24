package com.janitha.tokichallenge.service;

import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

public interface HttpService {
  Mono<ClientResponse> get(String uri);
}
