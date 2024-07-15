import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

import { select, Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { FlashcardSet } from 'src/app/models/flashcard-set/flashcard-set';
import { selectFlashcardSets } from 'src/app/state/flashcard-set/flashcard-set.selectors';

@Component({
  selector: 'app-view-flashcard-sets',
  templateUrl: './view-flashcard-sets.component.html',
  styleUrls: ['./view-flashcard-sets.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ViewFlashcardSetsComponent implements OnInit {

  flashCardSets$: Observable<FlashcardSet[]>;

  constructor(
    private store: Store
  ) { }

  ngOnInit() {
    this.flashCardSets$ = this.store.pipe(select(selectFlashcardSets));
  }

  flashcardTrackBy(index, flashcard) {
    return flashcard.id;
  }

}
