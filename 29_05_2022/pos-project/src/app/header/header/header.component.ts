import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  constructor(private _router:Router){}
  ngOnInit(): void {

  }
  switchToItem(){
    this._router.navigate(['/item']);
  }
  stayHere(){
    this._router.navigate(['/']);
  }
  switchToCategory(){
    this._router.navigate(['category'])
  }
}
