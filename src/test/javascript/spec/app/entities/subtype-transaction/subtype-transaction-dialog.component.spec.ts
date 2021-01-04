/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { IpicytBussTestModule } from '../../../test.module';
import { SubtypeTransactionDialogComponent } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction-dialog.component';
import { SubtypeTransactionService } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction.service';
import { SubtypeTransaction } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction.model';

describe('Component Tests', () => {

    describe('SubtypeTransaction Management Dialog Component', () => {
        let comp: SubtypeTransactionDialogComponent;
        let fixture: ComponentFixture<SubtypeTransactionDialogComponent>;
        let service: SubtypeTransactionService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [SubtypeTransactionDialogComponent],
                providers: [
                    SubtypeTransactionService
                ]
            })
            .overrideTemplate(SubtypeTransactionDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SubtypeTransactionDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SubtypeTransactionService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new SubtypeTransaction(123);
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.subtypeTransaction = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'subtypeTransactionListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new SubtypeTransaction();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.subtypeTransaction = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'subtypeTransactionListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
