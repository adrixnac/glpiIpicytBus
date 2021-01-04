import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ProductCat } from './product-cat.model';
import { ProductCatPopupService } from './product-cat-popup.service';
import { ProductCatService } from './product-cat.service';

@Component({
    selector: 'jhi-product-cat-dialog',
    templateUrl: './product-cat-dialog.component.html'
})
export class ProductCatDialogComponent implements OnInit {

    productCat: ProductCat;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private productCatService: ProductCatService,
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
        if (this.productCat.id !== undefined) {
            this.subscribeToSaveResponse(
                this.productCatService.update(this.productCat));
        } else {
            this.subscribeToSaveResponse(
                this.productCatService.create(this.productCat));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ProductCat>>) {
        result.subscribe((res: HttpResponse<ProductCat>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: ProductCat) {
        this.eventManager.broadcast({ name: 'productCatListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-product-cat-popup',
    template: ''
})
export class ProductCatPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private productCatPopupService: ProductCatPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.productCatPopupService
                    .open(ProductCatDialogComponent as Component, params['id']);
            } else {
                this.productCatPopupService
                    .open(ProductCatDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
