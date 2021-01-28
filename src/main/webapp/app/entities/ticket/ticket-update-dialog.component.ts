import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { Ticket } from './ticket.model';
import { TicketPopupService } from './ticket-popup.service';
import { TicketService } from './ticket.service';

@Component({
    selector: 'jhi-ticket-update-dialog',
    templateUrl: './ticket-update-dialog.component.html'
})
export class TicketUpdateDialogComponent {
    ticket: Ticket;

    constructor(
        private ticketService: TicketService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmUpdate(id: number) {
        this.ticketService.translate(id).subscribe((response)=> {
            this.eventManager.broadcast({
                name: 'ticketListModification',
                content: 'Updated an ticket'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-ticket-update-popup',
    template: ''
})
export class TicketUpdatePopupComponent implements OnInit, OnDestroy {
    routeSub: any;
    constructor(
        private route: ActivatedRoute,
        private ticketPopupService: TicketPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.ticketPopupService
                .open(TicketUpdateDialogComponent as Component, params['id']);
        });
    }
    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
