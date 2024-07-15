package com.flashcardsetservice.service.impl;

import java.util.*;

import com.flashcardsetservice.model.Flashcard;
import com.flashcardsetservice.model.FlashcardSet;
import com.flashcardsetservice.repository.FlashcardSetDao;
import com.flashcardsetservice.service.FlashcardSetService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class FlashcardSetServiceImpl implements FlashcardSetService {

	private static Log log = LogFactory.getLog(FlashcardSetServiceImpl.class);

	@Autowired
	private FlashcardSetDao flashcardSetDao;

	@Override
	public Mono<Void> delete(FlashcardSet flashcardSet) {
		log.info("Delete this FlashcardSet ::" + flashcardSet);
		return Mono.create((sink) -> {
			try {
				this.flashcardSetDao.delete(flashcardSet);
				sink.success(null);
			} catch (Exception e) {
				sink.error(e);
			}
		});

	}

//	@Override
//	public Mono<Void> deleteAll(Flux<FlashcardSet> theseSets) {
//
//		return Mono.just(this.flashcardSetDao.deleteAll(theseSets));
//	}

	@Override
	public Mono<Void> deleteAll(Set<FlashcardSet> theseSets) {
		log.info("Delete these FlashcardSets" + theseSets);
		return Mono.from((x) -> this.flashcardSetDao.deleteAll(theseSets));
	}

	@Override
	public Mono<Void> deleteAllById(Set<UUID> ids) {
		log.info("Delete these FlashcardSets ::" + ids);
		return Mono.from((z) -> this.flashcardSetDao.deleteAllById(ids));
	}

	@Override
	public Mono<Void> deleteById(UUID id) {
		log.info("Delete this FlashcardSet ::" + id);
		return Mono.<Void>fromRunnable(() -> flashcardSetDao.deleteById(id)).doOnError((error) -> new Exception(error))
		.onErrorComplete()
				.subscribeOn(Schedulers.boundedElastic());
	}

//	@Override
//	public Mono<Void> deleteByName(String name) {
//
//		return Mono.from((q) -> this.flashcardSetDao.deleteByName(name));
//	}

	@Override
	public Mono<Boolean> existsById(UUID id) {
		log.info("Does this FlashcardSet exist?" + id);
		return Mono.create(sink -> {
			try {
				sink.success(this.flashcardSetDao.existsById(id));
			} catch (Exception e) {
				sink.success(false);
				sink.error(e);
			}
		});
	}

//	@Override
//	public Mono<Boolean> existsById(Mono<UUID> id) {
//
//		return Mono.just(this.flashcardSetDao.existsById(id));
//	}

	@Override
	public Flux<FlashcardSet> findAll() {
		log.info("FindAll FlashcardSets");
		return Flux.fromIterable(this.flashcardSetDao.findAll());
	}

//	@Override
//	public Flux<FlashcardSet> findAllByIds(Flux<UUID> ids) {
//
//		return Flux.from((x) -> this.flashcardSetDao.findAllByIds(ids));
//	}

	@Override
	public Mono<FlashcardSet> findById(String id) {
		log.info(id);
		return Mono.create((sink) -> {

			try {
				sink.success(this.flashcardSetDao.findById(UUID.fromString(id)).get());
			} catch (Exception e) {
				sink.error(e);
			}

		});
	}

	@Override
	public Mono<FlashcardSet> findById(UUID id) {
		log.info(id);
		return Mono.create((sink) -> {
			try {
				sink.success(this.flashcardSetDao.findById(id).get());
			} catch (Exception e) {
				sink.error(e);
			}
		});
	}

//	@Override
//	public Mono<FlashcardSet> findById(Mono<UUID> id) {
//
//		return Mono.from((x) -> this.flashcardSetDao.findById(id));
//	}

	@Override
	public Mono<FlashcardSet> findByName(String name) {
		log.info(name);
		return Mono.create((sink) -> {

			try {
				sink.success(this.flashcardSetDao.findByName(name).get());
			} catch (Exception e) {
				sink.error(e);
			}
		});
	}

	@Override
	public Mono<FlashcardSet> save(FlashcardSet flashcardSet) {

		log.info(flashcardSet);

		return Mono.create((sink) -> {
			try {
				sink.success(this.flashcardSetDao.save(flashcardSet));
			} catch (Exception e) {
				sink.error(e);
			}
		});

	}

	@Override
	public Flux<FlashcardSet> saveAll(List<FlashcardSet> flashcardSets) {

		log.info("Save all these FlashcardSets :: " + flashcardSets);

		return Flux.create((x) -> this.flashcardSetDao.saveAll(flashcardSets));

	}

//	@Override
//	public Flux<FlashcardSet> saveAll(Flux<FlashcardSet> flashcardSets) {
//
//		return Flux.just((FlashcardSet) this.flashcardSetDao.saveAll(flashcardSets.toIterable()));
//	}

	@Override
	public Mono<FlashcardSet> addFlashcard(Flashcard flashcard, UUID flashcardSetId) {

		log.info("Add this Flashcard :: " + flashcard);

		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
				.map((flashcardSet) -> {
					HashSet<Flashcard> newFlashcards = new HashSet<>();
					newFlashcards.addAll(flashcardSet.getCards());
					newFlashcards.add(flashcard);
					FlashcardSet newFlashcardSet = new FlashcardSet.FlashcardSetBuilder()
							.id(flashcardSet.getId())
							.name(flashcardSet.getName())
							.description(flashcardSet.getDescription())
							.flashcards(newFlashcards)
							.build();
					return newFlashcardSet;
                })
				.doOnError((error) -> new Exception("Error adding flashcard"))
				.onErrorComplete();
	}

//	@Override
//	public Mono<FlashcardSet> addFlashcard(Mono<Flashcard> flashcard, UUID flashcardSetId) {
//
//		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
//						.map((flashcardSet) -> {
//							HashSet<Flashcard> newFlashcards = new HashSet<>();
//							newFlashcards.addAll(flashcardSet.getCards());
//							flashcard.subscribe((card) -> {
//								newFlashcards.add(card);
//							});
//							FlashcardSet newFlashcardSet = new FlashcardSet.FlashcardSetBuilder()
//									.id(flashcardSet.getId())
//									.name(flashcardSet.getName())
//									.description(flashcardSet.getDescription())
//									.flashcards(newFlashcards)
//									.build();
//							return newFlashcardSet;
//						})
//				.doOnError((error) -> new Exception("Error adding flashcard"))
//				.onErrorComplete();
//	}

	@Override
	public Mono<FlashcardSet> addFlashcards(HashSet<Flashcard> flashcards, UUID flashcardSetId) {

		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
						.map((flashcardSet) -> {
							HashSet<Flashcard> newFlashcards = new HashSet<>();
							newFlashcards.addAll(flashcardSet.getCards());
							newFlashcards.addAll(flashcards);
							FlashcardSet newFlashcardSet = new FlashcardSet.FlashcardSetBuilder()
									.id(flashcardSet.getId())
									.name(flashcardSet.getName())
									.description(flashcardSet.getDescription())
									.flashcards(newFlashcards)
									.build();
							return newFlashcardSet;
						})
				.doOnError((error) -> new Exception("Error adding flashcard"))
				.onErrorComplete();
	}

//	@Override
//	public Mono<FlashcardSet> addFlashcards(Flux<HashSet<Flashcard>> flashcards, UUID flashcardSetId) {
//
//		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
//						.map((flashcardSet) -> {
//							HashSet<Flashcard> newFlashcards = new HashSet<>();
//							newFlashcards.addAll(flashcardSet.getCards());
//							flashcards.subscribe((cards) -> newFlashcards.addAll(cards));
//							FlashcardSet newFlashcardSet = new FlashcardSet.FlashcardSetBuilder()
//									.id(flashcardSet.getId())
//									.name(flashcardSet.getName())
//									.description(flashcardSet.getDescription())
//									.flashcards(newFlashcards)
//									.build();
//							return newFlashcardSet;
//						})
//				.doOnError((error) -> new Exception("Error adding flashcard"))
//				.onErrorComplete();
//
//	}

	@Override
	public Mono<FlashcardSet> removeFlashcard(Flashcard flashcard, UUID flashcardSetId) {

		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
						.map((flashcardSet) -> {
							HashSet<Flashcard> updatedFlashcards = new HashSet<>();
							flashcardSet.getCards().remove(flashcard);
							updatedFlashcards.addAll(flashcardSet.getCards());
							FlashcardSet newFlashcardSet = new FlashcardSet.FlashcardSetBuilder()
									.id(flashcardSet.getId())
									.name(flashcardSet.getName())
									.description(flashcardSet.getDescription())
									.flashcards(updatedFlashcards)
									.build();
							return newFlashcardSet;
						})
				.doOnError((error) -> new Exception("Error removing flashcard"))
				.onErrorComplete();

	}

	@Override
	public Mono<FlashcardSet> removeFlashcardById(String flashcardId, UUID flashcardSetId) {
		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
						.map( (flashcardSet) -> {
							flashcardSet.getCards().removeIf((card) -> card.getId().toString() == flashcardId);
							return flashcardSet;
						})
				.onErrorComplete();
	}

//	@Override
//	public Mono<FlashcardSet> removeFlashcard(Mono<Flashcard> flashcard, UUID flashcardSetId) {
//
//		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
//						.map((flashcardSet) -> {
//							HashSet<Flashcard> updatedFlashcards = new HashSet<>();
//							flashcard.subscribe((card) -> {
//								flashcardSet.getCards().remove(card);
//							});
//							updatedFlashcards.addAll(flashcardSet.getCards());
//							FlashcardSet newFlashcardSet = new FlashcardSet.FlashcardSetBuilder()
//									.id(flashcardSet.getId())
//									.name(flashcardSet.getName())
//									.description(flashcardSet.getDescription())
//									.flashcards(updatedFlashcards)
//									.build();
//							return newFlashcardSet;
//						})
//				.doOnError((error) -> new Exception("Error removing flashcard."))
//				.onErrorComplete();
//
//	}

	@Override
	public Mono<FlashcardSet> removeFlashcards(HashSet<Flashcard> flashcards, UUID flashcardSetId) {

		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
						.map( (flashcardSet) -> {
							flashcardSet.getCards().removeAll(flashcards);
							return flashcardSet;
						})
				.doOnError((error) -> new Exception("Error removing flashcards."))
				.onErrorComplete();

	}

//	@Override
//	public Mono<FlashcardSet> removeFlashcards(Flux<HashSet<Flashcard>> flashcards, UUID flashcardSetId) {
//
//		return Mono.just(this.flashcardSetDao.findById(flashcardSetId).get())
//						.map( (flashcardSet) -> {
//							flashcards.subscribe((cards) -> {
//								flashcardSet.getCards().removeAll(cards);
//							});
//							return flashcardSet;
//						})
//				.doOnError((error) -> new Exception("Error removing flashcards."))
//				.onErrorComplete();
//
//	}

}
