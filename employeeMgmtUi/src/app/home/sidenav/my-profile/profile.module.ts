import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileRoutingModule } from './profile-routing.module';
import { BankDetailsComponent } from './bank-details/bank-details.component';
import { BasicInformationComponent } from './basic-information/basic-information.component';
import { MyProfileComponent } from './my-profile.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    MyProfileComponent,
    BankDetailsComponent,
    BasicInformationComponent,
  ],
  imports: [
    CommonModule,
    ProfileRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  exports:[
    MyProfileComponent,
    BankDetailsComponent,
    BasicInformationComponent,
    
  ]
})
export class ProfileModule { }
