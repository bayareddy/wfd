import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiService } from './api.service';


@Injectable({
  providedIn: 'root'
})
export class MyprofileService {
  
 


  constructor(private http:HttpClient,private api:ApiService) { }
  baseUrl =this.api.host ;
getProfile(url){

return this.http.get(url)
}

editBank(url,data){
return this.http.put(url,data);
}

getBankByIdService(id){
  let url=`${this.baseUrl}/bankdetails/${id}`
 return this.http.get(url)
}
}
