package com.flashcards.gateway.models.comparators;

import com.flashcards.gateway.models.FlashcardSet;

import java.util.Comparator;

public class FlashcardSetNameComparator implements Comparator<FlashcardSet> {

    @Override
    public int compare(FlashcardSet o1, FlashcardSet o2) {

        return o1.getName().compareTo(o2.getName());

    }

}
