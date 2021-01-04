import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ProductCat } from './product-cat.model';
import { ProductCatPopupService } from './product-cat-popup.service';
import { ProductCatService } from './product-cat.service';

@Component({
    selector: 'jhi-product-cat-delete-dialog',
    templateUrl: './product-cat-delete-dialog.component.html'
})
export class ProductCatDeleteDialogComponent {

    productCat: ProductCat;

    constructor(
        private productCatService: ProductCatService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.productCatService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'productCatListModification',
                content: 'Deleted an productCat'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-product-cat-delete-popup',
    template: ''
})
export class ProductCatDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private productCatPopupService: ProductCatPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.productCatPopupService
                .open(ProductCatDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
