import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { FilesNotes } from './files-notes.model';
import { FilesNotesService } from './files-notes.service';

@Component({
    selector: 'jhi-files-notes-detail',
    templateUrl: './files-notes-detail.component.html'
})
export class FilesNotesDetailComponent implements OnInit, OnDestroy {

    filesNotes: FilesNotes;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private filesNotesService: FilesNotesService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInFilesNotes();
    }

    load(id) {
        this.filesNotesService.find(id)
            .subscribe((filesNotesResponse: HttpResponse<FilesNotes>) => {
                this.filesNotes = filesNotesResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInFilesNotes() {
        this.eventSubscriber = this.eventManager.subscribe(
            'filesNotesListModification',
            (response) => this.load(this.filesNotes.id)
        );
    }
}
