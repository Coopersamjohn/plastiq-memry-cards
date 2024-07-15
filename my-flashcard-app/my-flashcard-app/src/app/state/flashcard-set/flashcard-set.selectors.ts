import { createFeatureSelector, createSelector } from '@ngrx/store';
import { FlashcardSetState } from './flashcard-set-state';
import { flashcardSetFeatureKey } from './flashcard-set.reducer';

export const selectFlashcardSetState = createFeatureSelector<FlashcardSetState>(
  flashcardSetFeatureKey
);

export const selectFlashcardSets = createSelector(
  selectFlashcardSetState,
  (state) => state.flashcardSets
);

export const selectCurrentFlashcardSet = createSelector(
  selectFlashcardSetState,
  (state) => state.currentFlashcardSet
);

export const selectNewFlashcardSet = createSelector(
  selectFlashcardSetState,
  (state) => state.newFlashcardSet
);

export const selectNewFlashcards = createSelector(
  selectFlashcardSetState,
  (state) => state.newFlashcards
);

export const selectNewFlashcard = createSelector(
  selectFlashcardSetState,
  (state) => state.newFlashcard
);

export const selectIsLoading = createSelector(
  selectFlashcardSetState,
  (state) => state.isLoading
);

export const selectErrors = createSelector(
  selectFlashcardSetState,
  (state) => state.errors
);

export const selectLatestError = createSelector(
  selectErrors,
  (errors) => errors[(errors.length - 1)]
);
