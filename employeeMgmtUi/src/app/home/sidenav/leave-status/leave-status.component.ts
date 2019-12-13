import { Component, OnInit } from '@angular/core';
import { LeaveService } from './leave.service';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl, Validators } from '@angular/forms';




@Component({
  selector: 'app-leave-status',
  templateUrl: './leave-status.component.html',
  styleUrls: ['./leave-status.component.css']
})
export class LeaveStatusComponent implements OnInit {

  form=new FormGroup({
     $key: new FormControl(null),
    statusName:new FormControl('',[Validators.required])
  })


  public BASE_URL:string = 'http://ec2-3-6-45-30.ap-south-1.compute.amazonaws.com:8081';

  constructor(private service:LeaveService,private http:HttpClient) { }



  ngOnInit() {

    
    this.getData();
  
  }
  sendData(myData){
let url='${this.BASE_URL}/leave/leavestatus'
this.service.postService(url,myData).subscribe(responce=>{
this.ngOnInit();
console.log(responce);
})
}





public leave:any[]=[];

    getData()
    {
      let url = `${this.BASE_URL}/leave/leavestatus/getall`;
      this.service.getService(url).subscribe(backdata => {

          this.leave = backdata as string[];

          console.log(this.leave);

      },error=>{
        if(error==0){
alert('Please connect to Internet')
        }else{alert('Something went wrong')}
      });
    }


    edit(leave){
      
this.form.setValue(leave);

    
    }


}
