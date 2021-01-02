import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { SubtypeTransaction } from './subtype-transaction.model';
import { SubtypeTransactionService } from './subtype-transaction.service';

@Injectable()
export class SubtypeTransactionPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private subtypeTransactionService: SubtypeTransactionService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.subtypeTransactionService.find(id)
                    .subscribe((subtypeTransactionResponse: HttpResponse<SubtypeTransaction>) => {
                        const subtypeTransaction: SubtypeTransaction = subtypeTransactionResponse.body;
                        this.ngbModalRef = this.subtypeTransactionModalRef(component, subtypeTransaction);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.subtypeTransactionModalRef(component, new SubtypeTransaction());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    subtypeTransactionModalRef(component: Component, subtypeTransaction: SubtypeTransaction): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.subtypeTransaction = subtypeTransaction;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
