import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Impact } from './impact.model';
import { ImpactPopupService } from './impact-popup.service';
import { ImpactService } from './impact.service';

@Component({
    selector: 'jhi-impact-delete-dialog',
    templateUrl: './impact-delete-dialog.component.html'
})
export class ImpactDeleteDialogComponent {

    impact: Impact;

    constructor(
        private impactService: ImpactService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.impactService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'impactListModification',
                content: 'Deleted an impact'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-impact-delete-popup',
    template: ''
})
export class ImpactDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private impactPopupService: ImpactPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.impactPopupService
                .open(ImpactDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
