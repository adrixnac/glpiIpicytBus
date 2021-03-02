/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { IpicytBussTestModule } from '../../../test.module';
import { FilesNotesComponent } from '../../../../../../main/webapp/app/entities/files-notes/files-notes.component';
import { FilesNotesService } from '../../../../../../main/webapp/app/entities/files-notes/files-notes.service';
import { FilesNotes } from '../../../../../../main/webapp/app/entities/files-notes/files-notes.model';

describe('Component Tests', () => {

    describe('FilesNotes Management Component', () => {
        let comp: FilesNotesComponent;
        let fixture: ComponentFixture<FilesNotesComponent>;
        let service: FilesNotesService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [IpicytBussTestModule],
                declarations: [FilesNotesComponent],
                providers: [
                    FilesNotesService
                ]
            })
            .overrideTemplate(FilesNotesComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(FilesNotesComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(FilesNotesService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new FilesNotes(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.filesNotes[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
