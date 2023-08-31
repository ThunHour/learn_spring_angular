import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import * as CryptoJS from 'crypto-js';
@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.scss'],
})
export class ReactiveFormComponent implements OnInit {
  set(keys:string, value:string){
    var key = CryptoJS.enc.Utf8.parse(keys);
    var iv = CryptoJS.enc.Utf8.parse(keys);
    var encrypted = CryptoJS.AES.encrypt(CryptoJS.enc.Utf8.parse(value.toString()), key,
    {
        keySize: 128 / 8,
        iv: iv,
        mode: CryptoJS.mode.CBC,
        padding: CryptoJS.pad.Pkcs7
    });

    return encrypted.toString();
  }
  form: FormGroup;
  constructor(private _fb: FormBuilder) {
    this.form = this._fb.group({
      email: new FormControl('', Validators.required),
      password:new FormControl('',Validators.required),
    });
  }
  ngOnInit() {}
  OnSubmit(){

    console.log(this.form.value.email,this.set('1k24hek1hgr3hek12e',this.form.value.password))
  }
}
