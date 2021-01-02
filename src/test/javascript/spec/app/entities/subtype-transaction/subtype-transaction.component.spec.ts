/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { IpicytBussTestModule } from '../../../test.module';
import { SubtypeTransactionComponent } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction.component';
import { SubtypeTransactionService } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction.service';
import { SubtypeTransaction } from '../../../../../../main/webapp/app/entities/subtype-transaction/subtype-transaction.model';

describe('Component Tests', () => {

    describe('SubtypeTransaction Management Component', () => {
        let comp: SubtypeTransactionComponent;
        let fixture: ComponentFixture<SubtypeTransactionComponent>;
        let service: SubtypeTransactionService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [SubtypeTransactionComponent],
                providers: [
                    SubtypeTransactionService
                ]
            })
            .overrideTemplate(SubtypeTransactionComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(SubtypeTransactionComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SubtypeTransactionService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new SubtypeTransaction(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.subtypeTransactions[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
