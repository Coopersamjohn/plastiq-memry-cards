package com.flashcards.gateway.service;

import com.flashcards.gateway.models.FlashcardSet;
import reactor.core.publisher.Mono;

import java.util.Set;

public interface FlashcardSetService {

    Mono<Long> count();
    Mono<Void> delete(FlashcardSet flashcardSet);
    Mono<Void> deleteAll(Set<FlashcardSet> theseSets);
}
