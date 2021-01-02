import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { Ticket } from './ticket.model';
import { TicketPopupService } from './ticket-popup.service';
import { TicketService } from './ticket.service';
import { Transaction, TransactionService } from '../transaction';
import { SubtypeTransaction, SubtypeTransactionService } from '../subtype-transaction';
import { ProductCat, ProductCatService } from '../product-cat';
import { ContactType, ContactTypeService } from '../contact-type';
import { Impact, ImpactService } from '../impact';
import { Urgency, UrgencyService } from '../urgency';

@Component({
    selector: 'jhi-ticket-dialog',
    templateUrl: './ticket-dialog.component.html'
})
export class TicketDialogComponent implements OnInit {

    ticket: Ticket;
    isSaving: boolean;

    transactions: Transaction[];

    subtypetransactions: SubtypeTransaction[];

    productcats: ProductCat[];

    contacttypes: ContactType[];

    impacts: Impact[];

    urgencies: Urgency[];

    constructor(
        public activeModal: NgbActiveModal,
        private jhiAlertService: JhiAlertService,
        private ticketService: TicketService,
        private transactionService: TransactionService,
        private subtypeTransactionService: SubtypeTransactionService,
        private productCatService: ProductCatService,
        private contactTypeService: ContactTypeService,
        private impactService: ImpactService,
        private urgencyService: UrgencyService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
        this.transactionService.query()
            .subscribe((res: HttpResponse<Transaction[]>) => { this.transactions = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
        this.subtypeTransactionService.query()
            .subscribe((res: HttpResponse<SubtypeTransaction[]>) => { this.subtypetransactions = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
        this.productCatService.query()
            .subscribe((res: HttpResponse<ProductCat[]>) => { this.productcats = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
        this.contactTypeService.query()
            .subscribe((res: HttpResponse<ContactType[]>) => { this.contacttypes = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
        this.impactService.query()
            .subscribe((res: HttpResponse<Impact[]>) => { this.impacts = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
        this.urgencyService.query()
            .subscribe((res: HttpResponse<Urgency[]>) => { this.urgencies = res.body; }, (res: HttpErrorResponse) => this.onError(res.message));
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.ticket.id !== undefined) {
            this.subscribeToSaveResponse(
                this.ticketService.update(this.ticket));
        } else {
            this.subscribeToSaveResponse(
                this.ticketService.create(this.ticket));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<Ticket>>) {
        result.subscribe((res: HttpResponse<Ticket>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: Ticket) {
        this.eventManager.broadcast({ name: 'ticketListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(error: any) {
        this.jhiAlertService.error(error.message, null, null);
    }

    trackTransactionById(index: number, item: Transaction) {
        return item.id;
    }

    trackSubtypeTransactionById(index: number, item: SubtypeTransaction) {
        return item.id;
    }

    trackProductCatById(index: number, item: ProductCat) {
        return item.id;
    }

    trackContactTypeById(index: number, item: ContactType) {
        return item.id;
    }

    trackImpactById(index: number, item: Impact) {
        return item.id;
    }

    trackUrgencyById(index: number, item: Urgency) {
        return item.id;
    }
}

@Component({
    selector: 'jhi-ticket-popup',
    template: ''
})
export class TicketPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private ticketPopupService: TicketPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.ticketPopupService
                    .open(TicketDialogComponent as Component, params['id']);
            } else {
                this.ticketPopupService
                    .open(TicketDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
