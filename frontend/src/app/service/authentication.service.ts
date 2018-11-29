import { LocalStorageService } from './localStorage.service';
import { ApiService } from './api.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import { ReplaySubject } from 'rxjs/ReplaySubject';
import { Router } from '@angular/router';
import { User } from '../model';

@Injectable()
export class AuthenticationService {

  constructor(
    private router: Router,
    private apiService: ApiService,
    private localStorageService: LocalStorageService) { }

    login(username: string, password: string): Observable<boolean> {
      return new Observable<boolean>(observer => {
        this.apiService.post('auth/', { username: username, password: password }).subscribe(response => {
          this.setAuth(response);
          this.router.navigate(['pages/home']);
          observer.next(true);
        }, err => {
          if (err.status === 401 || err.status === undefined) {
            this.logout();
            observer.next(false);
          }
        });
      });
    }

  checkAuth() {
    return new Observable<boolean>(observer => {
      this.apiService.get('auth/secret/').subscribe(response => {
        observer.next(true);
      }, err => {
        this.logout();
        observer.next(false);
      });
    });
  }

  logout(): void {
    this.purgeAuth();
    this.router.navigate(['auth/login']);
  }


  setAuth(user: User) {
    this.localStorageService.setString('token', user.token.toString());
    this.localStorageService.setString('userId', user.userId.toString());
    this.localStorageService.setJson('userdata', user);
  }


  getAuth(): User {
    return this.localStorageService.getJson('userdata');
  }


  purgeAuth() {
    window.localStorage.removeItem('token');
    window.localStorage.removeItem('userId');
    window.localStorage.removeItem('userdata');
  }

}
