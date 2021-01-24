import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IpicytBussSharedModule } from '../../shared';
import {
    PriorityService,
    PriorityPopupService,
    PriorityComponent,
    PriorityDetailComponent,
    PriorityDialogComponent,
    PriorityPopupComponent,
    PriorityDeletePopupComponent,
    PriorityDeleteDialogComponent,
    priorityRoute,
    priorityPopupRoute,
} from './';

const ENTITY_STATES = [
    ...priorityRoute,
    ...priorityPopupRoute,
];

@NgModule({
    imports: [
        IpicytBussSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        PriorityComponent,
        PriorityDetailComponent,
        PriorityDialogComponent,
        PriorityDeleteDialogComponent,
        PriorityPopupComponent,
        PriorityDeletePopupComponent,
    ],
    entryComponents: [
        PriorityComponent,
        PriorityDialogComponent,
        PriorityPopupComponent,
        PriorityDeleteDialogComponent,
        PriorityDeletePopupComponent,
    ],
    providers: [
        PriorityService,
        PriorityPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussPriorityModule {}
