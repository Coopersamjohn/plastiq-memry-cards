package com.flashcardsetservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@RedisHash("Flashcard")
public class Flashcard implements Serializable, Comparable<Flashcard> {

	private static final long serialVersionUID = -3776755374960993909L;
	
	@Id
	private UUID id;
	private ArrayList<UUID> setIds;
	private String name;
	private String definition;
	private String notes;

	public Flashcard() {
		super();
	}

	public Flashcard(UUID id, ArrayList<UUID> setIds, String name, String definition, String notes) {
		super();
		this.id = id;
		this.setIds = setIds;
		this.name = name;
		this.definition = definition;
		this.notes = notes;
	}

	public Flashcard(
			FlashcardBuilder FlashcardBuilder
	) {
		this.id = FlashcardBuilder.id;
		this.setIds = FlashcardBuilder.setIds;
		this.name = FlashcardBuilder.name;
		this.definition = FlashcardBuilder.definition;
		this.notes = FlashcardBuilder.notes;
	}

	public Flashcard(ArrayList<UUID> setIds, String name, String definition, String notes) {
		super();
		this.setIds = setIds;
		this.name = name;
		this.definition = definition;
		this.notes = notes;
	}

	public Flashcard(String name, String definition, String notes) {
		super();
		this.name = name;
		this.definition = definition;
		this.notes = notes;
	}

	public Flashcard(ArrayList<UUID> setIds, String name) {
		super();
		this.setIds = setIds;
		this.name = name;
	}

	public Flashcard(ArrayList<UUID> setIds, String name, String definition) {
		super();
		this.setIds = setIds;
		this.name = name;
		this.definition = definition;
	}

	public Flashcard(String name, String definition) {
		super();
		this.name = name;
		this.definition = definition;
	}

	public UUID getId() {

		return id;
	}
//	public void setId(UUID id) {
//		this.id = id;
//	}
	public ArrayList<UUID> getSetIds() {

		return setIds;
	}
//	public void setFlashcardSetId(UUID flashcardSetId) {
//		this.flashcardSetId = flashcardSetId;
//	}
	public String getName() {

		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public String getDefinition() {

		return definition;
	}
//	public void setDefinition(String definition) {
//		this.definition = definition;
//	}
	public String getNotes() {

		return notes;
	}
//	public void setNotes(String notes) {
//		this.notes = notes;
//	}

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
	public int compareTo(Flashcard o) {

		return this.getName().compareTo(o.getName());
	}

	public static class FlashcardBuilder {

		private UUID id;
		private ArrayList<UUID> setIds;
		private String name;
		private String definition;
		private String notes;

		public FlashcardBuilder id(UUID id) {
			this.id = id;
			return this;
		}

		public FlashcardBuilder setIds(ArrayList<UUID> setIds) {
			this.setIds = setIds;
			return this;
		}

		public FlashcardBuilder name(String name) {
			this.name = name;
			return this;
		}

		public FlashcardBuilder definition(String definition) {
			this.definition = definition;
			return this;
		}

		public FlashcardBuilder notes(String notes) {
			this.notes = notes;
			return this;
		}

		public Flashcard build() {
			return new Flashcard(this);
		}
	}
}
