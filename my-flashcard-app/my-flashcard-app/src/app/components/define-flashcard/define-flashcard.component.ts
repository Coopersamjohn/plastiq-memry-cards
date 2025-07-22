import { ChangeDetectionStrategy, Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { Store } from '@ngrx/store';
import { FlashCardService } from 'src/app/services/flash-card-service/flash-card.service';
import * as FlashcardActions from '../../state/flashcard-set/flashcard-set.actions';

@Component({
  selector: 'app-define-flashcard',
  templateUrl: './define-flashcard.component.html',
  styleUrls: ['./define-flashcard.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class DefineFlashcardComponent implements OnInit {

  @Input() flashcard: FormGroup;

  constructor(
    private readonly flashcardService: FlashCardService,
    private readonly store: Store
  ) { }

  ngOnInit() {}

  saveCard() {
    // const flashcard = this.flashcardService.mapFlashcardFormGroupToFlashCard(this.flashcard);
    this.store.dispatch(FlashcardActions.updateNewFlashcards({ newFlashcard: this.flashcard }));
  }
}
