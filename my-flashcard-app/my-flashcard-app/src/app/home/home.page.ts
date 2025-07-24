import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';

import { Store } from '@ngrx/store';
import * as FlashcardSetActions from '../state/flashcard-set/flashcard-set.actions'
import {  } from '@ionic/angular';
import { 
  IonContent,
  IonHeader,
  IonTitle,
  IonToolbar 
} from '@ionic/angular/standalone';
import { ViewFlashcardSetsComponent } from '../components/view-flashcard-sets/view-flashcard-sets.component';
import { CreateFlashcardSetComponent } from '../components/create-flashcard-set/create-flashcard-set.component';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss'],
    changeDetection: ChangeDetectionStrategy.OnPush,
    imports: [
        IonHeader,
        IonToolbar,
        IonTitle,
        IonContent,
        ViewFlashcardSetsComponent,
        CreateFlashcardSetComponent
    ]
})
export class HomePage {

  constructor(
    private readonly store: Store
  ) {
    this.store.dispatch(FlashcardSetActions.refreshFlashcardSets());
  }
}
