package com.flashcardsetservice.repository;

import com.flashcardsetservice.model.FlashcardSet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface FlashcardSetDao extends ListCrudRepository<FlashcardSet, UUID> {

//	void delete(FlashcardSet flashcardSet);
//	Void deleteAll(Set<FlashcardSet> theseSets);
//	Void deleteAllById(Set<UUID> ids);
//	void deleteById(UUID id);
//	Void deleteByName(String name);
//	boolean existsById(UUID id);
//	Iterable<FlashcardSet> findAll();
//	FlashcardSet findAllByIds(UUID ids);
//	FlashcardSet findById(String id);
//	Optional<FlashcardSet> findById(UUID id);
	Optional<FlashcardSet> findByName(String name);
//	FlashcardSet save(FlashcardSet flashcardSet);
//	FlashcardSet saveAll(List<FlashcardSet> flashcardSets);

}

