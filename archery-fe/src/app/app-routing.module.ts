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

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'caffs', component: CaffsComponent,canActivate:[AuthUserGuard]},
  {path: 'my-caffs', component: MyCaffsComponent},
  {path: 'upload-caff', component: UploadCaffComponent},
  {path: 'bows', component: BowsComponent},
  {path: 'trainings', component: TrainingsComponent},
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
