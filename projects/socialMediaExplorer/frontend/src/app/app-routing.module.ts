
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {
  HomeComponent,
  LoginComponent,
  ProfileComponent,
  RegisterComponent,
  MasterComponent,
  SentimentAnalysisComponent
} from './components';
import { AppComponent } from 'app/app.component';
import { AuthGuard } from './service';
import { InstagramComponent } from 'app/components/pages/instagram/instagram.component';


const routes: Routes = [
  { path: '', redirectTo: 'pages/home', pathMatch: 'full' },
  {
    path: 'pages', component: MasterComponent, canActivate: [AuthGuard], children: [
      { path: 'home', component: HomeComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'instagram', component: InstagramComponent },
      { path: 'sentiment', component: SentimentAnalysisComponent },

    ]
  },
  { path: 'register', component: RegisterComponent },
  {
    path: 'auth', component: LoginComponent, children: [
      { path: 'login', component: LoginComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
