import { ChangeDetectionStrategy, Component, OnInit, Output } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';

import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { FlashCardService } from 'src/app/services/flash-card-service/flash-card.service';
import * as FlashcardActions from 'src/app/state/flashcard-set/flashcard-set.actions';
import { selectNewFlashcardSet } from 'src/app/state/flashcard-set/flashcard-set.selectors';


@Component({
  selector: 'app-create-flashcard-set',
  templateUrl: './create-flashcard-set.component.html',
  styleUrls: ['./create-flashcard-set.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CreateFlashcardSetComponent implements OnInit {

  flashcardSetForm$: Observable<FormGroup>;
  // @Output() createNewSet: EventEmitter;

  // get cards() {
  //   return this.flashcardSetForm$.get('cards') as FormArray;
  // }

  constructor(
    private flashcardService: FlashCardService,
    private fb: FormBuilder,
    private store: Store
  ) {
    this.flashcardSetForm$ = this.store.pipe(select(selectNewFlashcardSet));
    
   }

  ngOnInit() {}

  createNewFlashcardSetFormGroup(): void {
    this.store.dispatch(FlashcardActions.createNewFlashcardSetFormGroup({
      flashcardSetFormGroup: this.flashcardService.createNewFlashcardSetFormGroup()
    }));
  }

  // newCard() {
  //   this.cards.push(
  //     this.flashcardService.createFlashcardFormGroup()
  //   );
  // }

}
