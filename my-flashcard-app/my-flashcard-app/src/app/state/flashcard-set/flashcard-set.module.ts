import { NgModule } from '@angular/core';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { FlashcardSetEffects } from './flashcard-set.effects';
import { flashcardSetFeatureKey, flashcardSetReducer } from './flashcard-set.reducer';



@NgModule({
  declarations: [],
  imports: [
    StoreModule.forFeature(flashcardSetFeatureKey, flashcardSetReducer),
    EffectsModule.forFeature([FlashcardSetEffects]),
  ]
})
export class FlashcardSetModule { }
