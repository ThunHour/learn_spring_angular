import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { EventEmitter, Injectable, OnInit } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Category } from '../model/category.model';
import { ItemModel } from '../model/item.model';

@Injectable()
export class ItemService implements OnInit {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
    body: null,
    params: null,
  };
  editCate(id:string,cate:Category):Observable<any>{
    return this.http.post("https://api.buzsic.com/tgipos/v2/category/update?id="+id,cate)
  }
  editItem(id:string,item:ItemModel):Observable<any>{
    let param= new HttpParams()
    param=param.append("id",id)

    let   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
    body: null,
    params: param,
  };
  return this.http.post("https://api.buzsic.com/tgipos/v2/item/update",item,httpOptions)


  }
  getById(id:string):ItemModel|undefined{
    return this.mainList.find((d)=> d._id===id)
  }

  createCategory(cate:any): Observable<any>{
    return this.http.post("https://api.buzsic.com/tgipos/v2/category/create",cate)
  }
  deleteCategory(cate:Category): Observable<any>{
    return this.http.post("https://api.buzsic.com/tgipos/v2/category/delete?id="+cate._id,cate)
  }
  refeshData = new EventEmitter();
  Listitem: ItemModel[] = [];
  list_order: any[] = [];
  listCategory:Category[]=[]
  mainList:ItemModel[] = [];
  resetOrderList(){
    this.list_order=[]
  }

  getDictionaryCate(){

    var map = new Map<string, string>();
    this.listCategory.forEach(function (value) {
    map.set(value._id,value.name);
    });
    return map
  }
  displayAll(){
    return this.mainList
  }
  displayByCateory(catId:Category){
    return this.mainList.filter((e)=>{
      if(e.cate_id==catId._id){
        return e
      }
      return
    })
  }
  getAllData() {
    this.Listitem=[]
    this.http
    .get('https://api.buzsic.com/tgipos/v2/item?')
    .toPromise()
    .then((res: any) => {
      res.data.rows.forEach((r : ItemModel)=>{
        this.Listitem.push(r)
        this.mainList.push(r)
      });
    });
    return this.Listitem
  }
  getListOrder() {
    return this.list_order;
  }
  createItem(item:ItemModel): Observable<any>{
    return this.http.post("https://api.buzsic.com/tgipos/v2/item/create",item)
  }

  deleteItem(item:ItemModel): Observable<any>{
    return this.http.post("https://api.buzsic.com/tgipos/v2/item/delete?id="+item._id,item)
  }

  increaseItem(item: any) {
    const value = this.list_order.find((l) => l._id === item._id);
    if (value) {
      let index = this.list_order.indexOf(value);
      this.list_order[index] = { ...item, qty: value.qty + 1 };
    } else {
      this.list_order.push({ ...item, qty: 1 });
    }
  }
  getAllcategory(){
    this.listCategory=[]
    this.http
    .get('https://api.buzsic.com/tgipos/v2/category')
    .toPromise()
    .then((res: any) => {
      res.data.rows.forEach((r : Category)=>{
        this.listCategory.push(r)
      });
    });
    return this.listCategory
  }

  decreaseItem(item: any) {
    console.log(item);
    const value = this.list_order.find((l) => l._id === item._id);
    let index = this.list_order.indexOf(value);
    if (this.list_order[index].qty > 1) {
      this.list_order[index] = { ...item, qty: value.qty - 1 };
    }
  }
  deleteItemOrder(item: any) {
    this.list_order = this.list_order.filter((e) => {
      return e.title !== item.title;
    });
  }
  getCateById(id:string):Category|undefined{
    return this.listCategory.find((d)=> d._id===id)
  }

  constructor(private http: HttpClient) {}
  ngOnInit(): void {

  }
}
