import { Component, OnInit } from '@angular/core';
import { ApiService, AuthenticationService } from 'app/service';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { MessageService } from 'primeng/components/common/messageservice';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.less']
})
export class ProfileComponent implements OnInit {
  authForm: FormGroup;
  username: string;
  constructor(private apiService: ApiService,
    private fb: FormBuilder,
    private router: Router,
    private messageService: MessageService,
    private authService: AuthenticationService) { }

  ngOnInit() {
    this.authForm = this.fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required]
    });
    this.username = this.authService.getAuth().username;
  }

  change() {
    const credentials = this.authForm.value;

    // this.authService.login(credentials.username, credentials.password).subscribe(loginCheck => {
    //   if (!loginCheck) {
    //     this.messageService.add({ severity: 'error', summary: 'wrong credentials' });
    //   } else {
    //     this.router.navigate(['pages/home']);
    //   }
    // });

    this.apiService.put('user', credentials).subscribe(res => {
      this.messageService.add({ severity: 'info', summary: res.info });
    }, err => {
      this.messageService.add({ severity: 'error', summary: 'error', detail: JSON.stringify(err) });
    });
  }

  delete() {
    this.apiService.delete('user/' + this.authService.getAuth().userId).subscribe(res => {
      this.messageService.add({ severity: 'info', summary: res });
      this.authService.logout();
    }, err => {
      this.messageService.add({ severity: 'error', summary: 'error', detail: JSON.stringify(err) });
    });
  }
}
