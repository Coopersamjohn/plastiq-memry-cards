export class Flashcard {
  private name: string;
  private id?: number;
  private definition?: string;
  private notes?: string;
  constructor(
    name: string,
    id?: number,
    definition?: string,
    notes?: string
  ) {
    this.id = id;
    this.name = name;
    this.definition = definition;
    this.notes = notes;
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
  get getDefinition() {
    return this.definition;
  }
  set setDefinition(definition: string) {
    this.definition = definition;
  }
  get getNotes() {
    return this.notes;
  }
  set setNotes(notes: string) {
    this.notes = notes;
  }
}
