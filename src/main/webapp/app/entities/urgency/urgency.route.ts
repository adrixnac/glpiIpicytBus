import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { UrgencyComponent } from './urgency.component';
import { UrgencyDetailComponent } from './urgency-detail.component';
import { UrgencyPopupComponent } from './urgency-dialog.component';
import { UrgencyDeletePopupComponent } from './urgency-delete-dialog.component';

export const urgencyRoute: Routes = [
    {
        path: 'urgency',
        component: UrgencyComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.urgency.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'urgency/:id',
        component: UrgencyDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.urgency.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const urgencyPopupRoute: Routes = [
    {
        path: 'urgency-new',
        component: UrgencyPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.urgency.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'urgency/:id/edit',
        component: UrgencyPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.urgency.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'urgency/:id/delete',
        component: UrgencyDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.urgency.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
