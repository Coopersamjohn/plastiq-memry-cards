package com.flashcardservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import io.lettuce.core.event.Event;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("Flashcard")
public class Flashcard implements Serializable, Comparable<Flashcard> {

	private static final long serialVersionUID = 6004438430396144312L;

	@Id
	private UUID id;

	@Indexed
	private ArrayList<UUID> setIds;

	@Indexed
	private String name;

	private String definition;

	private String notes;

	public Flashcard() {
		super();
	}

	public Flashcard(UUID id, ArrayList<UUID> setIds, String name, String definition, String notes) {

		if (id == null) {

			if (setIds == null) {

				generateId(new ArrayList<>(), name, definition, notes);

			} else {

				generateId(setIds, name, definition, notes);

			}
		} else {

			new Builder()
					.id(id)
					.setIds(setIds)
					.name(name)
					.definition(definition)
					.notes(notes)
					.build();

		}
	}

	public Flashcard(Flashcard.Builder flashcardBuilder) {

		super();
		this.id = flashcardBuilder.id;
		this.setIds = flashcardBuilder.setIds;
		this.name = flashcardBuilder.name;
		this.definition = flashcardBuilder.definition;
		this.notes = flashcardBuilder.notes;

	}

	public static Flashcard generateId(ArrayList<UUID> setIds, String name, String definition, String notes) {

		return new Builder()
				.id(UUID.randomUUID())
				.setIds(setIds)
				.name(name)
				.definition(definition)
				.notes(notes)
				.build();

	}

	public static Flashcard withoutSet(String name, String definition, String notes) {

		return generateId(new ArrayList<UUID>(), name, definition, notes);

	}

	public static Flashcard nameAndSetify(ArrayList<UUID> setIds, String name) {

		return generateId(
				setIds,
				name,
				"",
				""
		);

	}

	public static Flashcard nameDefineSetify(ArrayList<UUID> setIds, String name, String definition) {

		return generateId(
				setIds,
				name,
				definition,
				""
		);

	}

	public static Flashcard nameAndDefine(String name, String definition) {

		return generateId(
				null,
				name,
				definition,
				""
		);

	}

	public static Flashcard cardWithId(UUID id, String name, String definition) {

		return new Builder()
				.id(id)
				.name(name)
				.definition(definition)
				.build();

	}

	public UUID getId() {

		return id;

	}

	public void setId(UUID id) {

		this.id = id;

	}

	public ArrayList<UUID> getSetIds() {

		return setIds;

	}

	public void setSetIds(ArrayList<UUID> setIds) {

		this.setIds = setIds;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getDefinition() {

		return definition;

	}

	public void setDefinition(String definition) {

		this.definition = definition;

	}

	public String getNotes() {

		return notes;

	}

	public void setNotes(String notes) {

		this.notes = notes;

	}

	public void addToFlashcardSet(UUID setId) {

		this.setIds.add(setId);

	}

	public void removeFromFlashcardSet(UUID setId) {

		this.setIds.remove(setId);

	}

	@Override
	public int hashCode() {
		return Objects.hash(definition, setIds, id, name, notes);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Flashcard other = (Flashcard) obj;

		return Objects.equals(definition, other.definition) && setIds == other.setIds && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(notes, other.notes);
	}

	@Override
	public String toString() {

		return "Flashcard [id=" + id + ", setIds=" + setIds + ", name=" + name + ", definition="
				+ definition + ", notes=" + notes + "]";
	}

	@Override
	public int compareTo(@NotNull Flashcard o) {
		return this.getName().compareTo(o.getName());
	}

	public static class Builder {
		private UUID id;
		private ArrayList<UUID> setIds;
		private String name;
		private String definition;
		private String notes;

		public Builder id(UUID id) {
			this.id = id;
			return this;
		}

		public Builder setIds(ArrayList<UUID> setIds) {
			this.setIds = setIds;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder definition(String definition) {
			this.definition = definition;
			return this;
		}

		public Builder notes(String notes) {
			this.notes = notes;
			return this;
		}

		public Flashcard build() {
			return new Flashcard(this);
		}
	}

}
