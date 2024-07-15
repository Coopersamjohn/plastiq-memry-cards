import { FormGroup, FormArray } from '@angular/forms';
import { Action, createReducer, on } from '@ngrx/store';
import { FlashcardSet } from 'src/app/models/flashcard-set/flashcard-set';
import { FlashcardSetState } from './flashcard-set-state';
import * as FlashcardSetActions from './flashcard-set.actions';

export const flashcardSetFeatureKey = 'flashcardSets';

export const initialState: FlashcardSetState = {
  flashcardSets: [],
  currentFlashcardSet: null,
  isLoading: false,
  errors: [],
  newFlashcardSet: null,
  newFlashcards: null,
  newFlashcard: null
};

export const flashcardSetReducer = createReducer(
  initialState,

  on(FlashcardSetActions.refreshFlashcardSets, state => ({
    ...state,
    isLoading: true
  })),
  on(FlashcardSetActions.refreshFlashcardSetsSuccess, (state, action) => ({
    ...state,
    flashcardSets: action.flashcardSets,
    isLoading: false
  })),
  on(FlashcardSetActions.refreshFlashcardSetsFailure, (state, action) => ({
    ...state,
    isLoading: false,
    errors: [
      ...state.errors,
      action.error
    ]
  })),

  on(FlashcardSetActions.addFlashcardSet, (state, action) => ({
    ...state,
    flashcardSets: [
      ...state.flashcardSets,
      action.flashcardSet
    ],
    isLoading: true
  })),

  on(FlashcardSetActions.saveFlashcardSet, (state) => ({
    ...state,
    isLoading: true
  })),
  on(FlashcardSetActions.saveFlashcardSetSuccess, (state, action) => ({
    ...state,
    flashcardSets: [
      ...state.flashcardSets,
      action.flashcardSet
    ],
    isLoading: false
  })),
  on(FlashcardSetActions.saveFlashcardSetFailure, (state, action) => ({
    ...state,
    errors: [
      ...state.errors,
      action.error
    ],
    isLoading: false
  })),

  on(FlashcardSetActions.chooseFlashcardSet, (state, action) => ({
    ...state,
    currentFlashcardSet: action.flashcardSet
  })),
  on(FlashcardSetActions.clearChosenFlashcardSet, (state) => ({
    ...state,
    currentFlashcardSet: null
  })),

  on(FlashcardSetActions.createNewFlashcardSetFormGroup, (state, action) => ({
    ...state,
    newFlashcardSet: action.flashcardSetFormGroup
  })),
  on(FlashcardSetActions.updateNewFlashcardSetFormGroup, (state, action) => ({
    ...state,
    newFlashcardSet: action.flashcardSetFormGroup
  })),
  on(FlashcardSetActions.clearNewFlashcardSetFormGroup, (state) => ({
    ...state,
    newFlashcardSet: null
  })),


  on(FlashcardSetActions.createNewFlashcardsFormArray, (state, action) => ({
    ...state,
    newFlashcards: action.flashcardSetFormArray
  })),
  on(FlashcardSetActions.updateNewFlashcardsFormArray, (state, action) => ({
    ...state,
    newFlashcards: action.flashcardSetFormArray
  })),
  on(FlashcardSetActions.clearNewFlashcardsFormArray, (state) => ({
    ...state,
    newFlashcards: null
  })),


  on(FlashcardSetActions.createNewFlashcardFormGroup, (state, action) => ({
    ...state,
    newFlashcard: action.flashcardSetFormGroup
  })),
  on(FlashcardSetActions.updateNewFlashcardFormGroup, (state, action) => ({
    ...state,
    newFlashcard: action.flashcardSetFormGroup
  })),
  on(FlashcardSetActions.clearNewFlashcardFormGroup, (state) => ({
    ...state,
    newFlashcard: null
  })),

);
