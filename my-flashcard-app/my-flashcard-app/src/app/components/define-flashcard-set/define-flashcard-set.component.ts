import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Store } from '@ngrx/store';
import { FlashcardSet } from 'src/app/models/flashcard-set/flashcard-set';
import { FlashCardService } from 'src/app/services/flash-card-service/flash-card.service';
import * as FlashcardActions from 'src/app/state/flashcard-set/flashcard-set.actions';

@Component({
  selector: 'app-define-flashcard-set',
  templateUrl: './define-flashcard-set.component.html',
  styleUrls: ['./define-flashcard-set.component.scss'],
})
export class DefineFlashcardSetComponent implements OnInit {

  @Input() flashcardSetForm: FormGroup;

  constructor(
    private store: Store,
    private flashcardService: FlashCardService,
  ) { }

  ngOnInit() {}

  saveFlashcardSet() {
    const flashcardSet: FlashcardSet = this.flashcardService.mapFlashcardSetFormGroupToFlashcardSet(this.flashcardSetForm);
    this.store.dispatch(FlashcardActions.saveFlashcardSet({flashcardSet}))
  }

}
