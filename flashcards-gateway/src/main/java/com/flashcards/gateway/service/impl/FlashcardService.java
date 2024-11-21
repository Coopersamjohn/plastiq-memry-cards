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
import java.util.UUID;

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
    private String create;

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
        log.info(host + port + root + create);
        return this.webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(create)
                        .build())
                .bodyValue(flashcard)
                .retrieve()
                .bodyToMono(Flashcard.class);

    }

    public Flux<Flashcard> getFlashcards() {
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

    public Flux<Flashcard> getFlashcardsByFlashcardSetId(UUID flashcardSetId) {
        log.info(host + port + root + this.getByFlashcardSetId + flashcardSetId);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(getByFlashcardSetId)
                        .path("/" + flashcardSetId.toString())
                        .build())
                .retrieve().bodyToFlux(Flashcard.class);

    }

    public Mono<Flashcard> getFlashcardByName(String name) {
        log.info(host + port + root + this.name + name);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(this.name)
                        .path("/" + name)
                        .build())
                .retrieve().bodyToMono(Flashcard.class);

    }

    public Mono<Flashcard> getFlashcardById(String id) {
        log.info(host + port + root + getById + id);
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

    public Flux<Flashcard> getFlashcardByIds(String[] ids) {
        log.info(host + port + root + getById + ids);
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(getByIds)
                        .path("/" + ids)
                        .build())
                .retrieve().bodyToFlux(Flashcard.class);

    }

    public Mono<Flashcard> updateFlashcard(Flashcard flashcard) {
        log.info(host + port + root + update + flashcard.getId());
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

    public Mono<Flashcard> saveFlashcards(Flashcard[] flashcards) {
        log.info(host + port + root + saveCards + flashcards.toString());
        return this.webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(saveCards)
                        .build())
                .body(BodyInserters.fromValue(flashcards))
                .exchangeToMono((res) -> res.bodyToMono(Flashcard.class));

    }

    public Mono<Boolean> deleteFlashcard(Flashcard flashcard) {
        log.info(host + port + root + delete + flashcard.getId() );
        return this.webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(delete)
                        .path( "/" + flashcard.getId())
                        .build())
                .exchangeToMono(res -> res.bodyToMono(Boolean.class));

    }

    public Mono<Boolean> deleteFlashcards(Flashcard[] flashcards) {
        log.info(host + port + root + deleteThese + flashcards.toString());
        return this.webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(deleteThese)
                        .build())
                .body(BodyInserters.fromValue(flashcards))
                .exchangeToMono((res) -> res.bodyToMono(Boolean.class));

    }

    public Mono<Boolean> deleteFlashcardById(UUID flashcardId) {
        log.info(host + port + root + deleteById + flashcardId );
        return this.webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(deleteById)
                        .path( "/" + flashcardId)
                        .build())
                .exchangeToMono(res -> res.bodyToMono(Boolean.class));

    }

    public Mono<Boolean> deleteFlashcardsByIds(UUID[] flashcardIds) {
        log.info(host + port + root + deleteTheseIds + flashcardIds );
        return this.webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(deleteTheseIds)
                        .path( "/" + flashcardIds.toString())
                        .build())
                .exchangeToMono(res -> res.bodyToMono(Boolean.class));

    }

    public Mono<Boolean> deleteFlashcardByName(String flashcardName) {
        log.info(host + port + root + deleteByName + flashcardName );
        return this.webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(host)
                        .port(port)
                        .path(root)
                        .path(deleteByName)
                        .path( "/" + flashcardName)
                        .build())
                .exchangeToMono(res -> res.bodyToMono(Boolean.class));

    }

}
