import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Urgency } from './urgency.model';
import { UrgencyPopupService } from './urgency-popup.service';
import { UrgencyService } from './urgency.service';

@Component({
    selector: 'jhi-urgency-dialog',
    templateUrl: './urgency-dialog.component.html'
})
export class UrgencyDialogComponent implements OnInit {

    urgency: Urgency;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private urgencyService: UrgencyService,
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
        if (this.urgency.id !== undefined) {
            this.subscribeToSaveResponse(
                this.urgencyService.update(this.urgency));
        } else {
            this.subscribeToSaveResponse(
                this.urgencyService.create(this.urgency));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<Urgency>>) {
        result.subscribe((res: HttpResponse<Urgency>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: Urgency) {
        this.eventManager.broadcast({ name: 'urgencyListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-urgency-popup',
    template: ''
})
export class UrgencyPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private urgencyPopupService: UrgencyPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.urgencyPopupService
                    .open(UrgencyDialogComponent as Component, params['id']);
            } else {
                this.urgencyPopupService
                    .open(UrgencyDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
