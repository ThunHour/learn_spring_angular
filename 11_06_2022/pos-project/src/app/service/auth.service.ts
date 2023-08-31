import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { LoginModel } from '../model/login.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

constructor(private http:HttpClient,private _router:Router) { }

login(login:LoginModel){
  let httpption={
    header: new HttpHeaders({
      'Content-Type':'application/json'
    }),
    body:null,
    params:new HttpParams()
  }
  this.http.post("https://api.buzsic.com/auth/auth/login",{username:login.username,password:login.password},httpption).toPromise().then((res:any)=>{
    this._router.navigate(['/sale']);
    localStorage.setItem('token',res.data.access_token)
  })

}
isAuthenticated():boolean{
  const token=localStorage.getItem('token')
  return !(token===null||token===""||token===undefined)
}

}
