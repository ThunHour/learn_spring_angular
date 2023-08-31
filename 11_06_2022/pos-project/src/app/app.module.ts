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
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './service/auth.guard';
import { AuthService } from './service/auth.service';
import { NgxSkeletonLoaderModule } from 'ngx-skeleton-loader';

const appRoute:Routes = [
  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  { path: 'sale',canActivate:[AuthGuard] ,component: ContentComponent },
  { path: 'item',canActivate:[AuthGuard], component: BoListComponent },
  { path: 'item/create',canActivate:[AuthGuard],component: ItemFormReactiveComponent },
  {path:'item/edit/:id',canActivate:[AuthGuard],component:ItemFormReactiveComponent},
  { path: 'category',canActivate:[AuthGuard], component: CategoryComponent },
  { path: 'category/create',canActivate:[AuthGuard], component: CategoryFormComponent },
  { path: 'category/edit/:id',canActivate:[AuthGuard], component: CategoryFormComponent },
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
      LoginComponent
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
    NgxSkeletonLoaderModule

  ],
  providers: [ItemService,AuthGuard,AuthService],
  bootstrap: [AppComponent],
})
export class AppModule {}
