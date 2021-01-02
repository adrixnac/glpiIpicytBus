import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ContactType } from './contact-type.model';
import { ContactTypeService } from './contact-type.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-contact-type',
    templateUrl: './contact-type.component.html'
})
export class ContactTypeComponent implements OnInit, OnDestroy {
contactTypes: ContactType[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private contactTypeService: ContactTypeService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.contactTypeService.query().subscribe(
            (res: HttpResponse<ContactType[]>) => {
                this.contactTypes = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInContactTypes();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ContactType) {
        return item.id;
    }
    registerChangeInContactTypes() {
        this.eventSubscriber = this.eventManager.subscribe('contactTypeListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
