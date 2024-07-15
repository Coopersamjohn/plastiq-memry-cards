package com.flashcards.gateway.service.impl;

import com.flashcards.gateway.models.FlashcardSet;

import java.lang.reflect.Type;
import java.util.LinkedHashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:application.properties")
public class FlashcardSetService {

    private static Log log = LogFactory.getLog(FlashcardSetService.class);

    private WebClient webClient;

    private String flashcardSetUri;

    private String flashcardSetPort;

    @Autowired
    public FlashcardSetService(
            @Value("${flashcardSet.uri}") String flashcardSetUri,
            @Value("${flashcardSet.port}") String flashcardSetPort
    ) {

        this.webClient = WebClient.builder().build();

    }

    public Mono<FlashcardSet> createFlashcardSet(FlashcardSet flashcardSet) {

        log.info("Create FlashcardSet Service :: " + flashcardSet);

        return this.webClient.post()
                .uri("http://localhost:9677/flashcard-sets/create-this-flashcard-set")
                .bodyValue(flashcardSet)
                .retrieve()
                .bodyToMono(FlashcardSet.class);

    }

    public Flux<FlashcardSet> getFlashcardSets() {

        ParameterizedTypeReference<LinkedHashSet<FlashcardSet>> type = new
                ParameterizedTypeReference<LinkedHashSet<FlashcardSet>>() {

            @Override
            public Type getType() {

                return super.getType();

            }

        };

        return webClient.get()
                .uri("http://localhost:9677/flashcard-sets/get-all")
                .retrieve().bodyToFlux(FlashcardSet.class);

    }

    public Mono<FlashcardSet> getFlashcardSetByName(String name) {

        return webClient.get()
                .uri((uriBuilder) -> uriBuilder
                        .host("http://localhost:9677/flashcard-sets")
                        .path("/get-by-name/" + name)
                        .build(name))
                .exchangeToMono((res) -> res.bodyToMono(FlashcardSet.class));

    }

    public Mono<FlashcardSet> updateFlashcardSet(FlashcardSet flashcardSet) {

        return this.webClient.put()
                .uri("http://localhost:9677/flashcard-sets")
                .body(BodyInserters.fromValue(flashcardSet))
                .exchangeToMono(res -> res.bodyToMono(FlashcardSet.class));

    }

    public Mono<FlashcardSet> deleteFlashcardSet(FlashcardSet flashcardSet) {

        return this.webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .host("http://localhost:9677/flashcard-sets")
                        .path("/delete-this-flashcard-set/{flashcardSetId}")
                        .build(flashcardSet.getId().toString()))
                .exchangeToMono(res -> res.bodyToMono(FlashcardSet.class));

    }

}
