import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Impact } from './impact.model';
import { ImpactPopupService } from './impact-popup.service';
import { ImpactService } from './impact.service';

@Component({
    selector: 'jhi-impact-dialog',
    templateUrl: './impact-dialog.component.html'
})
export class ImpactDialogComponent implements OnInit {

    impact: Impact;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private impactService: ImpactService,
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
        if (this.impact.id !== undefined) {
            this.subscribeToSaveResponse(
                this.impactService.update(this.impact));
        } else {
            this.subscribeToSaveResponse(
                this.impactService.create(this.impact));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<Impact>>) {
        result.subscribe((res: HttpResponse<Impact>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: Impact) {
        this.eventManager.broadcast({ name: 'impactListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-impact-popup',
    template: ''
})
export class ImpactPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private impactPopupService: ImpactPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.impactPopupService
                    .open(ImpactDialogComponent as Component, params['id']);
            } else {
                this.impactPopupService
                    .open(ImpactDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
