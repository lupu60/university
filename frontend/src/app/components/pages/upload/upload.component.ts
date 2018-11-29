import { ApiService, LocalStorageService } from 'app/service/';
import { Component, OnInit } from '@angular/core';
import { Message } from 'primeng/primeng';
import { MessageService } from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.less']
})
export class UploadComponent implements OnInit {
  blocked = false;

  constructor(
    private apiService: ApiService,
    private messageService: MessageService,
    private localStorageService: LocalStorageService
  ) { }

  ngOnInit() {
  }
  import(event) {
    this.blocked = true;
    const importForm = new FormData();
    event.files.forEach(element => {
      importForm.append('uploadfiles', element);
    });
    importForm.append('userid', this.localStorageService.getString('userId'));
    this.apiService.postFile('doc/', importForm).subscribe(res => {
      this.messageService.add({ severity: 'info', summary: res.info });
      this.blocked = false;
    }, err => {
      this.messageService.add({ severity: 'error', summary: 'Upload error', detail: JSON.stringify(err) });
      this.blocked = false;
    });
  }
}
