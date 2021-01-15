/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { IpicytBussTestModule } from '../../../test.module';
import { PriorityComponent } from '../../../../../../main/webapp/app/entities/priority/priority.component';
import { PriorityService } from '../../../../../../main/webapp/app/entities/priority/priority.service';
import { Priority } from '../../../../../../main/webapp/app/entities/priority/priority.model';

describe('Component Tests', () => {

    describe('Priority Management Component', () => {
        let comp: PriorityComponent;
        let fixture: ComponentFixture<PriorityComponent>;
        let service: PriorityService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [PriorityComponent],
                providers: [
                    PriorityService
                ]
            })
            .overrideTemplate(PriorityComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(PriorityComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(PriorityService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new Priority(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.priorities[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
