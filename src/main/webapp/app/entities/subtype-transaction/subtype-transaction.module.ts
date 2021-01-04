import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IpicytBussSharedModule } from '../../shared';
import {
    SubtypeTransactionService,
    SubtypeTransactionPopupService,
    SubtypeTransactionComponent,
    SubtypeTransactionDetailComponent,
    SubtypeTransactionDialogComponent,
    SubtypeTransactionPopupComponent,
    SubtypeTransactionDeletePopupComponent,
    SubtypeTransactionDeleteDialogComponent,
    subtypeTransactionRoute,
    subtypeTransactionPopupRoute,
} from './';

const ENTITY_STATES = [
    ...subtypeTransactionRoute,
    ...subtypeTransactionPopupRoute,
];

@NgModule({
    imports: [
        IpicytBussSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        SubtypeTransactionComponent,
        SubtypeTransactionDetailComponent,
        SubtypeTransactionDialogComponent,
        SubtypeTransactionDeleteDialogComponent,
        SubtypeTransactionPopupComponent,
        SubtypeTransactionDeletePopupComponent,
    ],
    entryComponents: [
        SubtypeTransactionComponent,
        SubtypeTransactionDialogComponent,
        SubtypeTransactionPopupComponent,
        SubtypeTransactionDeleteDialogComponent,
        SubtypeTransactionDeletePopupComponent,
    ],
    providers: [
        SubtypeTransactionService,
        SubtypeTransactionPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussSubtypeTransactionModule {}
