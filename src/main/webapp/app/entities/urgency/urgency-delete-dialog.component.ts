import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Urgency } from './urgency.model';
import { UrgencyPopupService } from './urgency-popup.service';
import { UrgencyService } from './urgency.service';

@Component({
    selector: 'jhi-urgency-delete-dialog',
    templateUrl: './urgency-delete-dialog.component.html'
})
export class UrgencyDeleteDialogComponent {

    urgency: Urgency;

    constructor(
        private urgencyService: UrgencyService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.urgencyService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'urgencyListModification',
                content: 'Deleted an urgency'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-urgency-delete-popup',
    template: ''
})
export class UrgencyDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private urgencyPopupService: UrgencyPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.urgencyPopupService
                .open(UrgencyDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
