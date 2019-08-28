import { Component, OnInit } from '@angular/core';
import {BankingService} from '../../service/banking.service'
import {AlertService} from '../../service/alert.service'
import{Customer} from '../../model/customer'
import{Account} from '../../model/account'
import{ShowDetails} from '../../model/show-details'
import{Transaction} from '../../model/transaction'

@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.css'],
    providers: [BankingService]
})
export class ShowDetailsComponent implements OnInit {
        
    customer:Customer;
    accountList: Array<Account>;
    customerList: Array<Customer>;
    account:Account;
    transactionsList: Array<Transaction>;

  constructor(private bankingService: BankingService, private alertService: AlertService) { }

  ngOnInit() {
      this.bankingService
            .getCustomers()
            .subscribe(customerList => {
                    console.log(customerList);
                    this.customerList = customerList;
                },
                error => {
                    this.alertService.error("An error occured while fetching customer list", false);
                });
  }
    
  onSubmit(){
      this.accountList = null;
      this.transactionsList = null;
    this.bankingService
            .getAccountsForCustomer(this.customer.customerId)
            .subscribe(accountList => {
                    this.accountList = accountList;
                    console.log(this.accountList);
                },
                error => {
                    this.alertService.error("An error occured while fetching bank accounts", false);
                });
  
  }
    
  getTransactions(event:any) {
      
    this.bankingService
            .getTransactionsForAccount(this.account.accountId)
            .subscribe(transactionsList => {
                    this.transactionsList = transactionsList;
                    console.log(this.transactionsList);
                },
                error => {
                    this.alertService.error("An error occured while fetching the transactions", false);
                });
  } 

}
