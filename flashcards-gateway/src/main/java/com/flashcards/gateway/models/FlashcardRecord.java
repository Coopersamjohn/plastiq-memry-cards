package com.flashcards.gateway.models;

public record FlashcardRecord(
        String flashcardId,
        String flashcardName,
        String flashcardDefinition,
        String flashcardNotes
) { }
