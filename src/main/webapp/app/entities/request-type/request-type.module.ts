import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IpicytBussSharedModule } from '../../shared';
import {
    RequestTypeService,
    RequestTypePopupService,
    RequestTypeComponent,
    RequestTypeDetailComponent,
    RequestTypeDialogComponent,
    RequestTypePopupComponent,
    RequestTypeDeletePopupComponent,
    RequestTypeDeleteDialogComponent,
    requestTypeRoute,
    requestTypePopupRoute,
} from './';

const ENTITY_STATES = [
    ...requestTypeRoute,
    ...requestTypePopupRoute,
];

@NgModule({
    imports: [
        IpicytBussSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        RequestTypeComponent,
        RequestTypeDetailComponent,
        RequestTypeDialogComponent,
        RequestTypeDeleteDialogComponent,
        RequestTypePopupComponent,
        RequestTypeDeletePopupComponent,
    ],
    entryComponents: [
        RequestTypeComponent,
        RequestTypeDialogComponent,
        RequestTypePopupComponent,
        RequestTypeDeleteDialogComponent,
        RequestTypeDeletePopupComponent,
    ],
    providers: [
        RequestTypeService,
        RequestTypePopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussRequestTypeModule {}
