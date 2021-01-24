import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { Priority } from './priority.model';
import { PriorityPopupService } from './priority-popup.service';
import { PriorityService } from './priority.service';

@Component({
    selector: 'jhi-priority-delete-dialog',
    templateUrl: './priority-delete-dialog.component.html'
})
export class PriorityDeleteDialogComponent {

    priority: Priority;

    constructor(
        private priorityService: PriorityService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.priorityService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'priorityListModification',
                content: 'Deleted an priority'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-priority-delete-popup',
    template: ''
})
export class PriorityDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private priorityPopupService: PriorityPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.priorityPopupService
                .open(PriorityDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
