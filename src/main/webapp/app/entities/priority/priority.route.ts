import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { PriorityComponent } from './priority.component';
import { PriorityDetailComponent } from './priority-detail.component';
import { PriorityPopupComponent } from './priority-dialog.component';
import { PriorityDeletePopupComponent } from './priority-delete-dialog.component';

export const priorityRoute: Routes = [
    {
        path: 'priority',
        component: PriorityComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.priority.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'priority/:id',
        component: PriorityDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.priority.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const priorityPopupRoute: Routes = [
    {
        path: 'priority-new',
        component: PriorityPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.priority.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'priority/:id/edit',
        component: PriorityPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.priority.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'priority/:id/delete',
        component: PriorityDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.priority.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
