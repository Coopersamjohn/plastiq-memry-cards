package com.flashcards.gateway.service.impl;

import com.flashcards.gateway.models.Flashcard;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

@Service
@CrossOrigin
public class FlashcardService {

    private static Log log = LogFactory.getLog(FlashcardService.class);

    private WebClient webClient;

    @Value("${flashcard.host}")
    private String host;

    @Value("${flashcard.port}")
    private String port;

    @Value("${flashcard.path.root}")
    private String root;

    @Value("${flashcard.path.getAll}")
    private String getAll;

    @Value("${flashcard.path.name}")
    private String name;

    @Value("${flashcard.path.getById}")
    private String getById;

    @Value("${flashcard.path.getByIds}")
    private String getByIds;

    @Value("${flashcard.path.exists}")
    private String idExists;

    @Value("${flashcard.path.getByFlashcardSetId}")
    private String getByFlashcardSetId;

    @Value("${flashcard.path.save}")
    private String save;

    @Value("${flashcard.path.saveCards}")
    private String saveCards;

    @Value("${flashcard.path.update}")
    private String update;

    @Value("${flashcard.path.delete}")
    private String delete;

    @Value("${flashcard.path.deleteById}")
    private String deleteById;

    @Value("${flashcard.path.deleteThese}")
    private String deleteThese;

    @Value("${flashcard.path.deleteTheseIds}")
    private String deleteTheseIds;

    @Value("${flashcard.path.deleteByName}")
    private String deleteByName;

    public FlashcardService() {

        this.webClient = WebClient.create();

    }

    public Mono<Flashcard> createFlashcard(Flashcard flashcard) {

        return this.webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(save)
                        .build())
                .bodyValue(flashcard)
                .retrieve()
                .bodyToMono(Flashcard.class);

    }

    public Flux<Flashcard> getFlashcards() {
//        "http://localhost:9678/flashcards/get-all"
        log.info(host + port + root + getAll);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(getAll)
                        .build())
                .retrieve().bodyToFlux(Flashcard.class);

    }

    public Mono<Flashcard> getFlashcardByName(String name) {
        log.info(host + port + root + name);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(name)
                        .path("/" + name)
                        .build())
                .retrieve().bodyToMono(Flashcard.class);

    }

    public Mono<Flashcard> getFlashcardById(String id) {
        log.info(host + port + root + getById);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(getById)
                        .path("/" + id)
                        .build())
                .retrieve().bodyToMono(Flashcard.class);

    }

    public Mono<Flashcard> updateFlashcard(Flashcard flashcard) {
        log.info(host + port + root + update);
        return this.webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(update)
                        .build())
                .body(BodyInserters.fromValue(flashcard))
                .exchangeToMono((res) -> res.bodyToMono(Flashcard.class));

    }

    public Mono<Flashcard> deleteFlashcard(Flashcard flashcard) {

        return this.webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(deleteById)
                        .path( "/" + flashcard.getId())
                        .build())
                .exchangeToMono(res -> res.bodyToMono(Flashcard.class));

    }

}
