import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { DefineFlashcardSetComponent } from './define-flashcard-set.component';

describe('DefineFlashcardSetComponent', () => {
  let component: DefineFlashcardSetComponent;
  let fixture: ComponentFixture<DefineFlashcardSetComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
    declarations: [DefineFlashcardSetComponent],
    imports: [IonicModule.forRoot()]
}).compileComponents();

    fixture = TestBed.createComponent(DefineFlashcardSetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
