import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl ,Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';

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
  get employeeId() { return this.loginForm.get('employeeId'); }
  constructor(private loginService:LoginService, private router:Router) { }

  ngOnInit() {
  }
 
  onSubmit(event) {
    console.log("@submit",event);
    console.log(this.loginForm.value);
    this.loginService.onSubmit(this.loginForm.value).subscribe(
      (data)=>{
        if(data) {
          this.loginService.currentUser=data;
          this.router.navigate(['/home']);
        } else {
          this.errMsg = 'Please enter valid details';  
        }
      },
      (err)=>{
        console.log(err);
        if(err.status === 400) {
          this.errMsg = 'Please enter valid details';  
        } else {
          this.errMsg = 'Something is wrong please try again';  
        } 
      }
    );
  }

  forgetPassword() {
    console.log("@forgetPassword");
  }
}
