import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class MyprofileService {
  
  baseUrl = 'http://employemanagment-env.6dpm2iqwkd.ap-south-1.elasticbeanstalk.com:8080';


  constructor(private http:HttpClient) { }

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
