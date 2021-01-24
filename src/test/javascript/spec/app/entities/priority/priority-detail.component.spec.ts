/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { IpicytBussTestModule } from '../../../test.module';
import { PriorityDetailComponent } from '../../../../../../main/webapp/app/entities/priority/priority-detail.component';
import { PriorityService } from '../../../../../../main/webapp/app/entities/priority/priority.service';
import { Priority } from '../../../../../../main/webapp/app/entities/priority/priority.model';

describe('Component Tests', () => {

    describe('Priority Management Detail Component', () => {
        let comp: PriorityDetailComponent;
        let fixture: ComponentFixture<PriorityDetailComponent>;
        let service: PriorityService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [PriorityDetailComponent],
                providers: [
                    PriorityService
                ]
            })
            .overrideTemplate(PriorityDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(PriorityDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(PriorityService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new Priority(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.priority).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
