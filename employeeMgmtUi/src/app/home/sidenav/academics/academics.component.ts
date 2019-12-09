import { Component,OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { RestService } from './rest.service';


@Component({
  selector: 'app-academics',
  templateUrl: './academics.component.html',
  styleUrls: ['./academics.component.css']
})

export class AcademicsComponent implements OnInit {
  public myData:any = {};
 
  
  public BASE_URL:string = 'http://ec2-3-6-45-30.ap-south-1.compute.amazonaws.com:8081';
  
  constructor(private service :RestService) { }

  ngOnInit() {
  this.getData();
  }
  
  addData(data){
    console.log("2", data); 
    let url = `${this.BASE_URL}/academicBackGround`;
    this.service.post(url,data).subscribe(backenddata => {
      console.log("1", backenddata);
      this.ngOnInit();
    });

  }
  
  DeleteData(item)
{

  let url = this.BASE_URL+'/academicBackGround?Id=';
  url=url+item.academicBackGroundId;
  this.service.delete(url).subscribe(backdata => {

  this.regData = backdata as string[];
  console.log(this.regData);
  this.ngOnInit();
      });
}


ReflectData(item){

console.log(item);
this.myData=item;
}



public regData:any = [];
getData(){
      let url = `${this.BASE_URL}/academicBackGround/getall`;
      this.service.get(url).subscribe(backdata => {

      this.regData = backdata as string[];
      console.log(this.regData);
      });
    }
  }
  

  
  


  