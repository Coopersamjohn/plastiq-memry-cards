package com.flashcardservice.repository;

import com.flashcardservice.model.Flashcard;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FlashcardDao extends ListCrudRepository<Flashcard, UUID> {

    Optional<Flashcard> findByName(String name);
    List<Flashcard> findBySetIds(UUID id);
    Void deleteByName(String name);

}

