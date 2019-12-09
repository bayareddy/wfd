import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import {CommonService} from './service/common.service';

import { LoginService } from './login/login.service';
import { ApiService } from './service/api.service';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {FormsModule , ReactiveFormsModule  } from '@angular/forms';
import { FieldErrorDisplayComponent } from './field-error-display/field-error-display.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { HeadernavComponent } from './home/headernav/headernav.component';
import { SidenavComponent } from './home/sidenav/sidenav.component';
import { FooternavComponent } from './home/footernav/footernav.component';
import { ExpandMenu } from './home/sidenav/ExpandMenu';
import { AcademicsComponent } from './home/sidenav/academics/academics.component';
import { MainContentComponent } from './home/main-content/main-content.component';
import { RoleComponent } from './home/sidenav/role/role.component';

import { LeaveStatusComponent } from './home/sidenav/leave-status/leave-status.component';
import { DefaultComponent } from './home/default/default.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FieldErrorDisplayComponent,
    DashboardComponent,
    HomeComponent,
    HeadernavComponent,
    SidenavComponent,
    FooternavComponent,
    ExpandMenu,
    
    MainContentComponent,
  
    RoleComponent,
    AcademicsComponent,
    LeaveStatusComponent,
  
    DefaultComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [CommonService,LoginService,ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
