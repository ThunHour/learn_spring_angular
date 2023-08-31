import { Component, OnInit } from '@angular/core';
import { Category } from '../model/category.model';
import {
  faPen,
  faTrashCan
  } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import { ItemService } from '../service/item.service';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {
  list_cate:Category[]=[]
  editIcon=faPen
  deleteIcon=faTrashCan
  constructor( private _route:Router,private _Itemservice:ItemService, private toastr: ToastrService,) { }
  onClickNewcategory(){
    this._route.navigate(['category/create'])
  }
  ngOnInit() {
    this.list_cate=this._Itemservice.getAllcategory()
  }

  onClickDelete(item:Category){
    if(confirm("Are you sure that you want to delete this record?")){
      this._Itemservice.deleteCategory(item).subscribe((res) => {
        if(res["resCode"]=="00") {
          this.toastr.info(`${item.name} catrgory is deleted successfully` )
          this.list_cate = this._Itemservice.getAllcategory();
        }else{
          this.toastr.error(`delete was error` )
        }
      })
    }

  }
  onClickeEdit(cate:Category){
    this._route.navigate(["category/edit/"+cate._id])
  }


}
