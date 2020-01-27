import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl ,Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { compileBaseDefFromMetadata } from '@angular/compiler';
import { HttpClient } from '@angular/common/http';
import { UpperCasePipe } from '@angular/common';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 loginForm = new FormGroup({
    employeeId: new FormControl('',[
      Validators.required]),
    password: new FormControl('',[
      Validators.required]),
  });
  errMsg='';
  get employeeId() { 
    return this.loginForm.get('employeeId'); 
  }
  get password() { 
    return this.loginForm.get('password'); 
  }
  constructor(private loginService:LoginService, private router:Router) { }

  ngOnInit() {
  }
 
  onSubmit(event) {
    console.log("@submit",event);
    console.log("login values are pardha",this.loginForm.value);
    this.loginService.onSubmit(this.loginForm.value).subscribe(
      (data)=>{
        if(data) {
          this.loginService.currentUser=data;
          this.router.navigate(['./home']);
        } else {
          this.errMsg = 'Please enter valid details';  
        }
      },
      (err)=>{
        console.log(err);
        if(err.status === 400 || err.status===401) {
          this.errMsg = 'Please enter valid EmployeeId and Password !';  
        } else {
          this.errMsg = 'Something Went Wrong Please try again';  
        } 
      }
    );
  }





}

 
