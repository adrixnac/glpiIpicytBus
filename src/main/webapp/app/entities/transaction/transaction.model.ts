import { BaseEntity } from './../../shared';

export class Transaction implements BaseEntity {
    constructor(
        public id?: number,
        public transactionRemedy?: string,
        public transactionGlpi?: string,
        public transactionGlpiId?: number,
    ) {
    }
}
