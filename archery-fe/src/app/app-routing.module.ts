import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {CaffsComponent} from "./components/caffs/caffs.component";
import {MyCaffsComponent} from "./components/my-caffs/my-caffs.component";
import {UploadCaffComponent} from "./components/upload-caff/upload-caff.component";
import {DetailsCaffComponent} from "./components/details-caff/details-caff.component";
import {DetailsProfileComponent} from "./components/details-profile/details-profile.component";
import {AuthUserGuard} from "./guards/auth-user.guard";
import {BowsComponent} from "./components/bows/bows.component";
import {TrainingsComponent} from "./components/trainings/trainings.component";
import {BowNewComponent} from "./components/bow-new/bow-new.component";
import {TrainingNewComponent} from "./components/training-new/training-new.component";
import {TrainingDetailsComponent} from "./components/training-details/training-details.component";
import {BowDetailsComponent} from "./components/bow-details/bow-details.component";
import {BowEditComponent} from "./components/bow-edit/bow-edit.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'caffs', component: CaffsComponent,canActivate:[AuthUserGuard]},
  {path: 'my-caffs', component: MyCaffsComponent},
  {path: 'upload-caff', component: UploadCaffComponent},

  {path: 'bows', component: BowsComponent},
  {path: 'bow-new', component: BowNewComponent},
  {path: 'bow-details', component: BowDetailsComponent},
  {path: 'bow-edit', component: BowEditComponent},

  {path: 'trainings', component: TrainingsComponent},
  {path: 'training-new', component: TrainingNewComponent},
  {path: 'training-details', component: TrainingDetailsComponent},

  { path: 'details-caff/:id', component: DetailsCaffComponent },
  { path: 'details-profile/:id', component: DetailsProfileComponent },
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
