import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IpicytBussSharedModule } from '../../shared';
import {
    FilesNotesService,
    FilesNotesPopupService,
    FilesNotesComponent,
    FilesNotesDetailComponent,
    FilesNotesDialogComponent,
    FilesNotesPopupComponent,
    FilesNotesDeletePopupComponent,
    FilesNotesDeleteDialogComponent,
    filesNotesRoute,
    filesNotesPopupRoute,
} from './';

const ENTITY_STATES = [
    ...filesNotesRoute,
    ...filesNotesPopupRoute,
];

@NgModule({
    imports: [
        IpicytBussSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        FilesNotesComponent,
        FilesNotesDetailComponent,
        FilesNotesDialogComponent,
        FilesNotesDeleteDialogComponent,
        FilesNotesPopupComponent,
        FilesNotesDeletePopupComponent,
    ],
    entryComponents: [
        FilesNotesComponent,
        FilesNotesDialogComponent,
        FilesNotesPopupComponent,
        FilesNotesDeleteDialogComponent,
        FilesNotesDeletePopupComponent,
    ],
    providers: [
        FilesNotesService,
        FilesNotesPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussFilesNotesModule {}
