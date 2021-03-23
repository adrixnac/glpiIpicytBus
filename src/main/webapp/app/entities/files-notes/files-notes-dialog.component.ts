import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { FilesNotes } from './files-notes.model';
import { FilesNotesPopupService } from './files-notes-popup.service';
import { FilesNotesService } from './files-notes.service';

@Component({
    selector: 'jhi-files-notes-dialog',
    templateUrl: './files-notes-dialog.component.html'
})
export class FilesNotesDialogComponent implements OnInit {

    filesNotes: FilesNotes;
    isSaving: boolean;

    constructor(
        public activeModal: NgbActiveModal,
        private filesNotesService: FilesNotesService,
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
        if (this.filesNotes.id !== undefined) {
            this.subscribeToSaveResponse(
                this.filesNotesService.update(this.filesNotes));
        } else {
            this.subscribeToSaveResponse(
                this.filesNotesService.create(this.filesNotes));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<FilesNotes>>) {
        result.subscribe((res: HttpResponse<FilesNotes>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: FilesNotes) {
        this.eventManager.broadcast({ name: 'filesNotesListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-files-notes-popup',
    template: ''
})
export class FilesNotesPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private filesNotesPopupService: FilesNotesPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.filesNotesPopupService
                    .open(FilesNotesDialogComponent as Component, params['id']);
            } else {
                this.filesNotesPopupService
                    .open(FilesNotesDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
