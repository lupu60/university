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
  navbarItems: Array<any> = [];
  sidebarItems: Array<any> = [];

  constructor(private authenticationService: AuthenticationService) { }
  ngOnInit(): void {
    this.user = this.authenticationService.getAuth();
    this.navbarItems = [
      {
        'title': 'Dashboard',
        'icon': 'fa-tachometer',
        'routerLink': ''
      }
    ];
    this.sidebarItems = [{
      'title': 'Twitter Real Time',
      'icon': 'fa-twitter',
      'routerLink': ''
    },
    {
      'title': 'Sentiment Analysis',
      'icon': 'fa-heart',
      'routerLink': '/pages/sentiment'
    },
    {
      'title': 'Instagram Search',
      'icon': 'fa-instagram',
      'routerLink': '/pages/instagram'
    },
    {
      'title': 'Profile',
      'icon': 'fa-user-circle-o',
      'routerLink': '/pages/profile'
    }
    ];
  }

  logout() {
    this.authenticationService.logout();
  }
}
