import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { UntypedFormBuilder, ReactiveFormsModule } from "@angular/forms";
import { IonicModule } from "@ionic/angular";
import { LetModule, PushModule } from "@ngrx/component";
import { CreateFlashcardSetComponent } from "./create-flashcard-set/create-flashcard-set.component";
import { CreateFlashcardComponent } from "./create-flashcard/create-flashcard.component";
import { DefineFlashcardSetComponent } from "./define-flashcard-set/define-flashcard-set.component";
import { DefineFlashcardComponent } from "./define-flashcard/define-flashcard.component";
import { FlashcardComponent } from "./flashcard/flashcard.component";
import { ViewFlashcardSetsComponent } from "./view-flashcard-sets/view-flashcard-sets.component";

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    LetModule, PushModule,
    IonicModule,
    FlashcardComponent,
    ViewFlashcardSetsComponent,
    FlashcardComponent,
    CreateFlashcardComponent,
    CreateFlashcardSetComponent,
    DefineFlashcardComponent,
    DefineFlashcardSetComponent,
  ],
  declarations: [],
  exports: [
    FlashcardComponent,
    ViewFlashcardSetsComponent,
    FlashcardComponent,
    CreateFlashcardComponent,
    CreateFlashcardSetComponent,
    DefineFlashcardComponent,
    DefineFlashcardSetComponent
  ],
  providers: [
    UntypedFormBuilder
  ]
})
export class ComponentsModule {}