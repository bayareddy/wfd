import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {CommonService} from '../service/common.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(  private formBuilder: FormBuilder, public commonService: CommonService) { }

  loginForm: any;
  loginData: any;
  logindata: any;
  formSubmitAttempt: Boolean = false;
  ngOnInit() {
    this.createForm2();
  }
  createForm2() {
    this.loginForm = this.formBuilder.group({
      insurer: [null, Validators.required],
      passCode: [null, Validators.required]
    });
  }
  isFieldValid(field: string) {
    return (
      (!this.loginForm.get(field).valid && this.loginForm.get(field).touched) ||
      (this.loginForm.get(field).untouched && this.formSubmitAttempt)
    );
  }
  displayFieldCss(field: string) {
    return {
      'has-error': this.isFieldValid(field),
      'has-feedback': this.isFieldValid(field)
    };
  }
  resetLoginForm() {
    this.formSubmitAttempt = false;
    // this.loginForm.controls['insurer'].value = ' ';
    // this.loginForm.controls['passCode'].value = ' ';
  }
  onSubmit() {
    this.formSubmitAttempt = true;
    console.log(this.loginForm.valid);
    if (this.loginForm.valid) {
      this.logindata = [
        this.loginForm.controls['insurer'].value,
        this.loginForm.controls['passCode'].value
      ];
      this.commonService.sendLoginData(this.logindata).subscribe(
        value => {
          this.loginData = value;
        },
        error => console.log('Error :: ' + error)
      );

      this.resetLoginForm();
    }
  }
}
