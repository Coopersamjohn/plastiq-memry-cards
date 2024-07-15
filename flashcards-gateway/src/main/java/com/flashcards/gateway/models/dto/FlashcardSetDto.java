package com.flashcards.gateway.models.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class FlashcardSetDto implements Serializable, Comparable<FlashcardSetDto> {

    private static final long serialVersionUID = -6730930720019489153L;

    private UUID flashcardSetId;
    private String flashcardSetName;
    private String flashcardSetDescription;
    private HashSet<FlashcardDto> flashcardDtos;

    public FlashcardSetDto(
            UUID flashcardSetId,
            String flashcardSetName,
            String flashcardSetDescription,
            HashSet<FlashcardDto> flashcardDtos
    ) {
        if (flashcardSetId == null) {
            if (flashcardDtos == null) {
                noCards(flashcardSetName, flashcardSetDescription);
            } else {
                if (flashcardSetDescription == null) {
                    withCardsNoDescription(flashcardSetName, flashcardDtos);
                } else {
                    generateUUID(flashcardSetName, flashcardSetDescription, flashcardDtos);
                }
            }
        }
    }

    public static FlashcardSetDto generateUUID(
            String flashcardSetName,
            String flashcardSetDescription,
            HashSet<FlashcardDto> flashcards
    ) {
        return new FlashcardSetDto(
                UUID.randomUUID(),
                flashcardSetName,
                flashcardSetDescription,
                flashcards
        );
    }

    public static FlashcardSetDto noCards(
            String flashcardSetName,
            String flashcardSetDescription
    ) {
        return FlashcardSetDto.generateUUID(
                flashcardSetName,
                flashcardSetDescription,
                new HashSet<FlashcardDto>()
        );
    }

    public static FlashcardSetDto withCardsNoDescription(
            String flashcardSetName,
            HashSet<FlashcardDto> flashcards
    ) {
        return FlashcardSetDto.generateUUID(
                flashcardSetName,
                "",
                flashcards
        );
    }

    public void setFlashcardSetId(UUID flashcardSetId) {
        this.flashcardSetId = flashcardSetId;
    }

    public UUID getFlashcardSetId() {
        return flashcardSetId;
    }

    public void setFlashcardSetName(String flashcardSetName) {
        this.flashcardSetName = flashcardSetName;
    }

    public String getFlashcardSetName() {
        return flashcardSetName;
    }

    public void setFlashcardSetDescription(String flashcardSetDescription) {
        this.flashcardSetDescription = flashcardSetDescription;
    }

    public String getFlashcardSetDescription() {
        return flashcardSetDescription;
    }

    public void setFlashcardDtos(HashSet<FlashcardDto> flashcardDtos) {
        this.flashcardDtos = flashcardDtos;
    }

    public HashSet<FlashcardDto> getFlashcardDtos() {
        return flashcardDtos;
    }

    public HashSet<FlashcardDto> addFlashcard(FlashcardDto flashcard) {

        this.flashcardDtos.add(flashcard);
        return this.flashcardDtos;
    }

    public HashSet<FlashcardDto> addFlashcards(HashSet<FlashcardDto> flashcards) {

        this.flashcardDtos.addAll(flashcards);
        return this.flashcardDtos;
    }

    public HashSet<FlashcardDto> removeFlashcard(FlashcardDto flashcard) {

        this.flashcardDtos.remove(flashcard);
        return this.flashcardDtos;
    }

    public HashSet<FlashcardDto> removeFlashcards(HashSet<FlashcardDto> flashcards) {

        this.flashcardDtos.remove(flashcards);
        return this.flashcardDtos;
    }

    public HashSet<FlashcardDto> removeFlashcardById(UUID flashcardId) {

        this.flashcardDtos.removeIf((FlashcardDto flashcard) -> {
            return flashcardId.equals(flashcard.getFlashcardSetId());
        });
        return this.flashcardDtos;
    }

    @Override
    public int compareTo(@NotNull FlashcardSetDto o) {
        return this.getFlashcardSetName().compareTo(o.getFlashcardSetName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashcardSetDto)) return false;
        FlashcardSetDto that = (FlashcardSetDto) o;
        return Objects.equals(flashcardSetId, that.flashcardSetId) &&
                Objects.equals(flashcardSetName, that.flashcardSetName) &&
                Objects.equals(flashcardSetDescription, that.flashcardSetDescription) &&
                Objects.equals(flashcardDtos, that.flashcardDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flashcardSetId, flashcardSetName, flashcardSetDescription, flashcardDtos);
    }

    @Override
    public String toString() {
        return "FlashcardSetDto{" +
                "flashcardSetId=" + flashcardSetId +
                ", flashcardSetName='" + flashcardSetName + '\'' +
                ", flashcardSetDescription='" + flashcardSetDescription + '\'' +
                ", flashcardDtos=" + flashcardDtos +
                '}';
    }
}