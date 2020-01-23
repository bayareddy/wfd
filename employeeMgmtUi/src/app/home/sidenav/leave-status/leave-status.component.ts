import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import {NgxPaginationModule} from 'ngx-pagination';

@Component({
  selector: 'app-leave-status',
  templateUrl: './leave-status.component.html',
  styleUrls: ['./leave-status.component.css']
})
export class LeaveStatusComponent implements OnInit {

  myData:any={};

  form=new FormGroup({
    leaveStatusName:new FormControl('',Validators.required)
  })

  // public BASE_URL:string = 'http://ashok-env.vdqrmeqras.ap-south-1.elasticbeanstalk.com:8080';

  constructor(private api:ApiService,private http:HttpClient) { }



  ngOnInit() {

    
    this.getData();
  
  }
  sendData(myData){
let url=`/leave/leavestatus`
this.api.post(url,myData).subscribe(responce=>{
  
this.ngOnInit();
console.log(responce);
console.log("data from the input fields are "+myData)
})
}

deleteData(item){
  let url=`/leave/leavestatus/delete?leaveId=`
  url=url+item.leaveStatusId
  console.log("deleting url is"+url);
  this.api.delete(url).subscribe(responce=>{
    this.leave= responce as string[];
    this.ngOnInit();
  })

}

editData(item){
  this.myData=item;
  this.ngOnInit()
}




public leave:any[]=[];

    getData()
    {
      let url = `/leave/leavestatus/getall`;
      this.api.get(url).subscribe(backdata => {

          this.leave = backdata as string[];

          console.log(this.leave);

      },error=>{
        if(error==0){
alert('Please connect to Internet')
        }else{alert('Something went wrong')}
      });
    }


    






}
