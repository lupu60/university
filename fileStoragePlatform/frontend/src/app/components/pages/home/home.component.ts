import { Component, OnInit, ViewChild } from '@angular/core';
import { ApiService, LocalStorageService } from 'app/service';
import { Message } from 'primeng/primeng';
import { MenuItem } from 'primeng/components/common/menuitem';
import { TableViewComponent } from 'app/components/widgets/tableview/tableview.component';
import { MessageService } from 'primeng/components/common/messageservice';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})

export class HomeComponent implements OnInit {
  chartData: any;

  @ViewChild(TableViewComponent) tableView: TableViewComponent;
  tableInput: any;
  isDataAvailable = false;
  tableViewOptions = { 'actionbuttons': [], 'hideColumn': ['_id', 'userid'] };

  constructor(private apiService: ApiService,
    private messageService: MessageService,
    private localStorageService: LocalStorageService) { }

  ngOnInit() {
    this.apiService.get('doc/user/' + this.localStorageService.getString('userId')).subscribe(res => {
      this.chartData = this.getNumberoftypes(res);

      this.tableInput = res.slice(Math.max(res.length - 10, 1))      ;
      this.isDataAvailable = true;
    });
  }

  getNumberoftypes(allFiles: any) {
    const labels: Set<string> = new Set();
    const data: Array<number> = new Array();
    const count: Map<string, number> = new Map();
    allFiles.forEach(file => {
      labels.add(file.type);
    });

    labels.forEach(label => {
      allFiles.forEach(file => {
        if (file.type === label) {
          let number = count.get(label);
          if (typeof number === 'undefined') {
            count.set(label, 1);
          } else {
            number++;
            count.set(label, number);
          }
        }
      });
    });

    count.forEach((v, k) => {
      data.push(v);
    });

    const backgroundColor = [];
    data.forEach(element => {
      backgroundColor.push('#' + (0x1000000 + (Math.random()) * 0xffffff).toString(16).substr(1, 6));
    });
    return {
      labels: Array.from(labels.values()),
      datasets: [
        {
          data: data,
          backgroundColor: backgroundColor,
          hoverBackgroundColor: backgroundColor
        }]
    };
  }
}

