import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header/header.component';
import { ContentComponent } from './content/content.component';
import { ListItemComponent } from './list-item/list-item.component';
import { ItemComponent } from './item/item.component';
import { ListOrderComponent } from './list-order/list-order.component';
import { OrderItemComponent } from './order-item/order-item.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ItemService } from './service/item.service';
import { BoListComponent } from './bo-list/bo-list.component';
import { ItemFormReactiveComponent } from './item-form-reactive/item-form-reactive.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import {HttpClientModule} from '@angular/common/http'
import { CategoryComponent } from './category/category.component';
import { CategoryFormComponent } from './category-form/category-form.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import {MatDialogModule} from '@angular/material/dialog';
const appRoute:Routes = [
  { path: '', component: ContentComponent },
  { path: 'item', component: BoListComponent },
  { path: 'item/create', component: ItemFormReactiveComponent },
  {path:'ng :id',component:ItemFormReactiveComponent},
  { path: 'category', component: CategoryComponent },
  { path: 'category/create', component: CategoryFormComponent },
  { path: 'category/edit/:id', component: CategoryFormComponent },
];
@NgModule({
  declarations: [

    AppComponent,
    HeaderComponent,
    ContentComponent,
    ListItemComponent,
    ItemComponent,
    ListOrderComponent,
    OrderItemComponent,
    BoListComponent,
    ItemFormReactiveComponent,
      CategoryComponent,
      CategoryFormComponent,

   ],
  imports: [
    MatDialogModule,
    CommonModule,
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    FontAwesomeModule,
    FormsModule,
    ToastrModule.forRoot(),
    ReactiveFormsModule,
    RouterModule.forRoot(appRoute),
    MatInputModule,
    HttpClientModule,

  ],
  providers: [ItemService,],
  bootstrap: [AppComponent],
})
export class AppModule {}
