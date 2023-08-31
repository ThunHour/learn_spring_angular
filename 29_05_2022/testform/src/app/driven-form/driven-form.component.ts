import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-driven-form',
  templateUrl: './driven-form.component.html',
  styleUrls: ['./driven-form.component.scss']
})
export class DrivenFormComponent implements OnInit {
  @ViewChild('f') pForm:NgForm|undefined;
  constructor() { }

  ngOnInit() {
  }
  OnSubmit(){
    console.log(this.pForm?.value)
  }
}
