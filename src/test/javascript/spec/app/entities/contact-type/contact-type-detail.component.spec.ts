/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { IpicytBussTestModule } from '../../../test.module';
import { ContactTypeDetailComponent } from '../../../../../../main/webapp/app/entities/contact-type/contact-type-detail.component';
import { ContactTypeService } from '../../../../../../main/webapp/app/entities/contact-type/contact-type.service';
import { ContactType } from '../../../../../../main/webapp/app/entities/contact-type/contact-type.model';

describe('Component Tests', () => {

    describe('ContactType Management Detail Component', () => {
        let comp: ContactTypeDetailComponent;
        let fixture: ComponentFixture<ContactTypeDetailComponent>;
        let service: ContactTypeService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [ContactTypeDetailComponent],
                providers: [
                    ContactTypeService
                ]
            })
            .overrideTemplate(ContactTypeDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(ContactTypeDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(ContactTypeService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new ContactType(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.contactType).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
