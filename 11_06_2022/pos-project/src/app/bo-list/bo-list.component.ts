import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ItemModel } from '../model/item.model';
import { ItemService } from '../service/item.service';
import {
faPen,
faTrashCan
} from '@fortawesome/free-solid-svg-icons';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-bo-list',
  templateUrl: './bo-list.component.html',
  styleUrls: ['./bo-list.component.scss'],
})
export class BoListComponent implements OnInit {
  loader=true;
  totalCount="10"
  constructor(private _itemServe: ItemService,private _route:Router, private toastr: ToastrService,) {}

  listItem: ItemModel[] = [];
  editIcon=faPen
  deleteIcon=faTrashCan
  ngOnInit() {
    this.listItem = this._itemServe.getAllData();
    this.CatDictionary=this._itemServe.getDictionaryCate()


  }
  switch(){
    if(this.listItem.length>0){
      this.loader=false 
    }
   
  }
  onClickNewItem(){
  this._route.navigate(['item/create'])
  }
  onClickDelete(item:ItemModel){
    if(confirm("Are you sure that you want to delete this record?")){
      this._itemServe.deleteItem(item).subscribe((res) => {
        if(res["resCode"]=="00") {
          this.toastr.info(`${item} is  deleted successfully`)

          this.ngOnInit()
        }
      })
    }

  }
  editItem(item:ItemModel){
    this._route.navigate(["item/edit/"+item._id])


  }
  CatDictionary:any
  getCategory(cate:string){
    return this.CatDictionary.get(cate)
  }
}
