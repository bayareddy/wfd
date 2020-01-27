import { Component, OnInit } from '@angular/core';
import { MyprofileService } from 'src/app/service/myprofile.service';
import { LoginService } from 'src/app/login/login.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
  baseUrl = "http://ashok-env.vdqrmeqras.ap-south-1.elasticbeanstalk.com:8080/"
  constructor(private profile: MyprofileService,
    private loginService: LoginService
  ) { }
  currentUsers = {}
  currentUser = {}
  paidSalary={}
  bankDetails={}
  eid = '';

  ngOnInit() {

    this.currentUsers = this.loginService.currentUser;
    console.log('user data is ',this.currentUsers);
    console.log('current user Employee ID' + this.currentUsers['employeeId']);
    this.getById();
    this.eid = this.currentUsers['employeeId'];
    this.paidSalary=this.currentUsers['paidSalary'][0]
 this.bankDetails=this.currentUsers['bankDetails']

    console.log('paid salary is',this.paidSalary['id'])
    console.log('bank Details are',this.bankDetails['id'])
    console.log(this.eid)
  }



  getById() {
    let url = `${this.baseUrl}employee/${this.currentUsers['employeeId']}`
    this.profile.getProfile(url).subscribe(res => {
      this.currentUsers = res;
      this.currentUser = this.currentUsers;
    }
    )
  }

}
