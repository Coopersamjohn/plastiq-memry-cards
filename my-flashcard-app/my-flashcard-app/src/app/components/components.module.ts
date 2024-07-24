import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormBuilder, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { IonicModule } from "@ionic/angular";
import { ReactiveComponentModule } from "@ngrx/component";
import { CreateFlashcardSetComponent } from "./create-flashcard-set/create-flashcard-set.component";
import { CreateFlashcardComponent } from "./create-flashcard/create-flashcard.component";
import { DefineFlashcardSetComponent } from "./define-flashcard-set/define-flashcard-set.component";
import { DefineFlashcardComponent } from "./define-flashcard/define-flashcard.component";
import { FlashcardComponent } from "./flashcard/flashcard.component";
import { ViewFlashcardSetsComponent } from "./view-flashcard-sets/view-flashcard-sets.component";
import { BrowserModule } from "@angular/platform-browser";

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ReactiveComponentModule,
    IonicModule
  ],
  declarations: [
    FlashcardComponent,
    ViewFlashcardSetsComponent,
    FlashcardComponent,
    CreateFlashcardComponent,
    CreateFlashcardSetComponent,
    DefineFlashcardComponent,
    DefineFlashcardSetComponent
  ],
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
    FormBuilder
  ]
})
export class ComponentsModule {}