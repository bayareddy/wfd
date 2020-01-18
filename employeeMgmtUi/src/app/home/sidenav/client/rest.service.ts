import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {  HttpClient, HttpParams, HttpEvent } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http:HttpClient) { }


post(url, data):Observable<any>{
  console.log("service", data, url);

  return this.http.post(url,data);
}


get(url):Observable<any>{
  console.log("service")
  return this.http.get(url);
}


delete(url):Observable<any>{
  console.log("serviceeee",url);
  return this.http.delete(url);
}
}