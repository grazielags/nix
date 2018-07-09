import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule, PreloadAllModules } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BsModalModule } from 'ng2-bs3-modal';
import {NgxPaginationModule} from 'ngx-pagination';
import { ModalModule } from 'ng2-bootstrap/ng2-bootstrap';
import { Ng2BootstrapModule } from 'ng2-bootstrap/ng2-bootstrap';
// import { jQuery } from '@types/jquery';

import {ROUTES} from './app.routes'

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { TransactionComponent } from './transactions/transaction/transaction.component';
import { TransactionDetailComponent } from './transaction-detail/transaction-detail.component';
import { MenuComponent } from './transaction-detail/menu/menu.component';
import { MenuItemComponent } from './transaction-detail/menu-item/menu-item.component';
import { ReviewsComponent } from './transaction-detail/reviews/reviews.component';

import { NotFoundComponent } from './not-found/not-found.component'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    TransactionsComponent,
    TransactionComponent,
    TransactionDetailComponent,
    MenuComponent,
    MenuItemComponent,
    ReviewsComponent,
    NotFoundComponent
   ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(ROUTES, {preloadingStrategy: PreloadAllModules}),
    NgxPaginationModule,
    BsModalModule,
    Ng2BootstrapModule,
    ModalModule.forRoot()
  ],
  providers: [{provide: LOCALE_ID, useValue: ''}],
  bootstrap: [AppComponent]
})
export class AppModule { }
