package com.flashcards.gateway.models;

import com.flashcards.gateway.models.dto.FlashcardDto;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public class FlashcardSet implements Serializable, Comparable<FlashcardSet> {

    private static final long serialVersionUID = 6429089198954215836L;

    private UUID id;
    private String name;
    private HashSet<Flashcard> flashcards;
    private String description;

//    private Category category;
//    private String type;

    public FlashcardSet(
            UUID flashcardSetId,
            String flashcardSetName,
            String flashcardSetDescription,
            HashSet<Flashcard> flashcards
    ) {
        if (flashcardSetId == null) {
            if (flashcards == null) {
                noCards(flashcardSetName, flashcardSetDescription);
            } else {
                if (flashcardSetDescription == null) {
                    withCardsNoDescription(flashcardSetName, flashcards);
                } else {
                    generateUUID(flashcardSetName, flashcardSetDescription, flashcards);
                }
            }
        }
    }

    public FlashcardSet(FlashcardSetBuilder flashcardSetBuilder) {
        super();
        this.id = flashcardSetBuilder.id;
        this.name = flashcardSetBuilder.name;
        this.flashcards = flashcardSetBuilder.flashcards;
        this.description = flashcardSetBuilder.description;
    }

    public static FlashcardSet generateUUID(
            String name,
            String description,
            HashSet<Flashcard> flashcards
    ) {
        return new FlashcardSetBuilder()
                .id(UUID.randomUUID())
                .name(name)
                .description(description)
                .flashcards(flashcards)
                .build();
    }

    public static FlashcardSet noCards(
            String name,
            String description
    ) {
        return FlashcardSet.generateUUID(
                name,
                description,
                new HashSet<Flashcard>()
        );
    }

    public static FlashcardSet withCardsNoDescription(
            String name,
            HashSet<Flashcard> flashcards
    ) {
        return FlashcardSet.generateUUID(
                name,
                "",
                flashcards
        );
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public HashSet<Flashcard> getFlashcards() {
        return this.flashcards;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlashcardSet that = (FlashcardSet) o;
        return Objects.equals(getId(), that.getId())
                && Objects.equals(getName(), that.getName())
                && Objects.equals(getFlashcards(), that.getFlashcards())
                && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getFlashcards(), getDescription());
    }

    @Override
    public String toString() {
        return "FlashcardSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flashcards=" + flashcards +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull FlashcardSet o) {
        return this.getName().compareTo(o.getName());
    }

    public static class FlashcardSetBuilder {

        private UUID id;
        private String name;
        private HashSet<Flashcard> flashcards;
        private String description;

        public FlashcardSetBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public FlashcardSetBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FlashcardSetBuilder flashcards(HashSet<Flashcard> flashcards) {
            this.flashcards = flashcards;
            return this;
        }

        public FlashcardSetBuilder description(String description) {
            this.description = description;
            return this;
        }

        public FlashcardSet build() {
            return new FlashcardSet(this);
        }

    }

}
