package com.flashcards.gateway.models.comparators;

import com.flashcards.gateway.models.dto.FlashcardSetDto;

import java.util.Comparator;

public class FlashcardSetDtoNameComparator implements Comparator<FlashcardSetDto> {

    @Override
    public int compare(FlashcardSetDto o1, FlashcardSetDto o2) {
        return o1.getFlashcardSetName().compareTo(o2.getFlashcardSetName());
    }

}
