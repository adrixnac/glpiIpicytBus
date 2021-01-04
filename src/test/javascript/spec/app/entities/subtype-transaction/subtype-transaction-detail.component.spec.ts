/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { IpicytBussTestModule } from '../../../test.module';
import { SubtypeTransactionDetailComponent } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction-detail.component';
import { SubtypeTransactionService } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction.service';
import { SubtypeTransaction } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction.model';

describe('Component Tests', () => {

    describe('SubtypeTransaction Management Detail Component', () => {
        let comp: SubtypeTransactionDetailComponent;
        let fixture: ComponentFixture<SubtypeTransactionDetailComponent>;
        let service: SubtypeTransactionService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [SubtypeTransactionDetailComponent],
                providers: [
                    SubtypeTransactionService
                ]
            })
            .overrideTemplate(SubtypeTransactionDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SubtypeTransactionDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SubtypeTransactionService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new SubtypeTransaction(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.subtypeTransaction).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
