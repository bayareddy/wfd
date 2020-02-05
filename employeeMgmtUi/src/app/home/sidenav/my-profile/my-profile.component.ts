import { Component, OnInit } from '@angular/core';
import { MyprofileService } from 'src/app/service/myprofile.service';
import { LoginService } from 'src/app/login/login.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {

  constructor(private profile: MyprofileService,
    
    private loginService: LoginService
  ) { }
  baseUrl = this.profile.baseUrl
  currentUsers = {}
  currentUser = {}
  paidSalary = {}
  bankDetails = {}
  eid = '';
  hidden = false;
  visible = false;
  alert=false;
  bankError=false;

  ngOnInit() {

    this.currentUsers = this.loginService.currentUser;
    console.log('user data is ', this.currentUsers);
    console.log('current user Employee ID' + this.currentUsers['employeeId']);
    this.getById();
    this.eid = this.currentUsers['employeeId'];
    this.paidSalary = this.currentUsers['paidSalary'][0]
    //this.bankDetails=this.currentUsers['bankDetails']

    console.log('paid salary is', this.paidSalary['id'])
    console.log('bank Details are', this.bankDetails['id'])
    console.log(this.eid);
    console.log(this.currentUsers['employeeId'])
    this.getBankById()
  }



  getById() {
    let url = `${this.baseUrl}employee/${this.currentUsers['employeeId']}`
    this.profile.getProfile(url).subscribe(res => {
      this.currentUsers = res;
      this.currentUser = this.currentUsers;
    }
    )
  }


  editBtn() {
    this.hidden = true;


  }

  getBankById() {
    console.log('id is' + this.currentUsers['employeeId'])
    this.profile.getBankByIdService(this.currentUsers['employeeId'])
      .subscribe((res) => {
        
        console.log(res)
        this.bankDetails = res;
      })
  }


  submitApi(bankDetails) {
    let url = `${this.baseUrl}/bankdetails`;
    console.log('bank details are ', bankDetails)
    this.profile.editBank(url, bankDetails)

      .subscribe(responce => {
        console.log(responce)
        this.alert=true;
        setTimeout(() => {
          this.alert=false;
        }, 3000);

      }, (error) => {
        this.bankError=true;
        setTimeout(() => {
          this.bankError=false;
        }, 3000);
        this.getBankById();
      })
    this.hidden = false;
  }

}
