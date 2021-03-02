import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { FilesNotes } from './files-notes.model';
import { FilesNotesService } from './files-notes.service';

@Injectable()
export class FilesNotesPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private filesNotesService: FilesNotesService

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
                this.filesNotesService.find(id)
                    .subscribe((filesNotesResponse: HttpResponse<FilesNotes>) => {
                        const filesNotes: FilesNotes = filesNotesResponse.body;
                        this.ngbModalRef = this.filesNotesModalRef(component, filesNotes);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.filesNotesModalRef(component, new FilesNotes());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    filesNotesModalRef(component: Component, filesNotes: FilesNotes): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.filesNotes = filesNotes;
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
