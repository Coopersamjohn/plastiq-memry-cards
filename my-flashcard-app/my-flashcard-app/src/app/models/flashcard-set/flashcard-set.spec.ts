import { Flashcard } from '../flashcard/flashcard';
import { FlashcardSet } from './flashcard-set';

describe('FlashCardSet', () => {
  it('should create an instance', () => {
    expect(new FlashcardSet(
      1,
      'Category',
      [
        new Flashcard(
          1,
          'CardName',
          'Definition',
          'Notes'
        )
      ]
    )).toBeTruthy();
  });
});
