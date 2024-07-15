import { FormArray, FormGroup } from '@angular/forms';
import { createAction, props } from '@ngrx/store';
import { FlashcardSet } from 'src/app/models/flashcard-set/flashcard-set';
import { Flashcard } from 'src/app/models/flashcard/flashcard';

export const refreshFlashcardSets = createAction(
  '[FlashcardSet] Refresh FlashcardSets'
);

export const refreshFlashcardSetsSuccess = createAction(
  '[FlashcardSet] Refresh FlashcardSets Success',
  props<{ flashcardSets: FlashcardSet[] }>()
);

export const refreshFlashcardSetsFailure = createAction(
  '[FlashcardSet] Refresh FlashcardSets Failure',
  props<{ error: Error }>()
);

export const addFlashcardSet = createAction(
  '[FlashcardSet] Add FlashcardSet',
  props<{ flashcardSet: FlashcardSet }>()
);

export const chooseFlashcardSet = createAction(
  '[FlashcardSet] Choose FlashcardSet',
  props<{ flashcardSet: FlashcardSet }>()
);

export const clearChosenFlashcardSet = createAction(
  '[FlashcardSet] Clear Chosen FlashcardSet'
);

export const saveFlashcardSet = createAction(
  '[FlashcardSet] Save FlashcardSet toDB',
  props<{ flashcardSet: FlashcardSet }>()
);

export const saveFlashcardSetSuccess = createAction(
  '[FlashcardSet] Save FlashcardSet toDB Success',
  props<{ flashcardSet: FlashcardSet }>()
);

export const saveFlashcardSetFailure = createAction(
  '[FlashcardSet] Save FlashcardSet toDB Failure',
  props<{ error: Error }>()
);

export const addFlashcardToChosenFlashcardSet = createAction(
  '[FlashcardSet] Add Flashcard to ChosenFlashcardSet',
  props<{ flashcard: Flashcard }>()
);

export const addFlashcardToFlashcardSet = createAction(
  '[FlashcardSet] Add Flashcard to FlashcardSet',
  props<{ 
    flashcard: Flashcard,
    flashcardSetName: string
   }>()
);

export const removeFlashcardFromChosenFlashcardSet = createAction(
  '[FlashcardSet] Remove Flashcard from ChosenFlashcardSet',
  props<{ flashcard: Flashcard }>()
);

export const removeFlashcardToFlashcardSet = createAction(
  '[FlashcardSet] Remove Flashcard to FlashcardSet',
  props<{ 
    flashcardName: string,
    flashcardSetName: string
   }>()
);

export const createNewFlashcardSetFormGroup = createAction(
  '[FlashcardSet] Create New FlashcardSet FormGroup',
  props<{ flashcardSetFormGroup: FormGroup }>()
);

export const updateNewFlashcardSetFormGroup = createAction(
  '[FlashcardSet] Update New FlashcardSet FormGroup',
  props<{ flashcardSetFormGroup: FormGroup }>()
);

export const clearNewFlashcardSetFormGroup = createAction(
  '[FlashcardSet] Clear New FlashcardSet FormGroup'
);

export const createNewFlashcardsFormArray = createAction(
  '[FlashcardSet] Create New FlashcardSet FormArray',
  props<{ flashcardSetFormArray: FormArray }>()
);

export const updateNewFlashcardsFormArray = createAction(
  '[FlashcardSet] Update New FlashcardSet FormArray',
  props<{ flashcardSetFormArray: FormArray }>()
);

export const clearNewFlashcardsFormArray = createAction(
  '[FlashcardSet] Clear New FlashcardSet FormArray'
);

export const createNewFlashcardFormGroup = createAction(
  '[FlashcardSet] Create New Flashcard FormGroup',
  props<{ flashcardSetFormGroup: FormGroup }>()
);

export const updateNewFlashcardFormGroup = createAction(
  '[FlashcardSet] Update New Flashcard FormGroup',
  props<{ flashcardSetFormGroup: FormGroup }>()
);

export const clearNewFlashcardFormGroup = createAction(
  '[FlashcardSet] Clear New Flashcard FormGroup'
);
