import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';


const appRoutes: Routes = [
  {path: '',
      children: [
        { path: 'home', component: HomeComponent },
        { path: 'empDetails', component: HomeComponent },
        { path: '',   redirectTo: '/login', pathMatch: 'full' }
       ],
      component: DashboardComponent
    },
  { path: 'login', component: LoginComponent },
 { path: '**', redirectTo: '/login' },
  { path: '**', redirectTo: '/login', pathMatch: 'full' }
];


appRoutes.push({ path: '**', redirectTo: '/login' });

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
