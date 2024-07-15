import * as fromFlashcardSet from './flashcard-set.reducer';
import { selectFlashcardSetState } from './flashcard-set.selectors';

describe('FlashcardSet Selectors', () => {
  it('should select the feature state', () => {
    const result = selectFlashcardSetState({
      [fromFlashcardSet.flashcardSetFeatureKey]: {}
    });

    expect(result).toEqual({});
  });
});
