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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FieldErrorDisplayComponent,
    DashboardComponent,
    HomeComponent
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
