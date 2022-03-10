package io.storesource.reactiveflows.controller;

import io.storesource.reactiveflows.service.ReactiveChainVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class TestReactiveFlowsController {

    @Autowired
    private ReactiveChainVerificationService chainVerificationService;

    @GetMapping("/testFlow")
    public Mono<ResponseEntity<String>> runReactiveChain(){
        return chainVerificationService.runReactiveChain()
                .map(ResponseEntity::ok);
    }
}
