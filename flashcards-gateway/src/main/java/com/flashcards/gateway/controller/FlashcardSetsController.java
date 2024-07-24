package com.flashcards.gateway.controller;

import com.flashcards.gateway.models.FlashcardSet;
import com.flashcards.gateway.models.dto.FlashcardSetDto;
import com.flashcards.gateway.service.impl.FlashcardSetService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.LinkedHashSet;

@RestController
@RequestMapping("/flashcard-sets")
public class FlashcardSetsController {

    private static Log log = LogFactory.getLog(FlashcardSetsController.class);

    private FlashcardSetService flashcardSetService;

    public FlashcardSetsController(
            FlashcardSetService flashcardSetService
    ) {

        this.flashcardSetService = flashcardSetService;

    }

    @PostMapping("/create")
    @ResponseBody
    public Mono<FlashcardSet> createFlashcardSet(
            @RequestBody FlashcardSet flashcardSet) {

        log.info("Create this FlashcardSet :: " + flashcardSet);

        return Mono.from(this.flashcardSetService.createFlashcardSet(flashcardSet));

    }

    @GetMapping("/get-all")
    @ResponseBody
    public Flux<FlashcardSet> getFlashcardSets() {

        log.info("Get all FlashcardSets");
        return Flux.from(this.flashcardSetService.getFlashcardSets());

    }

    @GetMapping("/by-name/{name}")
    @ResponseBody
    public Mono<FlashcardSet> getFlashcardSetByName(
            @PathVariable("name") String name) {

        log.info("Get this FlashcardSet by name :: " + name);

        return Mono.from(this.flashcardSetService.getFlashcardSetByName(name));

    }

    @PutMapping("/update")
    @ResponseBody
    public Mono<FlashcardSet> updateFlashcardSet(
            @RequestBody FlashcardSet flashcardSet) {

        log.info("Update this FlashcardSet :: " + flashcardSet);

        return Mono.from(this.flashcardSetService.updateFlashcardSet(flashcardSet));

    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Mono<FlashcardSet> deleteFlashcardSet(
            @RequestBody FlashcardSet flashcardSet) {

        log.info("Delete this FlashcardSet :: " + flashcardSet);

        return Mono.from(this.flashcardSetService.deleteFlashcardSet(flashcardSet));

    }

}
