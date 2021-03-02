/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { IpicytBussTestModule } from '../../../test.module';
import { FilesNotesDialogComponent } from '../../../../../../main/webapp/app/entities/files-notes/files-notes-dialog.component';
import { FilesNotesService } from '../../../../../../main/webapp/app/entities/files-notes/files-notes.service';
import { FilesNotes } from '../../../../../../main/webapp/app/entities/files-notes/files-notes.model';

describe('Component Tests', () => {

    describe('FilesNotes Management Dialog Component', () => {
        let comp: FilesNotesDialogComponent;
        let fixture: ComponentFixture<FilesNotesDialogComponent>;
        let service: FilesNotesService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [FilesNotesDialogComponent],
                providers: [
                    FilesNotesService
                ]
            })
            .overrideTemplate(FilesNotesDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(FilesNotesDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FilesNotesService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new FilesNotes(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.filesNotes = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'filesNotesListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new FilesNotes();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.filesNotes = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'filesNotesListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
