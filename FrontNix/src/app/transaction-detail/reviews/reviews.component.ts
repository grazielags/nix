import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import {TransactionsService} from '../../transactions/transactions.service'

import {Observable} from 'rxjs/Observable'

@Component({
  selector: 'nix-reviews',
  templateUrl: './reviews.component.html'
})
export class ReviewsComponent implements OnInit {

  reviews: Observable<any>

  constructor(private transactionsService: TransactionsService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.reviews = this.transactionsService
      .reviewsOfTransaction(this.route.parent.snapshot.params['id'])
  }

}