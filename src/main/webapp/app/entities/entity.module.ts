import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { IpicytBussTicketModule } from './ticket/ticket.module';
import { IpicytBussTransactionModule } from './transaction/transaction.module';
import { IpicytBussSubtypeTransactionModule } from './subtype-transaction/subtype-transaction.module';
import { IpicytBussProductCatModule } from './product-cat/product-cat.module';
import { IpicytBussRequestTypeModule } from './request-type/request-type.module';
import { IpicytBussContactTypeModule } from './contact-type/contact-type.module';
import { IpicytBussImpactModule } from './impact/impact.module';
import { IpicytBussUrgencyModule } from './urgency/urgency.module';
import { IpicytBussPriorityModule } from './priority/priority.module';
import { IpicytBussFilesNotesModule } from './files-notes/files-notes.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        IpicytBussTicketModule,
        IpicytBussTransactionModule,
        IpicytBussSubtypeTransactionModule,
        IpicytBussProductCatModule,
        IpicytBussRequestTypeModule,
        IpicytBussContactTypeModule,
        IpicytBussImpactModule,
        IpicytBussUrgencyModule,
        IpicytBussPriorityModule,
        IpicytBussFilesNotesModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussEntityModule {}
