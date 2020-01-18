import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import { RestService } from './rest.service';
import {NgxPaginationModule} from 'ngx-pagination';
import { from } from 'rxjs';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  public myData: any= {};
  public BASE_URL:string = 'http://ashok-env.vdqrmeqras.ap-south-1.elasticbeanstalk.com:8080';
  constructor(private service :RestService, private router: Router) { }

  ngOnInit() {
    this.getData();
    }
    
    addData(data){
      console.log("3333", data); 
      let url = `${this.BASE_URL}/Client`;
      this.service.post(url,data).subscribe(backenddata => {
        console.log("1", backenddata);
        this.ngOnInit();
      });
  
    }
    
  
  DeleteData(item){
    let url = this.BASE_URL+'/Client?ClientTypeId=';
  url=url+item.clientId;
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
        let url = `${this.BASE_URL}/Client/getall`;
        this.service.get(url).subscribe(backdata => {
  
        this.regData = backdata as string[];
        console.log(this.regData);
        });
      }
    }
    