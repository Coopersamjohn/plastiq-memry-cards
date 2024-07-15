package com.flashcards.gateway.models.comparators;

import com.flashcards.gateway.models.Flashcard;

import java.util.Comparator;

public class FlashcardNameComparator implements Comparator<Flashcard> {

    @Override
    public int compare(Flashcard o1, Flashcard o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
