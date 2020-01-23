import { Component, OnInit } from '@angular/core';
import {NgxPaginationModule} from 'ngx-pagination';
import { ApiService } from 'src/app/service/api.service';


@Component({
  selector: 'app-employeement-history',
  templateUrl: './employeement-history.component.html',
  styleUrls: ['./employeement-history.component.css']
})
export class EmployeementHistoryComponent implements OnInit {
  public myData:any = {};
 
  
  // public BASE_URL:string = 'http://ashok-env.vdqrmeqras.ap-south-1.elasticbeanstalk.com:8080';
  constructor(private api :ApiService) { }

  ngOnInit() {
    this.getData();
    
   
  }
addData(data){
    console.log("4444444444444444444444", data); 

    let url = `/EmployementHistory`;

    

    this.api.post(url,data).subscribe(backenddata => {
      console.log("11111111111111", backenddata);
      this.ngOnInit();   
    });

  }
public regData:any = [];

    getData()
    {
      let url = `/EmployementHistory/getall`;
      this.api.get(url).subscribe(backdata => {

          this.regData = backdata as string[];
      });
    }


 DeleteData(i)

{
  
 

  let url = `/EmployementHistory?employeeId=`;

url=url+i.employementHistoryId;



  this.api.delete(url).subscribe(backdata => {

          this.regData = backdata as string[];

          console.log(this.regData);
this.ngOnInit();
      });


}


ReflectData(item)
{

console.log(item);

this.myData=item;

console.log(this.myData);
}
}




  

