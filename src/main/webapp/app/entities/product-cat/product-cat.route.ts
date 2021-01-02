import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { ProductCatComponent } from './product-cat.component';
import { ProductCatDetailComponent } from './product-cat-detail.component';
import { ProductCatPopupComponent } from './product-cat-dialog.component';
import { ProductCatDeletePopupComponent } from './product-cat-delete-dialog.component';

export const productCatRoute: Routes = [
    {
        path: 'product-cat',
        component: ProductCatComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.productCat.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'product-cat/:id',
        component: ProductCatDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.productCat.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const productCatPopupRoute: Routes = [
    {
        path: 'product-cat-new',
        component: ProductCatPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.productCat.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'product-cat/:id/edit',
        component: ProductCatPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.productCat.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'product-cat/:id/delete',
        component: ProductCatDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'ipicytBussApp.productCat.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
