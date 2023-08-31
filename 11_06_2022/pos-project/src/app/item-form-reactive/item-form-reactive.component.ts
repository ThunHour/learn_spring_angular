import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from '../model/category.model';
import { ItemService } from '../service/item.service';
import { ActivatedRoute } from "@angular/router";
@Component({
  selector: 'app-item-form-reactive',
  templateUrl: './item-form-reactive.component.html',
  styleUrls: ['./item-form-reactive.component.scss'],
})
export class ItemFormReactiveComponent implements OnInit {
  pform: FormGroup;
  constructor(
    private toastr: ToastrService,
    private _route: Router,
    private _itemService: ItemService,
    private formbuilder: FormBuilder,
    private route: ActivatedRoute
  ) {
    this.pform = this.formbuilder.group({
      title: new FormControl('', Validators.required),
      pic: new FormControl('', Validators.required),
      cate_id:new FormControl('',),
      price: new FormControl('', Validators.required),
    });
  }
  ngOnInit() {
    if(this.route.snapshot.params['id']){
      const  item=this._itemService.getById(this.route.snapshot.params['id']);
      if(item!==undefined){
       this.pform.patchValue({
        title:item.title,
        pic:item.pic,
        cate_id:item.cate_id,
        price:item.price,
       })
      }

    }
    this.categoryList=this._itemService.getAllcategory()
  }
  goBack() {
    this._route.navigate(['item'])
  }
  addItem(){
    let nameEdit=this.pform.value.title
    if(this.route.snapshot.params['id']){
      this._itemService.editItem(this.route.snapshot.params['id'],this.pform.value).subscribe((res)=>{
        if(res["resCode"]=="00"){
          this.toastr.success(`${nameEdit} is update successfully`)
        }
        this.goBack()
      })
    }else{
      var name=this.pform.value.title
      this._itemService.createItem(this.pform.value).subscribe((res)=>{
       if(res["resCode"]=="00") {
         this.toastr.success(`${name}} is add successfully`)
       }else{
         this.toastr.error(res.data[0])
       }
       this.goBack()
      })
      this.pform = this.formbuilder.group({
       title: new FormControl('', Validators.required),
       pic: new FormControl('', Validators.required),
       cate_id:new FormControl('',),
       price: new FormControl('', Validators.required),
     });
    }
  }
  categoryList:Category[]=[]
  categorySelected?:string="";
  changeCategory(c:any){
    this.categorySelected=c.target.value;
  }
}
