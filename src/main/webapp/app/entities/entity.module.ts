import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { IpicytBussTicketModule } from './ticket/ticket.module';
import { IpicytBussTransactionModule } from './transaction/transaction.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        IpicytBussTicketModule,
        IpicytBussTransactionModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class IpicytBussEntityModule {}
