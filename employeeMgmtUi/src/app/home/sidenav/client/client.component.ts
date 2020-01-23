import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';
import { from } from 'rxjs';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  public myData: any= {};
  // public BASE_URL:string = 'http://ashok-env.vdqrmeqras.ap-south-1.elasticbeanstalk.com:8080';
  constructor(private api:ApiService, private router: Router) { }

  ngOnInit() {
    this.getData();
    }
    
    addData(data){
      console.log("3333", data); 
      let url = `/Client`;
      this.api.post(url,data).subscribe(backenddata => {
        console.log("1", backenddata);
        this.ngOnInit();
      });
  
    }
    
  
  DeleteData(item){
    let url = '/Client?ClientTypeId=';
  url=url+item.clientId;
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
        let url = `/Client/getall`;
        this.api.get(url).subscribe(backdata => {
  
        this.regData = backdata as string[];
        console.log(this.regData);
        });
      }
    }
    