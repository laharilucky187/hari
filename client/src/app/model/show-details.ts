import {Account} from './account';
import {Transaction} from './transaction';

export class ShowDetails {
    
    customerId:number;
    firstName:string;
    lastName:string;
    accounts: Account[];
    amount:number;
    balance:number;
    date:string;
    transactionMap:Map<any, any> = new Map();
}
