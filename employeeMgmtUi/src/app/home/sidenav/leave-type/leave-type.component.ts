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
  private leaveTypeName;
  onSubmit() {
    console.log(this.leaveTypeName);
    let leaveTypeName = this.leaveTypeName
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
  onedit(leaveType){
    this.leaveTypeName = leaveType.leaveTypeName;
    this.leaveType = leaveType;
    //this.api.edit('/leave/leavetype/update')
  }
  onUpdate() {
    console.log(this.leaveType.leaveTypeId);
    console.log(this.leaveTypeName);
    let data = {
      leaveTypeId:this.leaveType.leaveTypeId,
      leaveTypeName:this.leaveTypeName
    }
    this.api.edit('/leave/leavetype/update',data).subscribe(
      (data)=>{
        this.getLeaveTypeData();
        alert("Succesfull edit");
      },
      (err)=>{
        alert(err);
      }
    )
  }
  ngOnInit() {
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
 