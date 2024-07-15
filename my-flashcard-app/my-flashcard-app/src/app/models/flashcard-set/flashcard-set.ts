import { Flashcard } from "../flashcard/flashcard";

export class FlashcardSet {
  private id: number;
  private name: string;
  private cards: Flashcard[];
  constructor(
    id: number,
    name: string,
    cards: Flashcard[]
  ) {
    this.id = id;
    this.name = name;
    this.cards = cards;
  }
  get getId() {
    return this.id;
  }
  set setId(id: number) {
    this.id = id;
  }
  get getName() {
    return this.name;
  }
  set setName(name: string) {
    this.name = name;
  }
  get getCards() {
    return this.cards;
  }
  set setCards(cards: Flashcard[]) {
    this.cards = cards;
  }
}
