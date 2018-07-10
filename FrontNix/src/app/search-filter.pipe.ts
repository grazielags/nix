import { Pipe, PipeTransform } from '@angular/core';

import {Transferencia} from './transactions/transaction/transaction.model';
import * as moment from 'moment';

@Pipe({
  name: 'searchFilter'
})
export class SearchFilterPipe implements PipeTransform {
  transform(items: any[], filter: any): any[] {
    if (!items || !filter) {
      return items;
    }
    return items.filter((item: any) => this.applyFilter(item, filter));
  }

  applyFilter(transferencia: Transferencia, filter: any): boolean {
      if (filter) {
        var searchText = filter;
        var search = new RegExp(searchText, 'i');
        return !searchText || search.test(transferencia.beneficiarioNome)
        || search.test(transferencia.pagadorNome)
        || search.test(moment(transferencia.dataCriacao).format("DD/MM/YYYY HH:mm"));
    }
    return true;
  }
}
