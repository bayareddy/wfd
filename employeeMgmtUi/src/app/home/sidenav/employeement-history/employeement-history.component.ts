import { Component, OnInit } from '@angular/core';
import {NgxPaginationModule} from 'ngx-pagination';
import { RestService } from './service/rest.service';

@Component({
  selector: 'app-employeement-history',
  templateUrl: './employeement-history.component.html',
  styleUrls: ['./employeement-history.component.css']
})
export class EmployeementHistoryComponent implements OnInit {
  public myData:any = {};
 
  
  public BASE_URL:string = 'http://ashok-env.vdqrmeqras.ap-south-1.elasticbeanstalk.com:8080';
  
  constructor(private service :RestService) { }

  ngOnInit() {
    this.getData();
    
   
  }
addData(data){
    console.log("4444444444444444444444", data); 

    let url = `${this.BASE_URL}/EmployementHistory`;

    

    this.service.post(url,data).subscribe(backenddata => {
      console.log("11111111111111", backenddata);


      this.ngOnInit();
      

      
    });

  }



  



public regData:any = [];

    getData()
    {
      let url = `${this.BASE_URL}/EmployementHistory/getall`;
      this.service.get(url).subscribe(backdata => {

          this.regData = backdata as string[];

          

      });
    }


 DeleteData(i)

{
  
 

  let url = `${this.BASE_URL}/EmployementHistory?employeeId=`;

url=url+i.employementHistoryId;



  this.service.delete(url).subscribe(backdata => {

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




  

