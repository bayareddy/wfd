import { Component, OnInit } from '@angular/core';
import { MyprofileService } from 'src/app/service/myprofile.service';
import { LoginService } from 'src/app/login/login.service';

@Component({
  selector: 'app-bank-details',
  templateUrl: './bank-details.component.html',
  styleUrls: ['./bank-details.component.css']
})
export class BankDetailsComponent implements OnInit {


  constructor(private profile: MyprofileService,

    private loginService: LoginService
  ) { }
  baseUrl = this.profile.baseUrl
  currentUsers = {}
  currentUser = {}
  bankDetails = {}
  eid = '';
  hidden = false;
  visible = false;
  alert = false;
  bankError = false;

  ngOnInit() {

    this.currentUsers = this.loginService.currentUser;
    this.eid = this.currentUsers['employeeId'];
    this.getBankById()
  }

  editBtn() {
    this.hidden = true;
  }

  getBankById() {

    this.profile.getBankByIdService(this.currentUsers['employeeId'])
      .subscribe((res) => {
        this.bankDetails = res;
      }), error => { console.log('error bank id', error) }
  }


  submitApi(bankDetails) {
    let url = `${this.baseUrl}/bankDetails`;
    console.log('bank details are pardha', bankDetails)
    this.profile.editBank(url, bankDetails)

      .subscribe(responce => {
        console.log(responce)
        this.alert = true;
        setTimeout(() => {
          this.alert = false;
        }, 3000);

      }, (error) => {
        this.bankError = true;
        setTimeout(() => {
          this.bankError = false;
        }, 3000);
        this.getBankById();
      })
    this.hidden = false;
  }

}
