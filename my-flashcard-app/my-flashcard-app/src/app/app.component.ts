import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FlashCardService } from './services/flash-card-service/flash-card.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class AppComponent implements OnInit {
  constructor(
    private readonly flashCardService: FlashCardService,
  ) {}

  ngOnInit(): void {
  }

}
