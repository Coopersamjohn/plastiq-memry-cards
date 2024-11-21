package com.flashcards.gateway.controller;

import com.flashcards.gateway.models.Flashcard;
import com.flashcards.gateway.models.comparators.FlashcardNameComparator;
//import com.flashcards.gateway.models.comparators.FlashcardsByFlashcardSetId;
import com.flashcards.gateway.service.impl.FlashcardService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

@RestController
@RequestMapping("/flashcards")
public class FlashcardsController {

    private static Log log = LogFactory.getLog(FlashcardsController.class);

    private FlashcardService flashcardService;

    public FlashcardsController(
            FlashcardService flashcardService
    ) {
        this.flashcardService = flashcardService;
    }

    @GetMapping("/hello-flashcards")
    @ResponseBody
    public Mono<String> getHello() {

        log.info("Hello from flashcards service in the gateway");

        return Mono.just("Hello from flashcards service in the gateway");

    }

    @PostMapping("/create")
    @ResponseBody
    public Mono<Flashcard> createFlashcard(
            @RequestBody Flashcard flashcard) {

        log.info("Create this Flashcard :: " + flashcard);

        return Mono.from(this.flashcardService.createFlashcard(flashcard));

    }

    @GetMapping("/get-all")
    @ResponseBody
    public Flux<Flashcard> getFlashcards() {

        log.info("Get all Flashcards :: ");

//        FlashcardsByFlashcardSetId comp = new FlashcardsByFlashcardSetId();
        FlashcardNameComparator nameComparator = new FlashcardNameComparator();

        return Flux.from(this.flashcardService.getFlashcards())
//                .flatMapIterable(set -> set)
//                .sort(comp)
                .sort(nameComparator)
                .doOnError((error) -> new Exception(error));

    }

    @GetMapping("/by-name/{name}")
    @ResponseBody
    public Flux<Flashcard> getFlashcardByName(@PathVariable("name") String name) {

        log.info("Get this Flashcard by name :: " + name);

        return Flux.from(this.flashcardService.getFlashcardByName(name));

    }

    @GetMapping("/by-id/{id}")
    @ResponseBody
    public Flux<Flashcard> getFlashcardById(@PathVariable String id) {

        log.info("Get this Flashcard by ID :: " + id);

        return Flux.from(this.flashcardService.getFlashcardById(id));

    }

    @PutMapping("/update")
    @ResponseBody
    public Mono<Flashcard> updateFlashcard(
            @RequestBody Flashcard flashcard) {

        log.info("Update this Flashcard :: " + flashcard);

        return this.flashcardService.updateFlashcard(flashcard);

    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Mono<Boolean> deleteFlashcard(
            @RequestBody Flashcard flashcard) {

        log.info("Delete this Flashcard :: " + flashcard);

        return this.flashcardService.deleteFlashcard(flashcard);

    }

}
