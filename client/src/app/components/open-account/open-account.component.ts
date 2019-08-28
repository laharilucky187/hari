import { Component, OnInit } from '@angular/core';
import {BankingService} from '../../service/banking.service'
import {AlertService} from '../../service/alert.service'
import{Customer} from '../../model/customer'
import{OpenAccount} from '../../model/open-account'

@Component({
  selector: 'app-open-account',
  templateUrl: './open-account.component.html',
  styleUrls: ['./open-account.component.css'],
    providers: [BankingService]
})
export class OpenAccountComponent implements OnInit {
        
    customerList: Array<Customer> = [];
    customer: Customer;
    initialAmount: number = 0; 

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
//                    this.hideLoading();
                });
  }
    
    onSubmit(){
        console.log("openAccount" +this.initialAmount);
        const openAccount : OpenAccount = new OpenAccount();
        openAccount.customerId = this.customer.customerId;
        openAccount.initialCredit = this.initialAmount;
        openAccount.accountType = "CURRENT";
        this.bankingService
            .openAccount(openAccount)
            .subscribe(customerList => {
                    this.alertService.success("Account opened successfully", true);
                },
                error => {
                    this.alertService.error("An error occured while opening account", false);
//                    this.hideLoading();
                });

    }
}
