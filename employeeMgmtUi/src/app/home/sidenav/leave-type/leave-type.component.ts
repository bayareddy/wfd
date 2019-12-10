import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-leave-type',
  templateUrl: './leave-type.component.html',
  styleUrls: ['./leave-type.component.css']
})
export class LeaveTypeComponent implements OnInit {
  [x: string]: any;

  constructor(private api:ApiService) { }
  // array
  // private leaveTypeList = <any>[];
  // leaveTypeForm = new FormGroup({
  //   leavetype: new FormControl('',[
  //     Validators.required])
  // });
  private leaveType;
  onSubmit() {
    console.log(this.leaveType);
    let leaveTypeName = this.leaveType
    this.api.post('/leave/leavetype',{leaveTypeName}).subscribe(
      (data)=>{
        console.log(data);
        this.getLeaveTypeData();
      },
      (err)=>{
        console.log(err);
      }
    );

  }
  onDelete(leaveTypeId) {
    debugger;
    this.api.delete('/leave/leavetype/delete?leaveId='+leaveTypeId).subscribe(
      (data)=>{
        console.log(data);
        this.getLeaveTypeData();
      },
      (err)=>{
        console.log(err);
      }
    );
  }
  
  ngOnInit() {
    debugger;
    this.getLeaveTypeData() ;
  }

  getLeaveTypeData() {
    this.api.get('/leave/leavetype/getall').subscribe(
      (data)=>{
        this.leaveTypeList=data;
      },
      (err) => {
        console.log(err);
      }
    );
  }

}
 