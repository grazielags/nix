import {Routes} from '@angular/router'

import {HomeComponent} from './home/home.component'
import {TransactionsComponent} from './transactions/transactions.component'
import {TransactionDetailComponent} from './transaction-detail/transaction-detail.component'
import {MenuComponent} from './transaction-detail/menu/menu.component'
import {ReviewsComponent} from './transaction-detail/reviews/reviews.component'
import {NotFoundComponent} from './not-found/not-found.component'

export const ROUTES: Routes = [
  {path: '', component: HomeComponent},
  {path: 'transactions', component: TransactionsComponent},
  {path: 'transaction', component: TransactionDetailComponent},
  {path: 'transaction/:id', component: TransactionDetailComponent,
    children: [
      {path: '', redirectTo: 'menu', pathMatch: 'full'},
      {path: 'menu', component: MenuComponent},
      {path: 'reviews', component: ReviewsComponent}
    ]
  },
  {path: '**', component: NotFoundComponent}
]
