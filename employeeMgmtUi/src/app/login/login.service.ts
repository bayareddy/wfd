import { Injectable } from '@angular/core';
import { ApiService } from '../service/api.service';

@Injectable()
export class LoginService {

  constructor(private api:ApiService) { }
  public currentUser = {};
  private loginUrl = '/employee/login';
  private forGetUrl = '';
  private creatUrl = '';
  onSubmit(data){
   let loginUrl = this.loginUrl+"?employeeId="+data.employeeId+"&password="+data.password;
  
   console.log('this is pardha===>>>'+loginUrl);
   
   return this.api.get(loginUrl);
   
  }
  
} 
