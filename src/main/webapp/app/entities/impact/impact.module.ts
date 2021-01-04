import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { IpicytBussSharedModule } from '../../shared';
import {
    ImpactService,
    ImpactPopupService,
    ImpactComponent,
    ImpactDetailComponent,
    ImpactDialogComponent,
    ImpactPopupComponent,
    ImpactDeletePopupComponent,
    ImpactDeleteDialogComponent,
    impactRoute,
    impactPopupRoute,
} from './';

const ENTITY_STATES = [
    ...impactRoute,
    ...impactPopupRoute,
];

@NgModule({
    imports: [
        IpicytBussSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        ImpactComponent,
        ImpactDetailComponent,
        ImpactDialogComponent,
        ImpactDeleteDialogComponent,
        ImpactPopupComponent,
        ImpactDeletePopupComponent,
    ],
    entryComponents: [
        ImpactComponent,
        ImpactDialogComponent,
        ImpactPopupComponent,
        ImpactDeleteDialogComponent,
        ImpactDeletePopupComponent,
    ],
    providers: [
        ImpactService,
        ImpactPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussImpactModule {}
