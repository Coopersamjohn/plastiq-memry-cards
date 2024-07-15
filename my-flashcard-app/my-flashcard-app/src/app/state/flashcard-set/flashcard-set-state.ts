import { FormArray, FormGroup } from "@angular/forms";
import { FlashcardSet } from "src/app/models/flashcard-set/flashcard-set";
import { Flashcard } from "src/app/models/flashcard/flashcard";

export interface FlashcardSetState {
  flashcardSets: FlashcardSet[],
  currentFlashcardSet: FlashcardSet,
  newFlashcardSet: FormGroup,
  newFlashcards: FormArray,
  newFlashcard: FormGroup,
  isLoading: boolean,
  errors: Error[]
}