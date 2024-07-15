import { Flashcard } from './flashcard';

describe('Flashcard', () => {
  it('should create an instance', () => {
    expect(new Flashcard(
      1,
      'CardName',
      'Definition',
      'Notes'
    )).toBeTruthy();
  });
});
