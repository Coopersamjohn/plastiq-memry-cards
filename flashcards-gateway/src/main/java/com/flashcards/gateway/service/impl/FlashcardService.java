package com.flashcards.gateway.service.impl;

import com.flashcards.gateway.models.Flashcard;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class FlashcardService {

    private static Log log = LogFactory.getLog(FlashcardService.class);

    private WebClient webClient;

    @Value("${flashcard.host}")
    private String host;

    @Value("${flashcard.port}")
    private String port;

    @Value("${flashcard.path.root}")
    private String rootPath;

    @Value("${flashcard.path.getAll}")
    private String getAllPath;

    @Value("${flashcard.path.name}")
    private String namePath;

    @Value("${flashcard.path.flashcardId}")
    private String flashcardIdPath;

    public FlashcardService() {

        this.webClient = WebClient.create();

    }

    public Mono<Flashcard> createFlashcard(Flashcard flashcard) {

        return this.webClient.post()
                .uri("http://localhost:9678/flashcards/save-flashcard")
                .bodyValue(flashcard)
                .retrieve()
                .bodyToMono(Flashcard.class);

    }

    public Flux<Flashcard> getFlashcards() {
//        "http://localhost:9678/flashcards/get-all"
        log.info(host + port + rootPath + getAllPath);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(rootPath)
                        .path(getAllPath)
                        .build())
                .retrieve().bodyToFlux(Flashcard.class);

    }

    public Mono<Flashcard> getFlashcardByName(String name) {
        log.info(host + port + rootPath + namePath);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(rootPath)
                        .path(namePath)
                        .path("/" + name)
                        .build())
                .retrieve().bodyToMono(Flashcard.class);

    }

    public Mono<Flashcard> getFlashcardById(String id) {
        log.info(host + port + rootPath + flashcardIdPath);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(rootPath)
                        .path(flashcardIdPath)
                        .path("/" + id)
                        .build())
                .retrieve().bodyToMono(Flashcard.class);

    }

    public Mono<Flashcard> updateFlashcard(Flashcard flashcard) {

        return this.webClient.put()
                .uri("http://localhost:9678/flashcards")
                .body(BodyInserters.fromValue(flashcard))
                .exchangeToMono((res) -> res.bodyToMono(Flashcard.class));

    }

    public Mono<Flashcard> deleteFlashcard(Flashcard flashcard) {

        return this.webClient.delete()
                .uri("http://localhost:9678/flashcards")
                .exchangeToMono(res -> res.bodyToMono(Flashcard.class));

    }

}
