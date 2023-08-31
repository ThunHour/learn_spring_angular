import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ItemModel } from '../model/item.model';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-list-order',
  templateUrl: './list-order.component.html',
  styleUrls: ['./list-order.component.scss'],
})
export class ListOrderComponent implements OnInit {
  list_order: ItemModel[] = [];
  ngOnInit() {
    this.list_order = this._itemmservise.getListOrder();
  }
  constructor(private _itemmservise: ItemService) {
    this._itemmservise.refeshData.subscribe((s)=>{
      this.list_order=this._itemmservise.getListOrder()
    })
  }
  getTotal(){
    var x=0
    this.list_order.forEach((e)=>{
      x+=(e.qty*e.price)
    })
    return x

  }
  buyItem(){
    location.reload()
    this.list_order=this._itemmservise.getListOrder()
  }
}
