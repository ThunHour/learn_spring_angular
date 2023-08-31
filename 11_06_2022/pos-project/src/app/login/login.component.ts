import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginModel } from '../model/login.model';
import { AuthService } from '../service/auth.service';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  form:FormGroup;
  constructor(private _fb:FormBuilder,private itemService:ItemService,private auth:AuthService) {
    this.form=this._fb.group({
      username:new FormControl("",Validators.required),
      password:new FormControl("",Validators.required)
    })
   }

  ngOnInit() {
  }
  onSubmit(){
    this.auth.login(new LoginModel(this.form.value.username,this.form.value.password))
  }

}
