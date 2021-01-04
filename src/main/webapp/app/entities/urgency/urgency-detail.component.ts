import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { Urgency } from './urgency.model';
import { UrgencyService } from './urgency.service';

@Component({
    selector: 'jhi-urgency-detail',
    templateUrl: './urgency-detail.component.html'
})
export class UrgencyDetailComponent implements OnInit, OnDestroy {

    urgency: Urgency;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private urgencyService: UrgencyService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInUrgencies();
    }

    load(id) {
        this.urgencyService.find(id)
            .subscribe((urgencyResponse: HttpResponse<Urgency>) => {
                this.urgency = urgencyResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInUrgencies() {
        this.eventSubscriber = this.eventManager.subscribe(
            'urgencyListModification',
            (response) => this.load(this.urgency.id)
        );
    }
}
