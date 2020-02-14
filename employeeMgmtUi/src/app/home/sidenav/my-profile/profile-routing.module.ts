import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MyProfileComponent } from './my-profile.component';
import { BasicInformationComponent } from './basic-information/basic-information.component';
import { BankDetailsComponent } from './bank-details/bank-details.component';

const routes: Routes = [
  {path:'',component:MyProfileComponent,children:[
    {path:'basic_information',component:BasicInformationComponent},
    {path:'bank_details',component:BankDetailsComponent},
  ]},
  

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
