import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Priority } from './priority.model';
import { PriorityService } from './priority.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-priority',
    templateUrl: './priority.component.html'
})
export class PriorityComponent implements OnInit, OnDestroy {
priorities: Priority[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private priorityService: PriorityService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.priorityService.query().subscribe(
            (res: HttpResponse<Priority[]>) => {
                this.priorities = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInPriorities();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: Priority) {
        return item.id;
    }
    registerChangeInPriorities() {
        this.eventSubscriber = this.eventManager.subscribe('priorityListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
