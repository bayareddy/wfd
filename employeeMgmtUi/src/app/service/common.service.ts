import {
  HttpClient,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class CommonService {
  postOptions = {
    headers: new HttpHeaders({
      Accept: 'application/json',
      'Content-Type': 'application/json'
    })
  };
  loginData: any;
  constructor(private http: HttpClient) { }

  private addNewOrderUrl =
    'http://localhost:4000/channels/mychannel/chaincodes/mycc';
  // private telematicsDataUrl = 'https://jsonplaceholder.typicode.com/users';
  addNewOrderService(data): Observable<any> {
    const body = JSON.stringify(data);
    console.log('data coming' + data);
    return this.http.post<any>(this.addNewOrderUrl, body);
  }
  public sendLoginData(data): Observable<any> {
    this.loginData = data;
    return this.http.post(
      this.addNewOrderUrl,
      this.loginData,
      this.postOptions
    );
  }
}
