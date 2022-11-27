import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {AuthUserGuard} from "./guards/auth-user.guard";
import {BowsComponent} from "./components/bows/bows.component";
import {TrainingsComponent} from "./components/trainings/trainings.component";
import {BowNewComponent} from "./components/bow-new/bow-new.component";
import {TrainingNewComponent} from "./components/training-new/training-new.component";
import {TrainingDetailsComponent} from "./components/training-details/training-details.component";
import {BowDetailsComponent} from "./components/bow-details/bow-details.component";
import {BowEditComponent} from "./components/bow-edit/bow-edit.component";
import {TrainingEditComponent} from "./components/training-edit/training-edit.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profile', component: ProfileComponent},

  {path: 'bows', component: BowsComponent},
  {path: 'bow-new', component: BowNewComponent},
  {path: 'bow-details/:id', component: BowDetailsComponent},
  {path: 'bow-edit/:id', component: BowEditComponent},

  {path: 'trainings', component: TrainingsComponent},
  {path: 'training-new', component: TrainingNewComponent},
  {path: 'training-edit', component: TrainingEditComponent},
  {path: 'training-details', component: TrainingDetailsComponent},

  {path: '', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
