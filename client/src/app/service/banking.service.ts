import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import{Customer} from '../model/customer'
import{Transaction} from '../model/transaction'
import{Account} from '../model/account'
import{OpenAccount} from '../model/open-account'
import { Observable } from "rxjs";

@Injectable()
export class BankingService {
        
    private customerUrl = '/bank-application/api/v1/banking/customers/';
    private accountsUrl = '/bank-application/api/v1/banking/accounts/';
    private transactionsUrl = '/bank-application/api/v1/banking/transactions/';

  constructor(private http: HttpClient){ }
    
    getCustomers():  Observable<Customer[]> {
        return this.http.get<Customer[]>(this.customerUrl,{ 
        });
    }
    
    openAccount(openAccount: OpenAccount){
        
        return this.http.post(this.accountsUrl+"account:open", openAccount, {
        });
    }
    
    getAccountsForCustomer(customerId: number):  Observable<Account[]> {
        return this.http.get<Account[]>(this.accountsUrl+"?customerId="+customerId,{ 
        });
    }
    
    getTransactionsForAccount(accountId: number):  Observable<Transaction[]> {
        return this.http.get<Transaction[]>(this.transactionsUrl+"?accountId="+accountId,{ 
        });
    }
}
