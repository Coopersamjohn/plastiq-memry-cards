package com.flashcards.gateway.models.comparators;

import com.flashcards.gateway.models.dto.FlashcardDto;

import java.util.Comparator;

public class FlashcardDtoNameComparator implements Comparator<FlashcardDto> {

    @Override
    public int compare(FlashcardDto o1, FlashcardDto o2) {
        return o1.getFlashcardName().compareTo(o2.getFlashcardName());
    }

}
