import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Urgency } from './urgency.model';
import { UrgencyService } from './urgency.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-urgency',
    templateUrl: './urgency.component.html'
})
export class UrgencyComponent implements OnInit, OnDestroy {
urgencies: Urgency[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private urgencyService: UrgencyService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.urgencyService.query().subscribe(
            (res: HttpResponse<Urgency[]>) => {
                this.urgencies = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInUrgencies();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: Urgency) {
        return item.id;
    }
    registerChangeInUrgencies() {
        this.eventSubscriber = this.eventManager.subscribe('urgencyListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
