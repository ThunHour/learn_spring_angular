import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-list-order',
  templateUrl: './list-order.component.html',
  styleUrls: ['./list-order.component.scss'],
})
export class ListOrderComponent implements OnInit {
  list_order: any[] = [];
  ngOnInit() {
    this.list_order = this._itemmservise.getListOrder();
  }
  constructor(private _itemmservise: ItemService) {
    this._itemmservise.refeshData.subscribe((s)=>{
      this.list_order=this._itemmservise.getListOrder()
    })
   

  }
}
