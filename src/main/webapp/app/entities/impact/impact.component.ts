import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Impact } from './impact.model';
import { ImpactService } from './impact.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-impact',
    templateUrl: './impact.component.html'
})
export class ImpactComponent implements OnInit, OnDestroy {
impacts: Impact[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private impactService: ImpactService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.impactService.query().subscribe(
            (res: HttpResponse<Impact[]>) => {
                this.impacts = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInImpacts();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: Impact) {
        return item.id;
    }
    registerChangeInImpacts() {
        this.eventSubscriber = this.eventManager.subscribe('impactListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
