import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { SubtypeTransactionComponent } from './subtype-transaction.component';
import { SubtypeTransactionDetailComponent } from './subtype-transaction-detail.component';
import { SubtypeTransactionPopupComponent } from './subtype-transaction-dialog.component';
import { SubtypeTransactionDeletePopupComponent } from './subtype-transaction-delete-dialog.component';

export const subtypeTransactionRoute: Routes = [
    {
        path: 'subtype-transaction',
        component: SubtypeTransactionComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.subtypeTransaction.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'subtype-transaction/:id',
        component: SubtypeTransactionDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.subtypeTransaction.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const subtypeTransactionPopupRoute: Routes = [
    {
        path: 'subtype-transaction-new',
        component: SubtypeTransactionPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.subtypeTransaction.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'subtype-transaction/:id/edit',
        component: SubtypeTransactionPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.subtypeTransaction.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'subtype-transaction/:id/delete',
        component: SubtypeTransactionDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.subtypeTransaction.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
