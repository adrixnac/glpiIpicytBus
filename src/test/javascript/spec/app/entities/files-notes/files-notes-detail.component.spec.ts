/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { IpicytBussTestModule } from '../../../test.module';
import { FilesNotesDetailComponent } from '../../../../../../main/webapp/app/entities/files-notes/files-notes-detail.component';
import { FilesNotesService } from '../../../../../../main/webapp/app/entities/files-notes/files-notes.service';
import { FilesNotes } from '../../../../../../main/webapp/app/entities/files-notes/files-notes.model';

describe('Component Tests', () => {

    describe('FilesNotes Management Detail Component', () => {
        let comp: FilesNotesDetailComponent;
        let fixture: ComponentFixture<FilesNotesDetailComponent>;
        let service: FilesNotesService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [FilesNotesDetailComponent],
                providers: [
                    FilesNotesService
                ]
            })
            .overrideTemplate(FilesNotesDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(FilesNotesDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FilesNotesService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new FilesNotes(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.filesNotes).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
