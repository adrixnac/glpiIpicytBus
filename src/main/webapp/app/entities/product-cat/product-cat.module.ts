import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IpicytBussSharedModule } from '../../shared';
import {
    ProductCatService,
    ProductCatPopupService,
    ProductCatComponent,
    ProductCatDetailComponent,
    ProductCatDialogComponent,
    ProductCatPopupComponent,
    ProductCatDeletePopupComponent,
    ProductCatDeleteDialogComponent,
    productCatRoute,
    productCatPopupRoute,
} from './';

const ENTITY_STATES = [
    ...productCatRoute,
    ...productCatPopupRoute,
];

@NgModule({
    imports: [
        IpicytBussSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        ProductCatComponent,
        ProductCatDetailComponent,
        ProductCatDialogComponent,
        ProductCatDeleteDialogComponent,
        ProductCatPopupComponent,
        ProductCatDeletePopupComponent,
    ],
    entryComponents: [
        ProductCatComponent,
        ProductCatDialogComponent,
        ProductCatPopupComponent,
        ProductCatDeleteDialogComponent,
        ProductCatDeletePopupComponent,
    ],
    providers: [
        ProductCatService,
        ProductCatPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussProductCatModule {}
