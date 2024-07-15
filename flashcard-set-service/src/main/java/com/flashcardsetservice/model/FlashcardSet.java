package com.flashcardsetservice.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Null;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("FlashcardSet")
public class FlashcardSet implements Serializable {

	@Id
	private UUID id;
	@Indexed
	private String name;
	private String description;
	private HashSet<Flashcard> flashcards;

//    private Category category;
//    private String type;

	public FlashcardSet() {}

//	public FlashcardSet(
//			UUID id,
//			String name,
//			String description,
//			HashSet<Flashcard> flashcards
//	) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.description = description;
//		this.flashcards = flashcards;
//	}

	public FlashcardSet(FlashcardSetBuilder flashcardSetBuilder) {
		super();
		this.id = flashcardSetBuilder.id;
		this.name = flashcardSetBuilder.name;
		this.description = flashcardSetBuilder.description;
		this.flashcards = flashcardSetBuilder.flashcards;
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
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public HashSet<Flashcard> getCards() {
		return flashcards;
	}

//	public void addFlashcard(Flashcard flashcard) {
//
//		this.flashcards.add(flashcard);
//	}
//
//	public void addFlashcards(HashSet<Flashcard> flashcards) {
//
//		this.flashcards.addAll(flashcards);
//	}
//
//	public void removeFlashcard(Flashcard flashcard) {
//
//		this.flashcards.remove(flashcard);
//		return this.flashcards;
//	}
//
//	public HashSet<Flashcard> removeFlashcards(HashSet<Flashcard> flashcards) {
//
//		this.flashcards.remove(flashcards);
//		return this.flashcards;
//	}
//
//	public HashSet<Flashcard> removeFlashcardById(UUID flashcardId) {
//
//		this.flashcards.removeIf((Flashcard flashcard) -> {
//            return flashcardId.equals(flashcard.getFlashcardSetId());
//        });
//		return this.flashcards;
//	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FlashcardSet that = (FlashcardSet) o;
		return Objects.equals(getId(), that.getId())
				&& Objects.equals(getName(), that.getName())
				&& Objects.equals(getDescription(), that.getDescription())
				&& Objects.equals(flashcards, that.flashcards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getDescription(), flashcards);
	}

	@Override
	public String toString() {
		return "FlashcardSet{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", flashcards=" + flashcards +
				'}';
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
