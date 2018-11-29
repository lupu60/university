import { Component, OnInit, ViewChild } from '@angular/core';
import { ApiService } from 'app/service';
import { UIChart } from 'primeng/components/chart/chart';

@Component({
  selector: 'app-instagram',
  templateUrl: './instagram.component.html',
  styleUrls: ['./instagram.component.less']
})
export class InstagramComponent implements OnInit {
  intagramMediaCountChart: any;
  searchedHashtag: string;
  @ViewChild(UIChart) chart: UIChart;

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.intagramMediaCountChart = this.getInitConfigForInstagramMediaCountChart();
  }

  search() {
    this.apiService.post('instagram', { text: this.searchedHashtag }).subscribe(res => {
      this.populateIntagramMediaCountChart(res.data.data);
      this.chart.refresh();
    });
  }

  populateIntagramMediaCountChart(media) {
    for (const element of media) {
      this.intagramMediaCountChart.labels.push(element.name);
      this.intagramMediaCountChart.datasets[0].data.push(element.media_count);
    }
  }

  getInitConfigForInstagramMediaCountChart() {
    return {
      labels: [],
      datasets: [
        {
          label: 'Instagram tag media count',
          data: [],
          fill: true,
          borderColor: '#fb3958'
        }
      ]
    };
  }
}
