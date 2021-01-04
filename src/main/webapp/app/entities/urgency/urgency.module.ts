import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IpicytBussSharedModule } from '../../shared';
import {
    UrgencyService,
    UrgencyPopupService,
    UrgencyComponent,
    UrgencyDetailComponent,
    UrgencyDialogComponent,
    UrgencyPopupComponent,
    UrgencyDeletePopupComponent,
    UrgencyDeleteDialogComponent,
    urgencyRoute,
    urgencyPopupRoute,
} from './';

const ENTITY_STATES = [
    ...urgencyRoute,
    ...urgencyPopupRoute,
];

@NgModule({
    imports: [
        IpicytBussSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        UrgencyComponent,
        UrgencyDetailComponent,
        UrgencyDialogComponent,
        UrgencyDeleteDialogComponent,
        UrgencyPopupComponent,
        UrgencyDeletePopupComponent,
    ],
    entryComponents: [
        UrgencyComponent,
        UrgencyDialogComponent,
        UrgencyPopupComponent,
        UrgencyDeleteDialogComponent,
        UrgencyDeletePopupComponent,
    ],
    providers: [
        UrgencyService,
        UrgencyPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussUrgencyModule {}
