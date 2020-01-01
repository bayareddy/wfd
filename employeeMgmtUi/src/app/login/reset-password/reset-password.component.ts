import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl ,Validators, ValidationErrors, AbstractControl, FormBuilder} from '@angular/forms';
import { ApiService } from 'src/app/service/api.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})

export class ResetPasswordComponent implements OnInit {
  [x: string]: any;
 changedpid=false;
 passwordForm: FormGroup;
 

errMsg='';
  newPassword;
  
  constructor(private apiSer:ApiService,private router: Router,private fb: FormBuilder) {}
  ngOnInit() {
     this.buildForm();
  }

  buildForm() {
    this.passwordForm = this.fb.group({
      newPassword: new FormControl('',[
        Validators.required]),
        retypePassword: new FormControl('',[
        Validators.required]),
         });
  }

  get Validation() {
    return this.passwordForm.controls;
  }
  
  onsubmit(formVal){
    console.log(formVal);
    
    if(this.Validation.newPassword.value !== this.Validation.retypePassword.value) {
      alert('password not match')
    } else {
      let url =`/employee/updatePassword?employeeId=${this.apiSer.forgetId}&newPassword=`;
    url = url+this.passwordForm.value.newPassword;
    console.log('working',url);
    console.log(this.passwordForm.value);
    this.apiSer.get(url).subscribe((response)=>{
      if(this.apiSer.forgetId==response['employeeId'] && this.newPassword==response['newPassword'] && this.newPassword==response['retypePassword']){
      
      console.log('dddddd',response);}
   
    },
    
    (error)=>{
      console.log('this error is'+error);
      this.changedpid=true;
      
      
      setTimeout(()=>{
        this.router.navigate(['/login']);
      },3000);
      
    
    });
    }
  }
}
