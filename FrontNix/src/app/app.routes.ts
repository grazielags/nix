import {Routes} from '@angular/router'

import {HomeComponent} from './home/home.component'
import {TransactionsComponent} from './transactions/transactions.component'
import {NotFoundComponent} from './not-found/not-found.component'

export const ROUTES: Routes = [
  {path: '', component: HomeComponent},
  {path: 'transactions', component: TransactionsComponent},
  {path: '**', component: NotFoundComponent}
]
