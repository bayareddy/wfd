import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeadernavComponent } from './home/headernav/headernav.component';
import { FooternavComponent } from './home/footernav/footernav.component';
import { SidenavComponent } from './home/sidenav/sidenav.component';
import { RoleComponent } from './home/sidenav/role/role.component';
import { LeaveStatusComponent } from './home/sidenav/leave-status/leave-status.component';
import { MainContentComponent } from './home/main-content/main-content.component';
import { AcademicsComponent } from './home/sidenav/academics/academics.component';
import { ClientComponent } from './home/sidenav/client/client.component';
import { LeaveTypeComponent } from './home/sidenav/leave-type/leave-type.component';
import { ForgetPasswordComponent } from './login/forget-password/forget-password.component';
import { EmployeementHistoryComponent } from './home/sidenav/employeement-history/employeement-history.component';
import { ResetPasswordComponent } from './login/reset-password/reset-password.component';
import { from } from 'rxjs';
import { MyProfileComponent } from './home/sidenav/my-profile/my-profile.component';



const appRoutes: Routes = [
  {
    path: '',

    children: [
      {
        path: 'home', component: HomeComponent,
        children: [
          { path: 'sideNavRole', component: RoleComponent },
          { path: 'emphis', component: EmployeementHistoryComponent },
          { path: 'sideNavLeaveStatus', component: LeaveStatusComponent },
          { path: 'sideNavAcademics', component: AcademicsComponent },
          { path: 'sideNavClient', component: ClientComponent },
          { path: 'leaveType', component: LeaveTypeComponent },
          { path: 'my_Profile', loadChildren: () => import('./home/sidenav/my-profile/profile.module').then(m => m.ProfileModule) },
          { path: '', component: MainContentComponent },
        ]
      },


      { path: "", component: LoginComponent }

    ],
    component: DashboardComponent
  },

  { path: 'login', component: LoginComponent },
  { path: 'resetpassword', component: ResetPasswordComponent },
  { path: 'forgetpassword', component: ForgetPasswordComponent },
  { path: '**', redirectTo: '/login' },
  { path: '**', redirectTo: '/login', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, {
      useHash: true
    })
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule { }
