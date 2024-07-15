import { ChangeDetectionStrategy, Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder } from '@angular/forms';

import { Store } from '@ngrx/store';
import { FlashCardService } from 'src/app/services/flash-card-service/flash-card.service';
import * as FlashcardActions from 'src/app/state/flashcard-set/flashcard-set.actions';

@Component({
  selector: 'app-create-flashcard',
  templateUrl: './create-flashcard.component.html',
  styleUrls: ['./create-flashcard.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CreateFlashcardComponent implements OnInit {

  flashcards: FormArray;

  constructor(
    private flashcardService: FlashCardService,
    private fb: FormBuilder,
    private store: Store
  ) { 
    this.flashcards = this.fb.array([]);
  }

  ngOnInit() {}

  // addFlashcard() {
  //   this.flashcards.push(
  //     this.flashcardService.createFlashcardFormGroup()
  //   );
  // }

  saveCards() {
    this.store.dispatch(FlashcardActions.updateNewFlashcardsFormArray({
      flashcardSetFormArray: this.flashcards
    }))
  }

}
