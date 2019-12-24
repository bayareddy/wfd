import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrls: ['./forget-password.component.css']
})
export class ForgetPasswordComponent implements OnInit {
myData={};
employeeId;
pancard;
  constructor(private apiSer:ApiService,private router:Router) { }


  ngOnInit() {

  }

addData(data){
  let url=`/employee/forget?pancard=${this.pancard}&employeeId=${this.employeeId}`
  console.log('working',url)
this.apiSer.get(url).subscribe((res)=>{
  if(this.employeeId==res['employeeId'] && this.pancard==res['pancard']){
    this.router.navigate(['/resetpassword']);

  }
},(error:Response)=>{
  if(error.status==400){
alert(error+'error');
  }
})
}

}