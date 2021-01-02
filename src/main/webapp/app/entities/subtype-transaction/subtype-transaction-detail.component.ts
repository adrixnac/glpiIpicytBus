import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { SubtypeTransaction } from './subtype-transaction.model';
import { SubtypeTransactionService } from './subtype-transaction.service';

@Component({
    selector: 'jhi-subtype-transaction-detail',
    templateUrl: './subtype-transaction-detail.component.html'
})
export class SubtypeTransactionDetailComponent implements OnInit, OnDestroy {

    subtypeTransaction: SubtypeTransaction;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private subtypeTransactionService: SubtypeTransactionService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInSubtypeTransactions();
    }

    load(id) {
        this.subtypeTransactionService.find(id)
            .subscribe((subtypeTransactionResponse: HttpResponse<SubtypeTransaction>) => {
                this.subtypeTransaction = subtypeTransactionResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInSubtypeTransactions() {
        this.eventSubscriber = this.eventManager.subscribe(
            'subtypeTransactionListModification',
            (response) => this.load(this.subtypeTransaction.id)
        );
    }
}
