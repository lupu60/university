import { Component, OnInit, ViewChild } from '@angular/core';
import { ApiService, LocalStorageService } from 'app/service';
import { Message } from 'primeng/primeng';
import { MenuItem } from 'primeng/components/common/menuitem';
import { TableViewComponent } from 'app/components/widgets/tableview/tableview.component';
import { MessageService } from 'primeng/components/common/messageservice';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-files',
  templateUrl: './files.component.html',
  styleUrls: ['./files.component.less']
})
export class FilesComponent implements OnInit {

  @ViewChild(TableViewComponent) tableView: TableViewComponent;
  tableInput: any;
  isDataAvailable = false;
  tableViewOptions = { 'actionbuttons': ['view', 'delete'], 'hideColumn': ['_id', 'userid'] };

  constructor(private apiService: ApiService,
    private messageService: MessageService,
    private localStorageService: LocalStorageService) { }

  ngOnInit() {
    this.apiService.get('doc/user/' + this.localStorageService.getString('userId')).subscribe(res => {
      this.tableInput = res;
      this.isDataAvailable = true;
    }, err => {
      this.messageService.add({ severity: 'error', summary: err.error, detail: err.message });
    });
  }

  viewRow(row: any) {
    window.open(`${environment.api_url}${'doc/'}${row._id}`);
  }

  deleteRow(row: any) {
    this.apiService.delete('doc/' + row._id).subscribe(res => {
      this.messageService.add({ severity: 'info', summary: res.info });
    }, err => {
      this.messageService.add({ severity: 'error', summary: err.error, detail: err.message });
    });
  }

}
