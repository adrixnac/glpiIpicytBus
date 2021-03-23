import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { FilesNotes } from './files-notes.model';
import { FilesNotesPopupService } from './files-notes-popup.service';
import { FilesNotesService } from './files-notes.service';

@Component({
    selector: 'jhi-files-notes-delete-dialog',
    templateUrl: './files-notes-delete-dialog.component.html'
})
export class FilesNotesDeleteDialogComponent {

    filesNotes: FilesNotes;

    constructor(
        private filesNotesService: FilesNotesService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.filesNotesService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'filesNotesListModification',
                content: 'Deleted an filesNotes'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-files-notes-delete-popup',
    template: ''
})
export class FilesNotesDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private filesNotesPopupService: FilesNotesPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.filesNotesPopupService
                .open(FilesNotesDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
