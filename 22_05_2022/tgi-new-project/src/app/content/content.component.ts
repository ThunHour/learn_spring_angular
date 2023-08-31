import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.scss']
})
export class ContentComponent{
  public item=[
    {
      id:'1',
      pic:'assets/image/delish-homemade-pizza-horizontal-1542312378.png',
      title:'Pizza' ,
      price:12.0
    },
    {
      id:'2',
      pic:'assets/image/download.jpg',
      title:'Burger' ,
      price:3.0
    },
    {
      id:'3',
      pic:'assets/image/download (1).jpg',
      title:'Sandwich' ,
      price:1.0
    },

  ]
  list_order:any[]=[];
  exchange(item:any[]){
    this.list_order=[];
    this.list_order=item;

  }
  onClickItem(item:any){
    const value=this.list_order.find((l)=>l.id===item.id);
    if(value){
      let index=this.list_order.indexOf(value);
      this.list_order[index]={...item,qty:value.qty+1};
    }else{
      this.list_order.push({...item,qty:1});
    }

  }
}
