import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { ImpactComponent } from './impact.component';
import { ImpactDetailComponent } from './impact-detail.component';
import { ImpactPopupComponent } from './impact-dialog.component';
import { ImpactDeletePopupComponent } from './impact-delete-dialog.component';

export const impactRoute: Routes = [
    {
        path: 'impact',
        component: ImpactComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.impact.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'impact/:id',
        component: ImpactDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.impact.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const impactPopupRoute: Routes = [
    {
        path: 'impact-new',
        component: ImpactPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.impact.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'impact/:id/edit',
        component: ImpactPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.impact.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'impact/:id/delete',
        component: ImpactDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.impact.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
