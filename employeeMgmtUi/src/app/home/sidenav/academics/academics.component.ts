import { Component,OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-academics',
  templateUrl: './academics.component.html',
  styleUrls: ['./academics.component.css']
})

export class AcademicsComponent implements OnInit {
  public myData:any = {};
 
  
  // public BASE_URL:string = 'http://ashok-env.vdqrmeqras.ap-south-1.elasticbeanstalk.com:8080';
  
  constructor(private api:ApiService) { }

  ngOnInit() {
  this.getData();
  }
  
  addData(data){
    console.log("2", data); 
    let url = `/academicBackGround`;
    this.api.post(url,data).subscribe(backenddata => {
      console.log("1", backenddata);
      this.ngOnInit();
    });

  }
  
  DeleteData(item){

  let url = '/academicBackGround/{Id}/{delete}?Id=';
  url=url+item.academicBackGroundId;
  this.api.delete(url).subscribe(backdata => {

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
      let url = `/academicBackGround/getall`;
      this.api.get(url).subscribe(backdata => {

      this.regData = backdata as string[];
      console.log(this.regData);
      });
    }
  }
  

  
  


  