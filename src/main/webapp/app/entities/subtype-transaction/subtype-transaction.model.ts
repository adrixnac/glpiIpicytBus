import { BaseEntity } from './../../shared';

export class SubtypeTransaction implements BaseEntity {
    constructor(
        public id?: number,
        public subTypeTransactionRemedy?: string,
        public subTypeTransactionGlpi?: string,
        public subTypeTransactionId?: number,
    ) {
    }
}
