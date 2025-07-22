import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { FlashCardService } from 'src/app/services/flash-card-service/flash-card.service';
import * as FlashcardActions from 'src/app/state/flashcard-set/flashcard-set.actions';
import { selectNewFlashcard } from 'src/app/state/flashcard-set/flashcard-set.selectors';

@Component({
  selector: 'app-create-flashcard',
  templateUrl: './create-flashcard.component.html',
  styleUrls: ['./create-flashcard.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CreateFlashcardComponent implements OnInit {

  flashcard$: Observable<FormGroup>;

  constructor(
    private readonly flashcardService: FlashCardService,
    private readonly fb: FormBuilder,
    private readonly store: Store
  ) { 
    this.flashcard$ = this.store.select(selectNewFlashcard);
  }

  ngOnInit() {}

  addFlashcard(flashcard: FormGroup) {
    this.store.dispatch(FlashcardActions.updateNewFlashcards({
      newFlashcard: flashcard
    }))
  }

  saveCards() {
    // this.store.dispatch(FlashcardActions.updateNewFlashcardsFormArray({
    //   flashcardSetFormArray: this.flashcards
    // }))
  }

}
