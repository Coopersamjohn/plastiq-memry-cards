import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Flashcard } from 'src/app/models/flashcard/flashcard';
import { FlashcardSet } from 'src/app/models/flashcard-set/flashcard-set';
import { Observable, of } from 'rxjs';
import { flashcardServiceHostname, flashcardServicePort } from 'src/app/enums/app';
import { FormBuilder, FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FlashCardService {

  private readonly flashcardServiceUrl: string = `http://${flashcardServiceHostname}:${flashcardServicePort}`;
  private readonly getAllFlashcards: string = "/getAll";
  private readonly saveFlashcardSet: string = "/saveFlashcardSet";

  constructor(
    private readonly httpClient: HttpClient,
    private readonly fb: FormBuilder
  ) { }

  getAllFlashCardSets(): Observable<FlashcardSet[]> {
    return this.httpClient.get<FlashcardSet[]>(`${this.flashcardServiceUrl}${this.getAllFlashcards}`);
  }

  getFlashCardSetByName(flashCardSetName: string): Observable<FlashcardSet> {

    const flashcardServiceOptions = {
      params: { flashcardSetName: `${flashCardSetName}` }
    }

    return this.httpClient.get<FlashcardSet>(
      this.flashcardServiceUrl,
      flashcardServiceOptions
    );

  }

  saveFlashCardSet(flashCardSet: FlashcardSet): Observable<FlashcardSet> {
    return this.httpClient.post<FlashcardSet>(
      `${this.flashcardServiceUrl}${this.saveFlashcardSet}`,
      flashCardSet
    );
  }

  updateFlashCardSet(flashCardSet: FlashcardSet): Observable<FlashcardSet> {
    return this.httpClient.post<FlashcardSet>(
      this.flashcardServiceUrl,
      flashCardSet
    )
  }

  deleteFlashCardSet(flashCardSet: FlashcardSet) {}

  // getFlashCards(flashCardSet: FlashCardSet) {}

  addFlashcards(flashcards: Flashcard[]) {}

  createNewFlashcardSetFormGroup(): FormGroup {
    return this.fb.group({
      name: [''],
      cards: this.fb.array([])
    });;
  }

  createFlashcardFormGroup(): FormGroup {
    return this.fb.group({
      name: [''],
      definition: [''],
      notes: ['']
    });
  }

  mapFlashcardFormGroupToFlashCard(flashcardFG: FormGroup): Flashcard {
    const flashcard = new Flashcard(
      flashcardFG.get('name').value,
      null,
      flashcardFG.get('definition').value,
      flashcardFG.get('notes').value,
    );
    return flashcard;
  }

  mapFlashcardSetFormGroupToFlashcardSet(flashcardSetFG: FormGroup): FlashcardSet {
    const flashcardSet = new FlashcardSet(
      null,
      flashcardSetFG.get('name').value,
      flashcardSetFG.get('cards').value ? flashcardSetFG.get('cards').value : []
    );
    return flashcardSet;
  }

  updateFlashcardName(flashcard: Flashcard) {}

  updateFlashcardDefinition(flashcard: Flashcard) {}

  removeFlashcard(flashcard: Flashcard) {}


}
