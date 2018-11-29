import { Component, OnInit, ViewChild } from '@angular/core';
import { ApiService, LocalStorageService, SocketService } from 'app/service';
import { Message } from 'primeng/primeng';
import { MenuItem } from 'primeng/components/common/menuitem';
import { TableViewComponent } from 'app/components/widgets/tableview/tableview.component';
import { MessageService } from 'primeng/components/common/messageservice';
import { environment } from '../../../../environments/environment';
import { UIChart } from 'primeng/components/chart/chart';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})

export class HomeComponent implements OnInit {
  msgs: Message[];
  @ViewChild(UIChart) chart: UIChart;
  searchedHashtag: string;
  tweetsPerSec = 0;
  twitterChart: any;

  constructor(private apiService: ApiService,
    private messageService: MessageService,
    private socketService: SocketService,
    private localStorageService: LocalStorageService) { }

  ngOnInit() {
    this.twitterChart = this.getInitConfigForTwitterChart();
    this.socketService.getTweets().subscribe(tweet => {
      this.populateTwitterChart(tweet);
    });
  }

  realTimeSearch() {
    this.socketService.searchHastag(this.searchedHashtag);
    this.clear();
  }

  clear() {
    this.twitterChart.labels = [];
    this.twitterChart.datasets[0].data = [];
    this.socketService.clearDataSet();
    this.chart.refresh();
  }

  stopSearch() {
    this.socketService.stopSearch();
  }

  savedataset() {
    this.socketService.saveDataset();
  }

  populateTwitterChart(tweet) {
    const tempLabels = new Set(this.twitterChart.labels);
    const tweetCreatedDate = new Date(tweet.created_at);
    const newLable = tweetCreatedDate.getMinutes() + ' : ' + tweetCreatedDate.getSeconds();
    if (tempLabels.has(newLable)) {
      this.tweetsPerSec++;
    } else {
      this.twitterChart.datasets[0].data.push(this.tweetsPerSec);
      this.tweetsPerSec = 0;
    }
    tempLabels.add(newLable);
    this.twitterChart.labels = Array.from(tempLabels);
    this.chart.refresh();
  }

  getInitConfigForTwitterChart() {
    return {
      labels: [],
      datasets: [
        {
          label: 'Twitter Real Time Counter',
          data: [],
          fill: false,
          borderColor: '#33ECFF'
        }
      ]
    };
  }

}

