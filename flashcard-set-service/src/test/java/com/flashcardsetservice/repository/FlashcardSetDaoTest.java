//package com.flashcardsetservice.repository;
//
//import com.flashcardsetservice.model.Flashcard;
//import com.flashcardsetservice.model.FlashcardSet;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.Spy;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.*;
//
//
//@SpringBootTest
//public class FlashcardSetDaoTest {
//
//	@Spy
//	FlashcardSetDao flashcardSetDao;
//
//	@Mock
//	List<FlashcardSet> listOfFlashcardSets;
//
//	@BeforeEach
//	void init(@Mock FlashcardSetDao flashcardSetDao  ) {
//		HashSet<Flashcard> flashcardList = new HashSet<Flashcard>();
//		Flashcard flashcard1 = new Flashcard(UUID.randomUUID(), "CardName", "Card definition", "Card notes");
//		flashcardList.add(flashcard1);
//		this.listOfFlashcardSets.add(new FlashcardSet(UUID.randomUUID(), "SetName", "SetName",
//				flashcardList
//		));
//		Mockito.lenient().when(flashcardSetDao.findAll()).thenReturn(this.listOfFlashcardSets);
//	}
//
//	@Test
//	void givenInit_whenFindAllFlashcardSets_theReceiveAllFlashcardSets() {
//		this.flashcardSetDao.findAll();
//		Mockito.verify(this.flashcardSetDao).findAll();
//
//	}
//
//}
