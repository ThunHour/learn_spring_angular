import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Category } from '../model/category.model';
import { ItemModel } from '../model/item.model';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-list-item',
  templateUrl: './list-item.component.html',
  styleUrls: ['./list-item.component.scss']
})
export class ListItemComponent implements OnInit {
  listItem:ItemModel[]=[]
  constructor(private _itemservice:ItemService) { }

  ngOnInit() {
    this.listItem=this._itemservice.getAllData()
    this.cateList=this._itemservice.getAllcategory()
  }
  displayByCate(cate:Category){
    this.listItem=this._itemservice.displayByCateory(cate)

  }
  displayAll(){
    this.listItem=this._itemservice.displayAll()
  }
   cateList:Category[]=[]
}
