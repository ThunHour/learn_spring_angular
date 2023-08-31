import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss'],
})
export class ItemComponent implements OnInit {
  @Input() item: any;
  constructor(private itemservice : ItemService) {}

  addToOrder(item:any){
    this.itemservice.increaseItem(item)
  }
  ngOnInit( ) {}
}
