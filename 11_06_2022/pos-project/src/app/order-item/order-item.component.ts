import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {
  faTrashCan,
  faCircleMinus,
  faCirclePlus,
} from '@fortawesome/free-solid-svg-icons';
import { ItemModel } from '../model/item.model';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-order-item',
  templateUrl: './order-item.component.html',
  styleUrls: ['./order-item.component.scss'],
})
export class OrderItemComponent implements OnInit {
  Icon = faTrashCan;
  IconMinus = faCircleMinus;
  IconPlus = faCirclePlus;
  ngOnInit() {}
  @Input() Item: any;
  constructor(private _itemservice: ItemService) {}
  increase(item: ItemModel) {
    this._itemservice.increaseItem(item);
  }
  decrease(item: ItemModel) {
    this._itemservice.decreaseItem(item);
  }
  deleteItem(item: ItemModel){
    this._itemservice.deleteItemOrder(item)
    this._itemservice.refeshData.emit();
  }

}
