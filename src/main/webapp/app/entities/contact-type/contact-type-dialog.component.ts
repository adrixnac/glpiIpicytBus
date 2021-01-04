import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ContactType } from './contact-type.model';
import { ContactTypePopupService } from './contact-type-popup.service';
import { ContactTypeService } from './contact-type.service';

@Component({
    selector: 'jhi-contact-type-dialog',
    templateUrl: './contact-type-dialog.component.html'
})
export class ContactTypeDialogComponent implements OnInit {

    contactType: ContactType;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private contactTypeService: ContactTypeService,
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
        if (this.contactType.id !== undefined) {
            this.subscribeToSaveResponse(
                this.contactTypeService.update(this.contactType));
        } else {
            this.subscribeToSaveResponse(
                this.contactTypeService.create(this.contactType));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ContactType>>) {
        result.subscribe((res: HttpResponse<ContactType>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: ContactType) {
        this.eventManager.broadcast({ name: 'contactTypeListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-contact-type-popup',
    template: ''
})
export class ContactTypePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private contactTypePopupService: ContactTypePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.contactTypePopupService
                    .open(ContactTypeDialogComponent as Component, params['id']);
            } else {
                this.contactTypePopupService
                    .open(ContactTypeDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
