import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';


const appRoutes: Routes = [
  {
    path: '',
    children: [
 { path: '', redirectTo: '/login', pathMatch: 'full' }
 ],
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
