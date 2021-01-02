import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { SubtypeTransaction } from './subtype-transaction.model';
import { SubtypeTransactionService } from './subtype-transaction.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-subtype-transaction',
    templateUrl: './subtype-transaction.component.html'
})
export class SubtypeTransactionComponent implements OnInit, OnDestroy {
subtypeTransactions: SubtypeTransaction[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private subtypeTransactionService: SubtypeTransactionService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.subtypeTransactionService.query().subscribe(
            (res: HttpResponse<SubtypeTransaction[]>) => {
                this.subtypeTransactions = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInSubtypeTransactions();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: SubtypeTransaction) {
        return item.id;
    }
    registerChangeInSubtypeTransactions() {
        this.eventSubscriber = this.eventManager.subscribe('subtypeTransactionListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
