import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { FilesNotes } from './files-notes.model';
import { FilesNotesService } from './files-notes.service';
import { Principal } from '../../shared';

@Component({
    selector: 'jhi-files-notes',
    templateUrl: './files-notes.component.html'
})
export class FilesNotesComponent implements OnInit, OnDestroy {
filesNotes: FilesNotes[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private filesNotesService: FilesNotesService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {
    }

    loadAll() {
        this.filesNotesService.query().subscribe(
            (res: HttpResponse<FilesNotes[]>) => {
                this.filesNotes = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInFilesNotes();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: FilesNotes) {
        return item.id;
    }
    registerChangeInFilesNotes() {
        this.eventSubscriber = this.eventManager.subscribe('filesNotesListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
}
