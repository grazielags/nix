import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import { BsModalComponent } from 'ng2-bs3-modal';

import {TransactionsService} from '../transactions/transactions.service'

import {Transferencia} from '../transactions/transaction/transaction.model'

@Component({
  selector: 'nix-transaction-detail',
  styles: ['>>> .modal-xl { width: 1100px; }'],
  templateUrl: './transaction-detail.component.html'
})
export class TransactionDetailComponent implements OnInit {

  transferencia: Transferencia

  constructor(private transactionsService: TransactionsService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    if(this.route.snapshot.params['id'] != null) {
      this.transactionsService.transactionById(this.route.snapshot.params['id'])
                  .subscribe(transferencia => this.transferencia = transferencia)
    }
  }

}
