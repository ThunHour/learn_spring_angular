import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from './auth.service';


@Injectable()
export class AuthGuard implements CanActivate {
  canActivate(
  ):boolean{
    if (this.auth.isAuthenticated()){
      return true
    }


      this.route.navigate(['/login'])
      return false


  }
  constructor(private auth:AuthService,private route:Router){

  }

}
