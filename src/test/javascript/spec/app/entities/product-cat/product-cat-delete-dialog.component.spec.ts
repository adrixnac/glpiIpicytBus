/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { IpicytBussTestModule } from '../../../test.module';
import { ProductCatDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/product-cat/product-cat-delete-dialog.component';
import { ProductCatService } from '../../../../../../main/webapp/app/entities/product-cat/product-cat.service';

describe('Component Tests', () => {

    describe('ProductCat Management Delete Component', () => {
        let comp: ProductCatDeleteDialogComponent;
        let fixture: ComponentFixture<ProductCatDeleteDialogComponent>;
        let service: ProductCatService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [ProductCatDeleteDialogComponent],
                providers: [
                    ProductCatService
                ]
            })
            .overrideTemplate(ProductCatDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ProductCatDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ProductCatService);
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
