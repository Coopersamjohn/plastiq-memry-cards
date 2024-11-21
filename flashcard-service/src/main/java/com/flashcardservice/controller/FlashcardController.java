package com.flashcardservice.controller;

import com.flashcardservice.model.Flashcard;
import com.flashcardservice.service.FlashcardService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.SLF4JLogFactory;
import org.apache.logging.slf4j.SLF4JLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@RequestMapping("/flashcards")
@CrossOrigin
public class FlashcardController {

	private static Log log = LogFactory.getLog(FlashcardController.class);

	private FlashcardService flashcardService;

	public FlashcardController(

			FlashcardService flashcardService

	) {

		this.flashcardService = flashcardService;

	}
	
	@GetMapping("/say-hi")
	@ResponseBody
	public String sayHi() {
		log.info("Hello from the FlashcardService Controller");
		return "Hello from the FlashcardService Controller";
	}
	
	@GetMapping("/get-all")
	@ResponseBody
	public Flux<Flashcard> getAll() {
		log.info("Get All Flashcards");
		return Flux.from(this.flashcardService.findAll());

	}

	@GetMapping("/exists-by-id/{id}")
	@ResponseBody
	public Mono<Boolean> existsById(
			@PathVariable("id") UUID id
	) {

		return this.flashcardService.existsById(id);

	}

	@GetMapping("/get-by-id/{id}")
	@ResponseBody
	public Mono<Flashcard> getById(
			@PathVariable("id") UUID id
	) {

		return Mono.from(this.flashcardService.findById(id));

	}

	@GetMapping("/get-by-ids/{ids}")
	@ResponseBody
	public Flux<Flashcard> getByIds(
			@PathVariable("ids") ArrayList<UUID> ids
	) {

		return this.flashcardService.findAllById(ids);

	}

	@GetMapping("/get-by-flashcard-set-id/{id}")
	@ResponseBody
	public Flux<Flashcard> getByFlashcardSetId(
			@PathVariable("id") UUID id
	) {

		return this.flashcardService.findByFlashcardSetId(id);

	}
	
	@GetMapping("/get-by-name/{name}")
	@ResponseBody
	public Mono<Flashcard> getByName(
			@PathVariable("name") String name
	) {

		return Mono.from(this.flashcardService.findByName(name));

	}
	
	@PostMapping("/save-flashcard")
	@ResponseBody
	public Mono<Flashcard> saveFlashcard(
			@RequestBody Flashcard flashcard
	) {

		return Mono.from(this.flashcardService.save(flashcard));

	}

//	@PostMapping("/save-flashcards")
//	@ResponseBody
//	public Flux<Flashcard> saveFlashcards(
//			@RequestBody ArrayList<Flashcard> flashcards
//	) {
//
//		return this.flashcardService.saveAll(flashcards);
//
//	}

	@PostMapping("/save-flashcards")
	@ResponseBody
	public Flux<Flashcard> saveFlashcards(
			@RequestBody Set<Flashcard> flashcards
	) {

		return this.flashcardService.saveAll(flashcards);

	}
	
	@PutMapping("/update-flashcard")
	@ResponseBody
	public Mono<Flashcard> updateFlashcard(
			@RequestBody Flashcard flashcard
	) {

		return this.flashcardService.save(flashcard);

	}

	@DeleteMapping("/delete-flashcard")
	@ResponseBody
	public Mono<Void> deleteFlashcard(
			@RequestBody Flashcard flashcard
	) {

		return this.flashcardService.delete(flashcard);

	}

	@DeleteMapping("/delete-flashcard-by-id/{id}")
	@ResponseBody
	public Mono<Void> deleteFlashcardById(
			@PathVariable("id") UUID id
	) {

		return this.flashcardService.deleteById(id);

	}

	@DeleteMapping("/delete-these-flashcards")
	@ResponseBody
	public Mono<Void> deleteTheseFlashcards(
			@RequestBody Set<Flashcard> flashcards
	) {

		return this.flashcardService.deleteAll(flashcards);

	}

	@DeleteMapping("/delete-these-flashcards-by-ids/{flashcardIds}")
	@ResponseBody
	public Mono<Void> deleteFlashcardsByIds(
			@PathVariable("flashcardIds") Set<UUID> flashcards
	) {

		return this.flashcardService.deleteAllByIds(flashcards);

	}

	@DeleteMapping("/delete-flashcard-by-name/{flashcardName}")
	@ResponseBody
	public Mono<Void> deleteFlashcardsByName(
			@PathVariable("flashcardName") String flashcardName
	) {

		return this.flashcardService.deleteByName(flashcardName);

	}

}
