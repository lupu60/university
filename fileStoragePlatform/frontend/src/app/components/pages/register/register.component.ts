import { Component, OnInit, OnDestroy } from '@angular/core';
import { ApiService } from 'app/service';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/components/common/messageservice';
import { Message } from 'primeng/components/common/message';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.less']
})
export class RegisterComponent implements OnInit {
  authForm: FormGroup;

  constructor(
    private api: ApiService,
    private router: Router,
    private fb: FormBuilder,
    private messageService: MessageService,
  ) { }


  ngOnInit() {
    this.authForm = this.fb.group({
      'username': ['', Validators.required],
      'password': ['', Validators.required]
    });
  }

  submitForm() {
    const credentials = this.authForm.value;
    this.authForm.reset();
    this.api.post('user', credentials).subscribe(res => {
      this.router.navigate(['auth/login']);
    }, err => {
      this.messageService.add({ severity: 'error', summary: 'register error', detail: err.info });
    });
  }
}
