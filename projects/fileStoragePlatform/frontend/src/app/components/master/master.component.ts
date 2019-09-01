import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'app/service';
import { User } from 'app/model';

@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.less']
})

export class MasterComponent implements OnInit {
  user: User;

  constructor(private authenticationService: AuthenticationService) { }
  ngOnInit(): void {
    this.user = this.authenticationService.getAuth();
  }

  logout() {
    this.authenticationService.logout();
  }
}
