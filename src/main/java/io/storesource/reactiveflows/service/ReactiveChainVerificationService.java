package io.storesource.reactiveflows.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@Slf4j
public class ReactiveChainVerificationService {

    String mockUrl = "https://b38c28e8a788935d4fbcbb9e68b7f4b2.m.pipedream.net/delay?unit=";

    @Autowired
    private WebClient webClient;

    public Mono<String> runReactiveChain(){
        return chainLink(1)
                .flatMap(this::chainLink)
                .flatMap(this::chainLink)
                .flatMap(this::chainLink)
                .flatMap(this::chainLink)
                .map(Object::toString);
    }

    private Mono<Integer> chainLink (Integer input){
        return webClient.post()
                .uri(mockUrl+input)
                .bodyValue(input)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    log.info(String.valueOf(response));
                    return response.get("value") instanceof Integer ? (Integer) response.get("value") : 2;
                });
    }
}
