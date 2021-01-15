import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Priority } from './priority.model';
import { PriorityPopupService } from './priority-popup.service';
import { PriorityService } from './priority.service';

@Component({
    selector: 'jhi-priority-dialog',
    templateUrl: './priority-dialog.component.html'
})
export class PriorityDialogComponent implements OnInit {

    priority: Priority;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private priorityService: PriorityService,
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
        if (this.priority.id !== undefined) {
            this.subscribeToSaveResponse(
                this.priorityService.update(this.priority));
        } else {
            this.subscribeToSaveResponse(
                this.priorityService.create(this.priority));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<Priority>>) {
        result.subscribe((res: HttpResponse<Priority>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: Priority) {
        this.eventManager.broadcast({ name: 'priorityListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-priority-popup',
    template: ''
})
export class PriorityPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private priorityPopupService: PriorityPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.priorityPopupService
                    .open(PriorityDialogComponent as Component, params['id']);
            } else {
                this.priorityPopupService
                    .open(PriorityDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
