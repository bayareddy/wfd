import { Component, OnInit } from '@angular/core';
import { RestService } from './service/rest.service';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit  {
  public myData:any = {};
 
  
  public BASE_URL:string = 'http://ec2-3-6-45-30.ap-south-1.compute.amazonaws.com:8081/';
  
  constructor(private service :RestService) { }

  ngOnInit() {
    this.getData();
    
   
  }
addData(data){
    console.log("4444444444444444444444", data); 

    let url = `${this.BASE_URL}/empRole`;

    

    this.service.post(url,data).subscribe(backenddata => {
      console.log("11111111111111", backenddata);


      this.ngOnInit();
      

      
    });

  }



  



public regData:any = [];

    getData()
    {
      let url = `${this.BASE_URL}/empRole/getAll`;
      this.service.get(url).subscribe(backdata => {

          this.regData = backdata as string[];

          

      });
    }


 DeleteData(i)

{
  
 

  let url = `${this.BASE_URL}/empRole/`;

url=url+i.id;



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




  

