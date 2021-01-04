import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SubtypeTransaction } from './subtype-transaction.model';
import { SubtypeTransactionPopupService } from './subtype-transaction-popup.service';
import { SubtypeTransactionService } from './subtype-transaction.service';

@Component({
    selector: 'jhi-subtype-transaction-dialog',
    templateUrl: './subtype-transaction-dialog.component.html'
})
export class SubtypeTransactionDialogComponent implements OnInit {

    subtypeTransaction: SubtypeTransaction;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private subtypeTransactionService: SubtypeTransactionService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.subtypeTransaction.id !== undefined) {
            this.subscribeToSaveResponse(
                this.subtypeTransactionService.update(this.subtypeTransaction));
        } else {
            this.subscribeToSaveResponse(
                this.subtypeTransactionService.create(this.subtypeTransaction));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<SubtypeTransaction>>) {
        result.subscribe((res: HttpResponse<SubtypeTransaction>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: SubtypeTransaction) {
        this.eventManager.broadcast({ name: 'subtypeTransactionListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-subtype-transaction-popup',
    template: ''
})
export class SubtypeTransactionPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private subtypeTransactionPopupService: SubtypeTransactionPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.subtypeTransactionPopupService
                    .open(SubtypeTransactionDialogComponent as Component, params['id']);
            } else {
                this.subtypeTransactionPopupService
                    .open(SubtypeTransactionDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
