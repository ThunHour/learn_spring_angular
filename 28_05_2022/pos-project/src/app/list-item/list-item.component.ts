import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.scss']
})
export class ListItemComponent implements OnInit {
  listItem:any[]=[]
  constructor(private _itemservice:ItemService) { }

  ngOnInit() {
    this.listItem=this._itemservice.getAllData()
  }

}
