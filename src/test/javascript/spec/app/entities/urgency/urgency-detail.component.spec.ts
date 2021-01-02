/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { IpicytBussTestModule } from '../../../test.module';
import { UrgencyDetailComponent } from '../../../../../../main/webapp/app/entities/urgency/urgency-detail.component';
import { UrgencyService } from '../../../../../../main/webapp/app/entities/urgency/urgency.service';
import { Urgency } from '../../../../../../main/webapp/app/entities/urgency/urgency.model';

describe('Component Tests', () => {

    describe('Urgency Management Detail Component', () => {
        let comp: UrgencyDetailComponent;
        let fixture: ComponentFixture<UrgencyDetailComponent>;
        let service: UrgencyService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [UrgencyDetailComponent],
                providers: [
                    UrgencyService
                ]
            })
            .overrideTemplate(UrgencyDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(UrgencyDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(UrgencyService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new Urgency(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.urgency).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
