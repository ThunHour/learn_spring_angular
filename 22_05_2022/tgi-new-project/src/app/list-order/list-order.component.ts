import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-list-order',
  templateUrl: './list-order.component.html',
  styleUrls: ['./list-order.component.scss'],
})
export class ListOrderComponent {
  @Input() selectItem: any[] = [];
  @Output() crdList = new EventEmitter();
  tmep_list: any[] = [];

  crdOperation(item: any[]) {
    this.tmep_list = this.selectItem;
    if (item[0] == 'delete') {
      this.tmep_list = this.tmep_list.filter((e) => {
        return e.title !== item[1].title;
      });
    } else if (item[0] == 'increase') {
      const value = this.tmep_list.find((l) => l.id === item[1].id);
      let index = this.tmep_list.indexOf(value);
      this.tmep_list[index] =
      { ...item[1], qty: value.qty + 1};
    } else if (item[0] == 'decrease') {
      const value = this.tmep_list.find((l) => l.id === item[1].id);
      let index = this.tmep_list.indexOf(value);
      if(this.tmep_list[index].qty>1){

        this.tmep_list[index] =
        { ...item[1], qty: value.qty -1};
      }
      else if(this.tmep_list[index].qty==1){
        this.tmep_list = this.tmep_list.filter((e) => {
          return e.title !== item[1].title;
        });
      }

    }
    this.crdList.emit(this.tmep_list);
  }
}
