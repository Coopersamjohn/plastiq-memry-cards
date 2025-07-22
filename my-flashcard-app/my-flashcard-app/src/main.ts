import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { environment } from './environments/environment';
import { ApplicationConfig, bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { RouteReuseStrategy, provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { provideIonicAngular, IonicRouteStrategy } from '@ionic/angular/standalone';
import { routes } from './app/app-routing'; 
import { provideState, provideStore } from '@ngrx/store';
import { flashcardSetReducer } from './app/state/flashcard-set/flashcard-set.reducer';
import { provideEffects } from '@ngrx/effects';
import { FlashcardSetEffects } from './app/state/flashcard-set/flashcard-set.effects';

if (environment.production) {
  enableProdMode();
}

export const appConfig: ApplicationConfig = {
  providers: [
    provideHttpClient(),
    provideIonicAngular(),
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
    provideRouter(routes),
    // provideState(flashcardSetReducer),
    provideStore(),
    // provideEffects(FlashcardSetEffects),
    // provideStoreDevtools(),
  ]
}

// platformBrowserDynamic().bootstrapModule(AppModule)
//   .catch(err => console.log(err));
bootstrapApplication(AppComponent, appConfig)
  .catch(err => console.log(err));
