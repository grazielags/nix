import { Component, OnInit, Input } from '@angular/core';

import {Transferencia} from './transaction.model'

@Component({
  selector: 'nix-transaction',
  templateUrl: './transaction.component.html'
})
export class TransactionComponent implements OnInit {

  transactionState = 'ready'

  @Input() transferencia: Transferencia

  constructor() { }

  ngOnInit() {
  }

}
