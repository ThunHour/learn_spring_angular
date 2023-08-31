import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { faTrashCan,faCircleMinus,faCirclePlus } from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-order-item',
  templateUrl: './order-item.component.html',
  styleUrls: ['./order-item.component.scss']
})
export class OrderItemComponent implements OnInit {
  Icon = faTrashCan;
  IconMinus=faCircleMinus;
  IconPlus=faCirclePlus;
@Input() listItem:any;
@Output() CrdItem:EventEmitter<any> =new EventEmitter();
ItemOperated:any[]=[]
  constructor() { }

  ngOnInit() {
  }
  crdOperation(item:any,crdType:string){
    // this.CrdItem=new EventEmitter();
    this.ItemOperated=[]
    this.ItemOperated.push(crdType);
    this.ItemOperated.push(item);
    this.CrdItem.emit(this.ItemOperated);
  }
}
