import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class MyprofileService {

  constructor(private http:HttpClient) { }

getProfile(url){

return this.http.get(url)
}
}
