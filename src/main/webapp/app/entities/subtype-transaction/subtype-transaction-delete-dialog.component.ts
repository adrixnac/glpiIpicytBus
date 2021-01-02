import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { SubtypeTransaction } from './subtype-transaction.model';
import { SubtypeTransactionPopupService } from './subtype-transaction-popup.service';
import { SubtypeTransactionService } from './subtype-transaction.service';

@Component({
    selector: 'jhi-subtype-transaction-delete-dialog',
    templateUrl: './subtype-transaction-delete-dialog.component.html'
})
export class SubtypeTransactionDeleteDialogComponent {

    subtypeTransaction: SubtypeTransaction;

    constructor(
        private subtypeTransactionService: SubtypeTransactionService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.subtypeTransactionService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'subtypeTransactionListModification',
                content: 'Deleted an subtypeTransaction'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-subtype-transaction-delete-popup',
    template: ''
})
export class SubtypeTransactionDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private subtypeTransactionPopupService: SubtypeTransactionPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.subtypeTransactionPopupService
                .open(SubtypeTransactionDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
