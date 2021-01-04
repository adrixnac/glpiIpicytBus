/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { IpicytBussTestModule } from '../../../test.module';
import { ImpactDetailComponent } from '../../../../../../main/webapp/app/entities/impact/impact-detail.component';
import { ImpactService } from '../../../../../../main/webapp/app/entities/impact/impact.service';
import { Impact } from '../../../../../../main/webapp/app/entities/impact/impact.model';

describe('Component Tests', () => {

    describe('Impact Management Detail Component', () => {
        let comp: ImpactDetailComponent;
        let fixture: ComponentFixture<ImpactDetailComponent>;
        let service: ImpactService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [ImpactDetailComponent],
                providers: [
                    ImpactService
                ]
            })
            .overrideTemplate(ImpactDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ImpactDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ImpactService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new Impact(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.impact).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
