import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IpicytBussSharedModule } from '../../shared';
import {
    TicketService,
    TicketPopupService,
    TicketComponent,
    TicketDetailComponent,
    TicketDialogComponent,
    TicketPopupComponent,
    TicketDeletePopupComponent,
    TicketDeleteDialogComponent,
    ticketRoute,
    ticketPopupRoute,
    TicketResolvePagingParams,
    TicketUpdateDialogComponent,
    TicketUpdatePopupComponent
} from './';

const ENTITY_STATES = [
    ...ticketRoute,
    ...ticketPopupRoute,
];

@NgModule({
    imports: [
        IpicytBussSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        TicketComponent,
        TicketDetailComponent,
        TicketDialogComponent,
        TicketDeleteDialogComponent,
        TicketUpdateDialogComponent,
        TicketPopupComponent,
        TicketDeletePopupComponent,
        TicketUpdatePopupComponent
    ],
    entryComponents: [
        TicketComponent,
        TicketDialogComponent,
        TicketPopupComponent,
        TicketDeleteDialogComponent,
        TicketDeletePopupComponent,
        TicketUpdateDialogComponent,
        TicketUpdatePopupComponent,
    ],
    providers: [
        TicketService,
        TicketPopupService,
        TicketResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussTicketModule {}
