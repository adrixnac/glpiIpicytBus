/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { IpicytBussTestModule } from '../../../test.module';
import { ContactTypeComponent } from '../../../../../../main/webapp/app/entities/contact-type/contact-type.component';
import { ContactTypeService } from '../../../../../../main/webapp/app/entities/contact-type/contact-type.service';
import { ContactType } from '../../../../../../main/webapp/app/entities/contact-type/contact-type.model';

describe('Component Tests', () => {

    describe('ContactType Management Component', () => {
        let comp: ContactTypeComponent;
        let fixture: ComponentFixture<ContactTypeComponent>;
        let service: ContactTypeService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [ContactTypeComponent],
                providers: [
                    ContactTypeService
                ]
            })
            .overrideTemplate(ContactTypeComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ContactTypeComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ContactTypeService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new ContactType(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.contactTypes[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
