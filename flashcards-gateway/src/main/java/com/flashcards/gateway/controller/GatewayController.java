package com.flashcards.gateway.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    private static Log log = LogFactory.getLog(GatewayController.class);

    @GetMapping("/hello-flashcard-sets")
    @ResponseBody
    public Mono<Object> getHello() {

        log.info("Hello from Flashcard Sets service in the gateway");

        return Mono.just("Hello from Flashcard Sets service in the gateway");

    }
}
