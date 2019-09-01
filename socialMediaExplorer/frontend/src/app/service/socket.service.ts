import { Injectable } from '@angular/core';
import { Headers, Http, Response, URLSearchParams, RequestOptions } from '@angular/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Socket } from 'ng-socket-io';

@Injectable()
export class SocketService {
  constructor(private socket: Socket) { }

  searchHastag(msg: string) {
    this.socket.emit('search hastag', msg);
  }

  stopSearch() {
    this.socket.emit('stop search');
  }

  saveDataset() {
    this.socket.emit('save dataset');
  }

  clearDataSet() {
    this.socket.emit('clear dataset');
  }

  getTweets() {
    return this.socket
      .fromEvent('tweets')
      .map(data => JSON.parse(JSON.stringify(data)));
  }

}
