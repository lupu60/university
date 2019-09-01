import { Component, OnInit, ViewChild } from '@angular/core';
import { UIChart } from 'primeng/components/chart/chart';
import { ApiService, SocketService, LocalStorageService } from 'app/service';
import { MessageService } from 'primeng/components/common/messageservice';
import { TableViewComponent } from 'app/components/widgets/tableview/tableview.component';

@Component({
  selector: 'app-sentiment-analysis',
  templateUrl: './sentiment-analysis.component.html',
  styleUrls: ['./sentiment-analysis.component.less']
})
export class SentimentAnalysisComponent implements OnInit {

  @ViewChild(TableViewComponent) tableView: TableViewComponent;
  tableInput: any;
  isDataAvailable = false;
  tableViewOptions = { 'actionbuttons': ['view', 'delete'], 'hideColumn': ['id'] };

  @ViewChild(UIChart) chart: UIChart;
  twitterSentimentChart: any;

  constructor(private apiService: ApiService,
    private messageService: MessageService,
    private socketService: SocketService,
    private localStorageService: LocalStorageService) { }

  ngOnInit() {
    this.apiService.get('dataset/').subscribe(res => {
      this.tableInput = res;
      this.isDataAvailable = true;
    }, err => {
      this.messageService.add({ severity: 'error', summary: err.error, detail: err.message });
    });
    this.twitterSentimentChart = this.getInitConfigForTwitterSentimentChart();
  }


  getInitConfigForTwitterSentimentChart() {
    return {
      labels: ['Negative', 'Neutral', 'Positive'],
      datasets: [
        {
          data: [0, 0, 0],
          backgroundColor: [
            '#FF6384',
            '#36A2EB',
            '#FFCE56'
          ],
          hoverBackgroundColor: [
            '#FF6384',
            '#36A2EB',
            '#FFCE56'
          ]
        }]
    };
  }

  viewRow(row: any) {
    this.twitterSentimentChart = this.getInitConfigForTwitterSentimentChart();
    this.apiService.get('analysis/' + row.id).subscribe(res => {
      this.twitterSentimentChart = res;
    }, err => {
      this.messageService.add({ severity: 'error', summary: err.error, detail: err.message });
    });
  }

  deleteRow(row: any) {
    this.apiService.delete('dataset/' + row.id).subscribe(res => {
      this.messageService.add({ severity: 'info', summary: res.data });
    }, err => {
      this.messageService.add({ severity: 'error', summary: err.error, detail: err.message });
    });
  }

}
