import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.scss']
})
export class ListItemComponent implements OnInit {
  @Input() listItem:any;
  @Output() clickIem=new EventEmitter();
  constructor() { }

  ngOnInit() {
  }
  onClickite(item:any):void{
      this.clickIem.emit(item);
    
  }
}
