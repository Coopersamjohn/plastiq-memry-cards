import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { FlashcardSet } from 'src/app/models/flashcard-set/flashcard-set';
import { FlashCardService } from 'src/app/services/flash-card-service/flash-card.service';
import * as FlashcardActions from 'src/app/state/flashcard-set/flashcard-set.actions';
import { selectFlashcardSetState, selectNewFlashcard } from 'src/app/state/flashcard-set/flashcard-set.selectors';

@Component({
    selector: 'app-define-flashcard-set',
    templateUrl: './define-flashcard-set.component.html',
    styleUrls: ['./define-flashcard-set.component.scss']
})
export class DefineFlashcardSetComponent implements OnInit {

  flashcardSetForm$: Observable<FormGroup>;

  constructor(
    private readonly store: Store,
    private readonly flashcardService: FlashCardService,
  ) { 
    this.flashcardSetForm$ = this.store.select(selectNewFlashcard);
  }

  ngOnInit() {}

  saveFlashcardSet(flashcardSet: FormGroup) {
    // const flashcardSet: FlashcardSet = this.flashcardService.mapFlashcardSetFormGroupToFlashcardSet(this.flashcardSetForm);
    this.store.dispatch(FlashcardActions.updateNewFlashcardSetFormGroup({ flashcardSetFormGroup: flashcardSet }))
  }

}
