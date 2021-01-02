import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ProductCat } from './product-cat.model';
import { ProductCatService } from './product-cat.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-product-cat',
    templateUrl: './product-cat.component.html'
})
export class ProductCatComponent implements OnInit, OnDestroy {
productCats: ProductCat[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private productCatService: ProductCatService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.productCatService.query().subscribe(
            (res: HttpResponse<ProductCat[]>) => {
                this.productCats = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInProductCats();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ProductCat) {
        return item.id;
    }
    registerChangeInProductCats() {
        this.eventSubscriber = this.eventManager.subscribe('productCatListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
