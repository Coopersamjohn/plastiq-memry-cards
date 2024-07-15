import * as fromFlashcardSet from './flashcard-set.actions';

describe('fcsFlashcardSets', () => {
  it('should return an action', () => {
    expect(fromFlashcardSet.fcsFlashcardSets().type).toBe('[FlashcardSet] Fcs FlashcardSets');
  });
});
