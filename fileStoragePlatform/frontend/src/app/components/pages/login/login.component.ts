import { Component, OnInit, HostBinding, OnDestroy } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { AuthenticationService } from 'app/service';
import { MessageService } from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})

export class LoginComponent implements OnInit {
  authForm: FormGroup;

  constructor(
    private authService: AuthenticationService,
    private fb: FormBuilder,
    private messageService: MessageService) { }

  ngOnInit() {
    this.authForm = this.fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required]
    });
  }

  submitForm() {
    const credentials = this.authForm.value;
    this.authForm.reset();
    this.authService.login(credentials.username, credentials.password).subscribe(loginCheck => {
      if (!loginCheck) {
        this.messageService.add({ severity: 'error', summary: 'wrong credentials' });
      }
    });
  }
}

