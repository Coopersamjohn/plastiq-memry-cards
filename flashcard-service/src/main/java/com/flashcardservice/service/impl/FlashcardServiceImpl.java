package com.flashcardservice.service.impl;

import java.util.*;

import com.flashcardservice.exceptions.FlashcardNotFound;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.flashcardservice.repository.FlashcardDao;
import com.flashcardservice.model.Flashcard;
import com.flashcardservice.service.FlashcardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FlashcardServiceImpl implements FlashcardService {

	private static Log log = LogFactory.getLog(FlashcardServiceImpl.class);

	private final FlashcardDao flashcardDao;

	public FlashcardServiceImpl(

			final FlashcardDao flashcardDao

	) {

		this.flashcardDao = flashcardDao;

	}

	@Override
	public Mono<Long> count() {

		return Mono.create((sink) -> {

			try {

				sink.success(this.flashcardDao.count());

			} catch (Exception error) {

				sink.error(error);

			}

		});

	}

	@Override
	public Mono<Void> delete(Flashcard flashcard) {

		return Mono.<Void>from((x) -> this.flashcardDao.delete(flashcard))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Mono<Void> deleteAll(Set<Flashcard> theseCards) {

		return Mono.<Void>from((x) -> this.flashcardDao.deleteAll(theseCards))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Mono<Void> deleteAllByIds(Set<UUID> ids) {

		return Mono.<Void>from((x) -> this.flashcardDao.deleteAllById(ids))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Mono<Void> deleteById(UUID id) {

		return Mono.<Void>from((x) -> this.flashcardDao.deleteById(id))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Mono<Void> deleteByName(String name) {

		return Mono.<Void>from((x) -> this.flashcardDao.deleteByName(name))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Mono<Boolean> existsById(UUID id) {

		return Mono.<Boolean>from((x) -> this.flashcardDao.existsById(id))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Flux<Flashcard> findAll() {
		log.info("FindAll Flashcards");
		return Flux.<Flashcard>fromIterable(this.flashcardDao.findAll());

	}

	@Override
	public Flux<Flashcard> findAllById(ArrayList<UUID> ids) {

		return Flux.<Flashcard>from((x) -> this.flashcardDao.findAllById(ids))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Mono<Flashcard> findById(UUID id) {

		return Mono.<Flashcard>create((x) -> x.success(this.flashcardDao.findById(id).get()))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Mono<Flashcard> findByName(String name) {

		log.info("Find Flashcard by name :: " + name);

		return Mono.<Flashcard>create((sink) -> sink.success(this.flashcardDao.findByName(name).get()))
				.doOnError((err) -> new FlashcardNotFound("Flashcard not found by this name: " + name));

	}

	@Override
	public Flux<Flashcard> findByFlashcardSetId(UUID id) {

		return Flux.<Flashcard>create((x) -> this.flashcardDao.findBySetIds(id))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Mono<Flashcard> save(Flashcard flashcard) {

		log.info("Create Flashcard :: " + flashcard);

		return Mono.<Flashcard>create((x) -> x.success(this.flashcardDao.save(flashcard)));

	}

	@Override
	public Flux<Flashcard> saveAll(List<Flashcard> flashcards) {

		return Flux.<Flashcard>create((x) -> this.flashcardDao.saveAll(flashcards))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

	@Override
	public Flux<Flashcard> saveAll(Set<Flashcard> flashcards) {

		return Flux.<Flashcard>create((x) -> this.flashcardDao.saveAll(flashcards))
				.doOnError((err) -> new FlashcardNotFound(err.getMessage()));

	}

}
