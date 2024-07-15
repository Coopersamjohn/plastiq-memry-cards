import { TestBed } from '@angular/core/testing';
import { provideMockActions } from '@ngrx/effects/testing';
import { Observable } from 'rxjs';

import { FlashcardSetEffects } from './flashcard-set.effects';

describe('FlashcardSetEffects', () => {
  let actions$: Observable<any>;
  let effects: FlashcardSetEffects;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        FlashcardSetEffects,
        provideMockActions(() => actions$)
      ]
    });

    effects = TestBed.inject(FlashcardSetEffects);
  });

  it('should be created', () => {
    expect(effects).toBeTruthy();
  });
});
