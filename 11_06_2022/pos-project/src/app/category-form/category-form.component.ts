import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Category } from '../model/category.model';
import { ItemService } from '../service/item.service';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.scss'],
})
export class CategoryFormComponent implements OnInit {
  pform: FormGroup;
  constructor(
    private _route: Router,
    private _itemService: ItemService,
    private formbuilder: FormBuilder,
    private toastr: ToastrService,
    private routeX: ActivatedRoute
  ) {
    this.pform = this.formbuilder.group({
      name: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
    });
  }
  ngOnInit() {
    if (this.routeX.snapshot.params['id']) {
      const item = this._itemService.getCateById(
        this.routeX.snapshot.params['id']
      );
      if (item !== undefined) {
        this.pform.patchValue({
          name: item.name,
          description: item.description,
        });
      }
    }
  }
  goBack() {
    this._route.navigate(['category']);
  }

  addItem() {
    var name = this.pform.value.name;
    if (this.routeX.snapshot.params['id']) {
      this._itemService
        .editCate(this.routeX.snapshot.params['id'], this.pform.value)
        .subscribe((res) => {
          if (res['resCode'] == '00') {
            this.toastr.success(`${name} catrgory is update successfully`);
            this.goBack();
          } else {
            this.toastr.error('update is not successfully');
          }
        });
    } else {
      this._itemService.createCategory(this.pform.value).subscribe((res) => {
        if (res['resCode'] == '00') {
          this.toastr.success(`${name} catrgory is add successfully`);
          this.goBack();
        }
      });
    }
    this._itemService.getAllcategory();
    this.pform = this.formbuilder.group({
      name: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
    });
  }
}
