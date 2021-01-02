import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { ProductCat } from './product-cat.model';
import { ProductCatService } from './product-cat.service';

@Component({
    selector: 'jhi-product-cat-detail',
    templateUrl: './product-cat-detail.component.html'
})
export class ProductCatDetailComponent implements OnInit, OnDestroy {

    productCat: ProductCat;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private productCatService: ProductCatService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInProductCats();
    }

    load(id) {
        this.productCatService.find(id)
            .subscribe((productCatResponse: HttpResponse<ProductCat>) => {
                this.productCat = productCatResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInProductCats() {
        this.eventSubscriber = this.eventManager.subscribe(
            'productCatListModification',
            (response) => this.load(this.productCat.id)
        );
    }
}
