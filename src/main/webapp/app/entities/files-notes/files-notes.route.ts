import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { FilesNotesComponent } from './files-notes.component';
import { FilesNotesDetailComponent } from './files-notes-detail.component';
import { FilesNotesPopupComponent } from './files-notes-dialog.component';
import { FilesNotesDeletePopupComponent } from './files-notes-delete-dialog.component';

export const filesNotesRoute: Routes = [
    {
        path: 'files-notes',
        component: FilesNotesComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.filesNotes.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'files-notes/:id',
        component: FilesNotesDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.filesNotes.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const filesNotesPopupRoute: Routes = [
    {
        path: 'files-notes-new',
        component: FilesNotesPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.filesNotes.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'files-notes/:id/edit',
        component: FilesNotesPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.filesNotes.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'files-notes/:id/delete',
        component: FilesNotesDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.filesNotes.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
