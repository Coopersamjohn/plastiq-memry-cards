package com.flashcardsetservice.service;

import java.util.*;

import com.flashcardsetservice.model.Flashcard;
import com.flashcardsetservice.model.FlashcardSet;
import org.reactivestreams.Publisher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FlashcardSetService {

	Mono<Void> delete(FlashcardSet flashcard);
	Mono<Void> deleteAll(Set<FlashcardSet> theseSets);
//	Mono<Void> deleteAll(Flux<FlashcardSet> theseSets);
	Mono<Void> deleteAllById(Set<UUID> ids);
	Mono<Void> deleteById(UUID id);
//	Mono<Void> deleteByName(String name);
	Mono<Boolean> existsById(UUID id);
//	Mono<Boolean> existsById(Mono<UUID> ids);
	Flux<FlashcardSet> findAll();
//	Flux<FlashcardSet> findAllByIds(Flux<UUID> ids);

	Mono<FlashcardSet> findById(String id);

	Mono<FlashcardSet> findById(UUID id);
//	Mono<FlashcardSet> findById(Mono<UUID> id);
	Mono<FlashcardSet> findByName(String name);
	Mono<FlashcardSet> save(FlashcardSet flashcardSet);
	Flux<FlashcardSet> saveAll(List<FlashcardSet> flashcardSets);
//	Flux<FlashcardSet> saveAll(Flux<FlashcardSet> flashcardSets);
	Mono<FlashcardSet> addFlashcard(Flashcard flashcard, UUID flashcardSetId);
//	Mono<FlashcardSet> addFlashcard(Mono<Flashcard> flashcard, UUID flashcardSetId);
	Mono<FlashcardSet> addFlashcards(HashSet<Flashcard> flashcards, UUID flashcardSetId);
//	Mono<FlashcardSet> addFlashcards(Flux<HashSet<Flashcard>> flashcards, UUID flashcardSetId);
	Mono<FlashcardSet> removeFlashcard(Flashcard flashcard, UUID flashcardSetId);
	Mono<FlashcardSet> removeFlashcardById(String flashcardId, UUID flashcardSetId);
//	Mono<FlashcardSet> removeFlashcard(Mono<Flashcard> flashcard, UUID flashcardSetId);
	Mono<FlashcardSet> removeFlashcards(HashSet<Flashcard> flashcards, UUID flashcardSetId);
//	Mono<FlashcardSet> removeFlashcards(Flux<HashSet<Flashcard>> flashcards, UUID flashcardSetId);

}
