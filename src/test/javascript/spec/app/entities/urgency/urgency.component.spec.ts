/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { IpicytBussTestModule } from '../../../test.module';
import { UrgencyComponent } from '../../../../../../main/webapp/app/entities/urgency/urgency.component';
import { UrgencyService } from '../../../../../../main/webapp/app/entities/urgency/urgency.service';
import { Urgency } from '../../../../../../main/webapp/app/entities/urgency/urgency.model';

describe('Component Tests', () => {

    describe('Urgency Management Component', () => {
        let comp: UrgencyComponent;
        let fixture: ComponentFixture<UrgencyComponent>;
        let service: UrgencyService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [UrgencyComponent],
                providers: [
                    UrgencyService
                ]
            })
            .overrideTemplate(UrgencyComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(UrgencyComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(UrgencyService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new Urgency(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.urgencies[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
