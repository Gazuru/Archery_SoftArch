import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {ProfileComponent} from './components/profile/profile.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {authInterceptorProviders} from "./helpers/auth.interceptor";
import {BowsComponent} from './components/bows/bows.component';
import {BowEditComponent} from './components/bow-edit/bow-edit.component';
import {BowNewComponent} from './components/bow-new/bow-new.component';
import {BowDetailsComponent} from './components/bow-details/bow-details.component';
import {ProfilesComponent} from './components/profiles/profiles.component';
import {TrainingsComponent} from './components/trainings/trainings.component';
import {TrainingDetailsComponent} from './components/training-details/training-details.component';
import {TrainingEditComponent} from './components/training-edit/training-edit.component';
import {BowRowComponent} from './components/bow-row/bow-row.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {TrainingRowComponent} from './components/training-row/training-row.component';
import {TrainingNewComponent} from './components/training-new/training-new.component';
import {RoundRowComponent} from './components/round-row/round-row.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    BowsComponent,
    BowEditComponent,
    BowNewComponent,
    BowDetailsComponent,
    ProfilesComponent,
    TrainingsComponent,
    TrainingDetailsComponent,
    TrainingEditComponent,
    BowRowComponent,
    TrainingRowComponent,
    TrainingNewComponent,
    RoundRowComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FontAwesomeModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
