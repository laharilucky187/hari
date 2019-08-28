import {Component, OnInit, ElementRef} from "@angular/core";
import {AlertService} from "../../service/alert.service";

@Component({
    selector: 'app-alert',
    templateUrl: './alert.component.html',
})
export class AlertComponent implements OnInit {
    message: any;

    constructor(private alertService: AlertService, private elementRef: ElementRef) {
    }

    ngOnInit() {
        this.alertService.getMessage().subscribe(message => {
            this.message = message;
            if(this.message != null && this.message.isFlashMessage){

                window.setTimeout(() => {
                    this.message = null;
                }, 5000);
            }
        });
    }
}
