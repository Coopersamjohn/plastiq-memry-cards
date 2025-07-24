import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ViewFlashcardSetsComponent } from './view-flashcard-sets.component';

describe('ViewFlashcardSetsComponent', () => {
  let component: ViewFlashcardSetsComponent;
  let fixture: ComponentFixture<ViewFlashcardSetsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
    imports: [IonicModule.forRoot(), ViewFlashcardSetsComponent]
}).compileComponents();

    fixture = TestBed.createComponent(ViewFlashcardSetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
