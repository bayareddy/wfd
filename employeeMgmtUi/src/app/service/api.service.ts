import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ApiService {
  private host:string;
  constructor(private http:HttpClient) { 
    this.host = 'http://ec2-13-234-116-123.ap-south-1.compute.amazonaws.com:8082';

  }

  get(url) {
    url = this.host+url;
    return this.http.get(url);
  }

  post(url,data) {
    url = this.host+url;
    return this.http.post(url,data);
  }
}
