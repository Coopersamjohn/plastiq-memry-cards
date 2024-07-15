import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { FlashCardService } from './services/flash-card-service/flash-card.service';
import { HttpClientModule, HttpClientXsrfModule, HttpXsrfTokenExtractor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { FlashcardSetModule } from './state/flashcard-set/flashcard-set.module';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomePageModule } from './home/home.module';
import { ComponentsModule } from './components/components.module';
import { ReactiveComponentModule } from '@ngrx/component';
import { CommonModule } from '@angular/common';
import { AuthInterceptor } from './interceptors/auth-intereptor';

@NgModule({
  declarations: [
    AppComponent, 
  ],
  entryComponents: [],
  imports: [
    BrowserModule,
    CommonModule,
    ReactiveFormsModule,
    ReactiveComponentModule,
    IonicModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    // HttpClientXsrfModule,
    StoreModule.forRoot({}),
    EffectsModule.forRoot(),
    FlashcardSetModule,
    HomePageModule,
    ComponentsModule
  ],
  providers: [
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
    // { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    FormBuilder,
    FlashCardService,
  ],
  bootstrap: [
    AppComponent,
  ],
})
export class AppModule {}
