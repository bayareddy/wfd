import { Component, OnInit } from '@angular/core';
import { MyprofileService } from 'src/app/service/myprofile.service';
import { LoginService } from 'src/app/login/login.service';

@Component({
  selector: 'app-basic-information',
  templateUrl: './basic-information.component.html',
  styleUrls: ['./basic-information.component.css']
})
export class BasicInformationComponent implements OnInit {
  constructor(private profile: MyprofileService,
    private loginService: LoginService
  ) { }
  baseUrl = this.profile.baseUrl
  currentUsers = {}
  eid = '';
  ngOnInit() {
    this.currentUsers = this.loginService.currentUser;
    this.eid = this.currentUsers['employeeId'];
  }
}
