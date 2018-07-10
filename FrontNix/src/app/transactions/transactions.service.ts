import {Injectable} from '@angular/core'
import {Http, Headers, RequestOptions} from '@angular/http';

import {Observable} from 'rxjs/Observable'
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

import {Transferencia} from "./transaction/transaction.model"

import {NIX_API} from '../app.api'
import {ErrorHandler} from '../app.error-handler'

const httpOptions = {
  headers: new Headers({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable()
export class TransactionsService {

    constructor(private http: Http){}

    transactions(): Observable<Transferencia[]> {
      return this.http.get(`${NIX_API}/transferencias`)
        .map(response => response.json())
        .catch(ErrorHandler.handleError)
    }

    transactionById(id: number): Observable<Transferencia>{
      return this.http.get(`${NIX_API}/transferencias/${id}`)
        .map(response => response.json())
        .catch(ErrorHandler.handleError)
    }

    reviewsOfTransaction(id: string): Observable<any>{
      return this.http.get(`${NIX_API}/transferencias/${id}/reviews`)
        .map(response => response.json())
        .catch(ErrorHandler.handleError)
    }

    saveEdit(transferencia: Transferencia): Observable<any>{
      return this.http.put(`${NIX_API}/transferencias/${transferencia.id}`, transferencia, {
        params: {
          token: '',
          id: transferencia.id
        }
      })
        .map(response => response.json())
        .catch(ErrorHandler.handleError)
    }

    save(transferencia: Transferencia): Observable<any>{
      return this.http.post(`${NIX_API}/transferencias`, transferencia, {
        params: {
          token: ''
        }
      })
        .map(response => response.json())
        .catch(ErrorHandler.handleError)
    }

    remove(transferencia: Transferencia): Observable<any>{
      return this.http.delete(`${NIX_API}/transferencias/${transferencia.id}`, {
        params: {
          token: '',
          id: transferencia.id
        }
      })
        .catch(ErrorHandler.handleError)
    }

}
