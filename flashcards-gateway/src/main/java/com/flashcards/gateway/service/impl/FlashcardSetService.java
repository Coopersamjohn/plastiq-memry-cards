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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:application.properties")
@CrossOrigin
public class FlashcardSetService {

    private static Log log = LogFactory.getLog(FlashcardSetService.class);

    private WebClient webClient;

    @Value("${flashcardSet.uri}")
    private String host;

    @Value("${flashcardSet.port}")
    private String port;

    @Value("${flashcardSet.path.root}")
    private String root;

    @Value("${flashcardSet.path.getAll}")
    private String getAllSets;

    @Value("${flashcardSet.path.name}")
    private String getByName;

    @Value("${flashcardSet.path.getById}")
    private String getById;

    @Value("${flashcardSet.path.create}")
    private String create;

    @Value("${flashcardSet.path.update}")
    private String update;

    @Value("${flashcardSet.path.delete}")
    private String delete;

    @Autowired
    public FlashcardSetService() {

        this.webClient = WebClient.create();

    }

    public Mono<FlashcardSet> createFlashcardSet(FlashcardSet flashcardSet) {

        log.info("Create FlashcardSet Service :: " + flashcardSet);

        return this.webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(this.host)
                        .port(this.port)
                        .path(this.root)
                        .path(this.create)
                        .build())
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
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(this.host)
                        .port(this.port)
                        .path(this.root)
                        .path(this.getAllSets)
                        .build())
                .retrieve().bodyToFlux(FlashcardSet.class);

    }

    public Mono<FlashcardSet> getFlashcardSetByName(String name) {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(this.host)
                        .port(this.port)
                        .path(this.root)
                        .path(this.getByName)
                        .path( "/" + name)
                        .build())
                .exchangeToMono((res) -> res.bodyToMono(FlashcardSet.class));

    }

    public Mono<FlashcardSet> updateFlashcardSet(FlashcardSet flashcardSet) {

        return this.webClient.put()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(this.host)
                        .port(this.port)
                        .path(this.root)
                        .path(this.update)
                        .build())
                .body(BodyInserters.fromValue(flashcardSet))
                .exchangeToMono(res -> res.bodyToMono(FlashcardSet.class));

    }

    public Mono<FlashcardSet> deleteFlashcardSet(FlashcardSet flashcardSet) {

        return this.webClient.delete()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host(this.host)
                        .port(this.port)
                        .path(this.root)
                        .path(this.delete)
                        .path( "/" + flashcardSet.getId())
                        .build())
                .exchangeToMono(res -> res.bodyToMono(FlashcardSet.class));

    }

}
