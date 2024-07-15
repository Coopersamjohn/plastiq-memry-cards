import { ChangeDetectionStrategy, Component, Input, OnInit } from '@angular/core';
import { Flashcard } from 'src/app/models/flashcard/flashcard';
import { FlashCardService } from 'src/app/services/flash-card-service/flash-card.service';

@Component({
  selector: 'app-flashcard',
  templateUrl: './flashcard.component.html',
  styleUrls: ['./flashcard.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class FlashcardComponent implements OnInit {

  isFront: boolean = true;
  @Input() flashCard: Flashcard;

  constructor(private flashCardService: FlashCardService) { }

  ngOnInit() {}

  flipCard() {
    this.isFront = !this.isFront;
  }

}
