import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Observable } from 'rxjs/Observable';

@Injectable()
export class ApiService {
  private host:string;
  constructor(private http:HttpClient) { 
    this.host = 'http://ec2-3-6-45-30.ap-south-1.compute.amazonaws.com:8081';
  }
 
  get(url) {
    url = this.host+url;
    return this.http.get(url);
  }

  post(url,data) {
    url = this.host+url;
    return this.http.post(url,data);
  }

  delete(url) {
    url = this.host+url;
    return this.http.delete(url);

  
  }
  edit(url,data){
    url=this.host+url;
    return this.http.put(url,data);
  }
}
