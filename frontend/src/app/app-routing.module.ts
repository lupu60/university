
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {
  HomeComponent,
  LoginComponent,
  MasterComponent,
  ProfileComponent,
  UploadComponent,
  FilesComponent
} from './components';
import { AuthGuard } from './service';
import { RegisterComponent } from 'app/components/pages/register/register.component';

const routes: Routes = [
  { path: '', redirectTo: 'pages/home', pathMatch: 'full' },
  {
    path: 'pages', component: MasterComponent, canActivate: [AuthGuard], children: [
      { path: 'home', component: HomeComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'upload', component: UploadComponent },
      { path: 'files', component: FilesComponent },
    ]
  },
  { path: 'register', component: RegisterComponent },
  {
    path: 'auth', component: LoginComponent,
    children: [
      { path: 'login', component: LoginComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
