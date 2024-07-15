import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import * as FlashcardSetActions from '../state/flashcard-set/flashcard-set.actions'

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class HomePage implements OnInit {

  constructor(
    private store: Store
  ) {
    this.store.dispatch(FlashcardSetActions.refreshFlashcardSets());
  }

  ngOnInit() {
  }

}
