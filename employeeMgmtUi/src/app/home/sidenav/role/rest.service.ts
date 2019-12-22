import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {  HttpClient, HttpParams, HttpEvent } from '@angular/common/http'; 


@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http:HttpClient) { 

  }

  post(url, data):Observable<any>{
  	console.log("serviceeeeeeeeeeeeeeeeeeeeeee", data, url);

  	return this.http.post(url,data);
  }


put(url, data):Observable<any>{
    console.log("serviceeeeeeeeeeeeeeeeeeeeeee", data, url);

    return this.http.put(url,data);
  }


  get(url):Observable<any>{
  	console.log("serviceee")
  	return this.http.get(url);
  }


  delete(url):Observable<any>{
    console.log("serviceee")
    return this.http.delete(url);
  }
  
}