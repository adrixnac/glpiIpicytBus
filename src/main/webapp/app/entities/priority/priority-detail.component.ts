import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { Priority } from './priority.model';
import { PriorityService } from './priority.service';

@Component({
    selector: 'jhi-priority-detail',
    templateUrl: './priority-detail.component.html'
})
export class PriorityDetailComponent implements OnInit, OnDestroy {

    priority: Priority;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private priorityService: PriorityService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInPriorities();
    }

    load(id) {
        this.priorityService.find(id)
            .subscribe((priorityResponse: HttpResponse<Priority>) => {
                this.priority = priorityResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInPriorities() {
        this.eventSubscriber = this.eventManager.subscribe(
            'priorityListModification',
            (response) => this.load(this.priority.id)
        );
    }
}
