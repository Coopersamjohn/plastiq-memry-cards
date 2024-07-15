package com.flashcardservice.service;

import java.util.*;

import com.flashcardservice.model.Flashcard;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FlashcardService {

	Mono<Long> count();

	Mono<Void> delete(Flashcard flashcard);
	Mono<Void> deleteAll(Set<Flashcard> theseCards);
	Mono<Void> deleteAllByIds(Set<UUID> ids);
	Mono<Void> deleteById(UUID id);
	Mono<Void> deleteByName(String name);
	Mono<Boolean> existsById(UUID id);
	Flux<Flashcard> findAll();
	Flux<Flashcard> findAllById(ArrayList<UUID> ids);
	Mono<Flashcard> findById(UUID id);
	Mono<Flashcard> findByName(String name);
	Flux<Flashcard> findByFlashcardSetId(UUID id);
	Mono<Flashcard> save(Flashcard flashcard);
	Flux<Flashcard> saveAll(List<Flashcard> flashcards);
	Flux<Flashcard> saveAll(Set<Flashcard> flashcards);

}
