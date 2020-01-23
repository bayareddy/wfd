import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/service/api.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit  {
  public myData:any = {};
 
  
  // public BASE_URL:string = 'http://ashok-env.vdqrmeqras.ap-south-1.elasticbeanstalk.com:8080';
  
  constructor(private api :ApiService,private http:HttpClient) { }

  ngOnInit() {
    this.getData();
    
   
  }
addData(data){
    console.log("4444444444444444444444", data); 

    let url = `/empRole`;

    

    this.api.post(url,data).subscribe(backenddata => {
      console.log("11111111111111", backenddata);


      this.ngOnInit();
            
    });

  }



public regData:any = [];

    getData()
    {
      let url = `/empRole/getAll`;
      this.api.get(url).subscribe(backdata => {

          this.regData = backdata as string[];

          

      });
    }


 DeleteData(item){
  
  let url = `/empRole/`;

url=url+item.id;

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




  

