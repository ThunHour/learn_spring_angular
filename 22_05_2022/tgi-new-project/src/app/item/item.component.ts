import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss'],
})
export class ItemComponent implements OnInit {
  @Input() item: any  ;
  @Output() clickItem=new EventEmitter();
  constructor() {}

  ngOnInit() {}
  OnClickItem(item:any){
      this.clickItem.emit(item);
    
}}
