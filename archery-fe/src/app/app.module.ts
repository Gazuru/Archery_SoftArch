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
import {CaffsComponent} from './components/caffs/caffs.component';
import {MyCaffsComponent} from './components/my-caffs/my-caffs.component';
import {UploadCaffComponent} from './components/upload-caff/upload-caff.component';
import {DetailsCaffComponent} from './components/details-caff/details-caff.component';
import {DetailsProfileComponent} from './components/details-profile/details-profile.component';
import {EditProfileComponent} from './components/edit-profile/edit-profile.component';
import {CaffCardComponent} from './components/caff-card/caff-card.component';
import { CommentComponent } from './components/comment/comment.component';
import { CaffCardMinimalComponent } from './components/caff-card-minimal/caff-card-minimal.component';
import { DownloadedCaffCardComponent } from './components/downloaded-caff-card/downloaded-caff-card.component';
import { BowsComponent } from './components/bows/bows.component';
import { BowEditComponent } from './components/bow-edit/bow-edit.component';
import { BowNewComponent } from './components/bow-new/bow-new.component';
import { BowDetailsComponent } from './components/bow-details/bow-details.component';
import { ProfilesComponent } from './components/profiles/profiles.component';
import { ProfileEditComponent } from './components/profile-edit/profile-edit.component';
import { TrainingsComponent } from './components/trainings/trainings.component';
import { TrainingAddComponent } from './components/training-add/training-add.component';
import { TrainingDetailsComponent } from './components/training-details/training-details.component';
import { RoundsComponent } from './components/rounds/rounds.component';
import { RoundAddComponent } from './components/round-add/round-add.component';
import { RoundDetailsComponent } from './components/round-details/round-details.component';
import { RoundEditComponent } from './components/round-edit/round-edit.component';
import { TrainingEditComponent } from './components/training-edit/training-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    CaffsComponent,
    MyCaffsComponent,
    UploadCaffComponent,
    DetailsCaffComponent,
    DetailsProfileComponent,
    EditProfileComponent,
    CaffCardComponent,
    CommentComponent,
    CaffCardMinimalComponent,
    DownloadedCaffCardComponent,
    BowsComponent,
    BowEditComponent,
    BowNewComponent,
    BowDetailsComponent,
    ProfilesComponent,
    ProfileEditComponent,
    TrainingsComponent,
    TrainingAddComponent,
    TrainingDetailsComponent,
    RoundsComponent,
    RoundAddComponent,
    RoundDetailsComponent,
    RoundEditComponent,
    TrainingEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {
}
