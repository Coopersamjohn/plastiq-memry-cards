import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, concatMap, mergeMap, switchMap } from 'rxjs/operators';
import { of } from 'rxjs';

import * as FlashcardSetActions from './flashcard-set.actions';
import { FlashCardService } from 'src/app/services/flash-card-service/flash-card.service';
import { FlashcardSet } from 'src/app/models/flashcard-set/flashcard-set';
import { select, Store } from '@ngrx/store';
import { selectNewFlashcardSet } from './flashcard-set.selectors';



@Injectable()
export class FlashcardSetEffects {

  refreshFlashcardSets$ = createEffect(() => {
    return this.actions$.pipe( 

      ofType(FlashcardSetActions.refreshFlashcardSets),
      concatMap(() => {
        return this.flashcardService.getAllFlashCardSets().pipe(
          mergeMap((flashcardSets: FlashcardSet[]) => of(FlashcardSetActions.refreshFlashcardSetsSuccess({ flashcardSets }))),
          catchError((error) => of(FlashcardSetActions.refreshFlashcardSetsFailure({ error: new Error(error) }))))
      })
    );
  });

  updateNewFlashcards$ = createEffect(() => {
    return this.actions$.pipe(
      ofType(FlashcardSetActions.updateNewFlashcards),
      concatMap(({newFlashcard}) => {
        return of(FlashcardSetActions.addNewFlashcardToNewFlashcardSet({
          newFlashcard: newFlashcard
        }))
      })
    );
  });

  saveFlashcardSet$ = createEffect(() => {
    return this.actions$.pipe( 

      ofType(FlashcardSetActions.saveFlashcardSet),
      // switchMap((action) => this.store.pipe(select(selectNewFlashcardSet)) ),
      concatMap(({flashcardSet}) => {
        // const newFlashcardSet = new FlashcardSet(
        //   null,
        //   flashcardSet.get('name').value,
        //   flashcardSet.get('cards').value
        // );
        return this.flashcardService.saveFlashCardSet(flashcardSet).pipe(
          mergeMap((flashcardSet: FlashcardSet) => of(FlashcardSetActions.saveFlashcardSetSuccess({ flashcardSet }))),
          catchError((error) => of(FlashcardSetActions.saveFlashcardSetFailure({ error: new Error(error) }))))
      })
    );
  });

  constructor(
    private actions$: Actions,
    private flashcardService: FlashCardService,
    private store: Store
  ) {}

}
