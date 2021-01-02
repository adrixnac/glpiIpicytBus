import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { Impact } from './impact.model';
import { ImpactService } from './impact.service';

@Component({
    selector: 'jhi-impact-detail',
    templateUrl: './impact-detail.component.html'
})
export class ImpactDetailComponent implements OnInit, OnDestroy {

    impact: Impact;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private impactService: ImpactService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInImpacts();
    }

    load(id) {
        this.impactService.find(id)
            .subscribe((impactResponse: HttpResponse<Impact>) => {
                this.impact = impactResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInImpacts() {
        this.eventSubscriber = this.eventManager.subscribe(
            'impactListModification',
            (response) => this.load(this.impact.id)
        );
    }
}
