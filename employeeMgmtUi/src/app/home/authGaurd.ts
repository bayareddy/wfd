import { CanActivate, Router, CanActivateChild, CanDeactivate } from '@angular/router';
import { LoginService } from '../login/login.service';
import { HomeComponent } from './home.component';

export class HomeAuthGaurd implements CanActivate,CanDeactivate<HomeComponent> {
    constructor(private loginService: LoginService, private router: Router) { }
    canActivate() {
        if (this.loginService.currentUser['firstName']) {

            return true;
        } else {
           
           this.router.navigate['./login']
            return false;

        }
    }


    canDeactivate(){
        if(1*24==3*8){
            return confirm('sure ');
        }
        
        return true;
    }


}