/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { IpicytBussTestModule } from '../../../test.module';
import { SubtypeTransactionDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction-delete-dialog.component';
import { SubtypeTransactionService } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction.service';

describe('Component Tests', () => {

    describe('SubtypeTransaction Management Delete Component', () => {
        let comp: SubtypeTransactionDeleteDialogComponent;
        let fixture: ComponentFixture<SubtypeTransactionDeleteDialogComponent>;
        let service: SubtypeTransactionService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [SubtypeTransactionDeleteDialogComponent],
                providers: [
                    SubtypeTransactionService
                ]
            })
            .overrideTemplate(SubtypeTransactionDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SubtypeTransactionDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SubtypeTransactionService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
