import { BaseEntity } from './../../shared';

export class Ticket implements BaseEntity {
    constructor(
        public id?: number,
        public idRemedyGlpi?: string,
        public subTypeTransaction?: string,
        public idReferenciaCliente?: string,
        public company?: string,
        public prodCat01?: string,
        public prodCat02?: string,
        public prodCat03?: string,
        public nombreProducto?: string,
        public catOp01?: string,
        public catOp02?: string,
        public catOp03?: string,
        public glpiTicketsRequesttypesId?: string,
        public contactType?: string,
        public impact?: string,
        public urgency?: string,
        public glpiTicketsName?: string,
        public glpiTicketsContent?: string,
        public notes?: string,
        public actualSysDate?: any,
        public caller?: string,
        public callerEmail?: string,
        public callerPhone?: string,
        public typeTransaccion?: string,
        public idGlpi?: string,
        public idtypeReqSol?: string,
        public idPriority?: string,
    ) {
    }
}
