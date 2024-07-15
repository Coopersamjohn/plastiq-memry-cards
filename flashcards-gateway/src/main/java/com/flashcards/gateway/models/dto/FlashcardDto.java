package com.flashcards.gateway.models.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class FlashcardDto implements Serializable, Comparable<FlashcardDto> {

    private static final long serialVersionUID = -7688864133793240490L;

    private UUID flashcardId;
    private UUID flashcardSetId;
    private String flashcardName;
    private String flashcardDefinition;
    private String flashcardNotes;

    public FlashcardDto(
            UUID flashcardId,
            UUID flashcardSetId,
            String flashcardName,
            String flashcardDefinition,
            String flashcardNotes
    ) {
        this.flashcardId = flashcardId;
        this.flashcardSetId = flashcardSetId;
        this.flashcardName = flashcardName;
        this.flashcardDefinition = flashcardDefinition;
        this.flashcardNotes = flashcardNotes;
    }

    public void setFlashcardId(UUID flashcardId) {
        this.flashcardId = flashcardId;
    }

    public UUID getFlashcardId() {
        return flashcardId;
    }

    public void setFlashcardSetId(UUID flashcardSetId) {
        this.flashcardSetId = flashcardSetId;
    }

    public UUID getFlashcardSetId() {
        return flashcardSetId;
    }

    public void setFlashcardName(String flashcardName) {
        this.flashcardName = flashcardName;
    }

    public String getFlashcardName() {
        return flashcardName;
    }

    public void setFlashcardDefinition(String flashcardDefinition) {
        this.flashcardDefinition = flashcardDefinition;
    }

    public String getFlashcardDefinition() {
        return flashcardDefinition;
    }

    public void setFlashcardNotes(String flashcardNotes) {
        this.flashcardNotes = flashcardNotes;
    }

    public String getFlashcardNotes() {
        return flashcardNotes;
    }

    @Override
    public int compareTo(@NotNull FlashcardDto o) {
        return this.getFlashcardName().compareTo(o.getFlashcardName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashcardDto)) return false;
        FlashcardDto that = (FlashcardDto) o;
        return Objects.equals(flashcardId, that.flashcardId) &&
                Objects.equals(flashcardSetId, that.flashcardSetId) &&
                Objects.equals(flashcardName, that.flashcardName) &&
                Objects.equals(flashcardDefinition, that.flashcardDefinition) &&
                Objects.equals(flashcardNotes, that.flashcardNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flashcardId, flashcardSetId, flashcardName, flashcardDefinition, flashcardNotes);
    }

    @Override
    public String toString() {
        return "FlashcardDto{" +
                "flashcardId=" +flashcardId +
                ", flashcardSetId=" + flashcardSetId +
                ", flashcardName='" + flashcardName + '\'' +
                ", flashcardDefinition='" + flashcardDefinition + '\'' +
                ", flashcardNotes='" + flashcardNotes + '\'' +
                '}';
    }

}