import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FlashCardService } from './services/flash-card-service/flash-card.service';
import { IonApp, IonRouterOutlet } from '@ionic/angular/standalone';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  standalone: true,
  imports: [
    IonRouterOutlet,
    IonApp
],
})
export class AppComponent {
  constructor(
    private readonly flashCardService: FlashCardService,
  ) {}
}
