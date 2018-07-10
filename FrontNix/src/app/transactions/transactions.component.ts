import { MyCurrencyPipe } from './../my-currency.pipe';
import { MyCurrencyFormatterDirective } from './../my-currency-formatter.directive';
import { Component, Input, Output, OnInit, ViewContainerRef, EventEmitter, ViewChild,
  trigger,
  state,
  style,
  animate,
  transition  } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms'

import {Transferencia} from './transaction/transaction.model'
import {TransactionsService} from './transactions.service'
import { ModalDirective } from 'ng2-bootstrap';

import 'rxjs/add/operator/switchMap'
import 'rxjs/add/operator/do'
import 'rxjs/add/operator/debounceTime'
import 'rxjs/add/operator/distinctUntilChanged'
import 'rxjs/add/operator/catch'
import 'rxjs/add/observable/from'
import {Observable} from 'rxjs/Observable'

@Component({
  selector: 'nix-transactions',
  styles: [
    `.ng-valid[required] {
        border-left: 5px solid #5cb85c; /* green */
    }`,
    `.ng-invalid:not(.ng-untouched):not(form) {
        border-left: 5px solid #d9534f; /* red */
    }`,
    `.red-text {
        color: #d9534f !important; /* red */
    }`
  ],
  providers: [TransactionsService, FormBuilder, MyCurrencyPipe],
  templateUrl: './transactions.component.html',
  animations: [
    trigger('flyInOut', [
        state('in', style({ opacity: 1, transform: 'translateX(0)' })),
        transition('void => *', [
            style({
                opacity: 0,
                transform: 'translateX(-100%)'
            }),
            animate('0.5s ease-in')
        ]),
        transition('* => void', [
            animate('0.2s 10 ease-out', style({
                opacity: 0,
                transform: 'translateX(100%)'
            }))
        ])
    ])
  ]
})
export class TransactionsComponent implements OnInit {
  @ViewChild('childModal') public childModal: ModalDirective;
  transferencia: Transferencia;
  @Output() removeTransferencia = new EventEmitter();
  @Output() transferenciaCreated = new EventEmitter();
  transferencias: Transferencia[]
  transferenciasPagina: Transferencia[]
  page: number;
  qtdForPage: number;
  qtdTransactions: number;
  isEdit: boolean;
  searchText: string = "";

  index: number = 0;
  @ViewChild('modal')
  modal: any;
  items: string[] = ['item1', 'item2', 'item3'];
  selected: string;
  output: string;
  selectedTransferenciaId: number;
  selectedTransferenciaLoaded: boolean = false;
  backdropOptions = [true, false, 'static'];
  animation: boolean = true;
  keyboard: boolean = true;
  backdrop: string | boolean = true;
  valorTotalPagina: number = 0;

  constructor(private transactionsService: TransactionsService,
              private fb: FormBuilder) {}

  viewTransferenciaEdit(transferencia: Transferencia) {
    this.selectedTransferenciaLoaded = true;
    this.transferencia = JSON.parse(JSON.stringify(transferencia));
    if(transferencia == null) {
      this.transferencia = new Transferencia();
    } else {
      this.selectedTransferenciaId = transferencia.id;
      this.transferencia.valorFormatado = new MyCurrencyPipe().transform(this.transferencia.valor);
    }
    this.isEdit = true;
    this.childModal.show();
  }
  viewTransferenciaDetails(transferencia: Transferencia) {
    this.selectedTransferenciaLoaded = true;
    this.transferencia = transferencia;
    this.selectedTransferenciaId = transferencia.id;
    this.isEdit = false;
    this.childModal.show();
  }
  save() {
    this.transferencia.valor = parseFloat(this.transferencia.valorFormatado);
    if(this.transferencia.id == null) {
      this.transactionsService.save(this.transferencia)
        .subscribe(
          transferencia => {
            this.transferencia = transferencia;
            this.listTransferencia();
            this.childModal.hide();
          });
    } else {
      this.transactionsService.saveEdit(this.transferencia)
        .subscribe(
          transferencia => {
            this.transferencia = transferencia;
            this.listTransferencia();
            this.childModal.hide();
          });
    }
  }
  cancel() {
    this.childModal.hide();
  }
  remove(transferencia: Transferencia) {
    this.transactionsService.remove(transferencia)
    .subscribe(transferencia => this.listTransferencia());
  }

  public hideChildModal(): void {
    this.childModal.hide();
  }

  ngOnInit() {
    this.qtdForPage = 10;
    this.page = 0;
    this.listTransferencia();
  }

  listTransferencia() {
    this.transferenciasPagina = [];
    this.valorTotalPagina = 0;
    this.transactionsService.transactions()
      .subscribe(
        transferencias => {
          this.transferencias = transferencias
          this.qtdTransactions = 0;
          if(this.transferencias != null) {
            this.qtdTransactions = this.transferencias.length;
          }
          this.fillTransaction();
        });
  }

  paginar($event: any) {
    this.page = $event - 1;
    this.fillTransaction();
  }

  fillTransaction() {
    for(let i = (this.page * this.qtdForPage); i< (this.page * this.qtdForPage + this.qtdForPage); i++) {
      if(i >= this.qtdTransactions) {
        break;
      }
      if(this.qtdTransactions > 0) {
        this.valorTotalPagina = this.valorTotalPagina + this.transferencias[i].valor;
        this.transferenciasPagina.push(this.transferencias[i]);
      }
    }
  }

}