package com.flashcardsetservice.controller;

import com.flashcardsetservice.model.FlashcardSet;
import com.flashcardsetservice.service.FlashcardSetService;
import com.flashcardsetservice.service.impl.FlashcardSetServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/flashcard-sets")
@CrossOrigin
public class FlashcardSetController {

    private static Log log = LogFactory.getLog(FlashcardSetController.class);

    @Autowired
    private FlashcardSetService flashcardSetService;

    @GetMapping("/hello")
    @ResponseBody
    public Mono<String> sayHello() {

        log.info("Hello from FlashcardSet Service Controller!");

        return Mono.just("Hello from FlashcardSet Service!");
    }

    @GetMapping("/get-all")
    @ResponseBody
    public Flux<FlashcardSet> getAllFlashcardSets() {

        log.info("Get all FlashcardSets");

        return this.flashcardSetService.findAll();

    }

    @GetMapping("/get-by-id/{flashcardSetId}")
    @ResponseBody
    public Mono<FlashcardSet> getFlashcardSetById(@PathVariable("flashcardSetId") String flashcardSetId) {

        log.info("Get this FlashcardSet by id :: " + flashcardSetId);

        return Mono.from(this.flashcardSetService.findById(UUID.fromString(flashcardSetId)));

    }

    @GetMapping("/get-by-name/{flashcardSetName}")
    @ResponseBody
    public Mono<FlashcardSet> getFlashcardSetByName(@PathVariable("flashcardSetName") String flashcardSetName) {

        log.info("Get this FlashcardSet by name :: " + flashcardSetName);

        return Mono.from(this.flashcardSetService.findByName(flashcardSetName));

    }

    @PostMapping("/create-this-flashcard-set")
    @ResponseBody
    public Mono<FlashcardSet> createThisFlashcardSet(@RequestBody FlashcardSet flashcardSet) {

        log.info("Create this FlashcardSet :: " + flashcardSet);

        return Mono.from(this.flashcardSetService.save(flashcardSet));

    }

    @PutMapping("/update-this-flashcard-set")
    @ResponseBody
    public Mono<FlashcardSet> updateFlashcardSet(@RequestBody FlashcardSet flashcardSet) {

        log.info("Update this FlashcardSet :: " + flashcardSet);

        return this.flashcardSetService.save(flashcardSet);

    }

    @DeleteMapping("/delete-this-flashcard-set/{flashcardSetId}")
    @ResponseBody
    public Mono<Void> deleteThisFlashcardSetById(@PathVariable String flashcardSetId) {

        log.info("Delete this FlashcardSet by id :: " + flashcardSetId);

        return this.flashcardSetService.deleteById(UUID.fromString(flashcardSetId));

    }

}
