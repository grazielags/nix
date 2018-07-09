import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import {TransactionsService} from '../../transactions/transactions.service'
import {MenuItem} from '../menu-item/menu-item.model'

import {Observable} from 'rxjs/Observable'


@Component({
  selector: 'nix-menu',
  templateUrl: './menu.component.html'
})
export class MenuComponent implements OnInit {

  menu: Observable<MenuItem[]>

  constructor(private transactionsService: TransactionsService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    //this.menu = this.transactionsService
    //  .menuOfTransaction(this.route.parent.snapshot.params['id'])
  }

  addMenuItem(item: MenuItem){
    console.log(item)
  }
}
