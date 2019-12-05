import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class LeaveService {

  constructor(private http:HttpClient) { }

postService(url,data){
  this.http.post(url,data);
  return this.http.post(url,data);
}

getService(url){
this.http.get(url);
return this.http.get(url);
}


  
}
