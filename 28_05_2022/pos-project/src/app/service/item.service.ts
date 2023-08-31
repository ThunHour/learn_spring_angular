import { EventEmitter, Injectable } from '@angular/core';


@Injectable()
export class ItemService {
  refeshData=new EventEmitter()
  item=[
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
  getAllData(){
    return this.item;
  }
  getListOrder(){
    return this.list_order;
  }

  increaseItem(item:any){
      const value=this.list_order.find((l)=>l.id===item.id);
      if(value){
        let index=this.list_order.indexOf(value);
        this.list_order[index]={...item,qty:value.qty+1};
      }else{
        this.list_order.push({...item,qty:1});
      }
  }

  decreaseItem(item:any){
    console.log(item)
    const value = this.list_order.find((l) => l.id === item.id);
    let index = this.list_order.indexOf(value);
    if(this.list_order[index].qty>1){
      this.list_order[index] =
      { ...item, qty: value.qty -1};
    }

  }
  deleteItem(item:any){
    this.list_order = this.list_order.filter((e) =>
    {
      return e.title !== item.title
      })
  }

constructor() { }

}
