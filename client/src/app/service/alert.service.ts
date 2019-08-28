import {Injectable} from "@angular/core";
import {NavigationStart, Router} from "@angular/router";
import {Observable, Subject} from "rxjs";


@Injectable()
export class AlertService {
    private subject = new Subject<any>();
    private keepAfterNavigationChange = false;

    constructor(private router: Router) {
        // clear alert message on route change
        router.events.subscribe(event => {
            if (event instanceof NavigationStart) {
                if (this.keepAfterNavigationChange) {
                    // only keep for a single location change
                    this.keepAfterNavigationChange = false;
                } else {
                    // clear alert
                    this.subject.next();
                }
            }
        });
    }

    success(message: string, isFlashMessage: boolean) {
        this.keepAfterNavigationChange = false;
        this.subject.next({type: 'success', text: message, isFlashMessage: isFlashMessage});
    }

    error(message: string, isFlashMessage: boolean) {
        this.keepAfterNavigationChange = false;
        this.subject.next({type: 'error', text: message, isFlashMessage: isFlashMessage});
    }

    warning(message: string, isFlashMessage: boolean) {
        this.keepAfterNavigationChange = false;
        this.subject.next({type: 'warning', text: message, isFlashMessage: isFlashMessage});
    }

    getMessage(): Observable<any> {
        return this.subject.asObservable();
    }
}
