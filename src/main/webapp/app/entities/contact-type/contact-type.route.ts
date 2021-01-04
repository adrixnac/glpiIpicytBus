import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { ContactTypeComponent } from './contact-type.component';
import { ContactTypeDetailComponent } from './contact-type-detail.component';
import { ContactTypePopupComponent } from './contact-type-dialog.component';
import { ContactTypeDeletePopupComponent } from './contact-type-delete-dialog.component';

export const contactTypeRoute: Routes = [
    {
        path: 'contact-type',
        component: ContactTypeComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.contactType.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'contact-type/:id',
        component: ContactTypeDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.contactType.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const contactTypePopupRoute: Routes = [
    {
        path: 'contact-type-new',
        component: ContactTypePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.contactType.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'contact-type/:id/edit',
        component: ContactTypePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.contactType.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'contact-type/:id/delete',
        component: ContactTypeDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.contactType.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
