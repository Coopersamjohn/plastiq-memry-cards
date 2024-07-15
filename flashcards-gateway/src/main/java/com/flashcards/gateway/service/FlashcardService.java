package com.flashcards.gateway.service;

import com.flashcards.gateway.models.Flashcard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;


public interface FlashcardService {

    Mono<Flashcard> createFlashcard(Flashcard flashcard);
    Flux<HashSet<Flashcard>> getFlashcards();
    Mono<Flashcard> getFlashcardByName();
    Mono<Flashcard> updateFlashcard(Flashcard flashcard);
    Mono<Flashcard> deleteFlashcard(Flashcard flashcard);

}
