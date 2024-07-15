package com.flashcards.gateway.models;

import java.util.HashSet;

public record FlashcardSetRecord(
        String flashcardSetId,
        String flashcardSetName,
        HashSet<Flashcard>flashcards,
        String flashcardSetDescription
) { }
