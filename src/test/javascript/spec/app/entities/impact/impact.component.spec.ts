/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { IpicytBussTestModule } from '../../../test.module';
import { ImpactComponent } from '../../../../../../main/webapp/app/entities/impact/impact.component';
import { ImpactService } from '../../../../../../main/webapp/app/entities/impact/impact.service';
import { Impact } from '../../../../../../main/webapp/app/entities/impact/impact.model';

describe('Component Tests', () => {

    describe('Impact Management Component', () => {
        let comp: ImpactComponent;
        let fixture: ComponentFixture<ImpactComponent>;
        let service: ImpactService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [ImpactComponent],
                providers: [
                    ImpactService
                ]
            })
            .overrideTemplate(ImpactComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ImpactComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ImpactService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new Impact(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.impacts[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
