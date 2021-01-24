import { BaseEntity } from './../../shared';

export class Priority implements BaseEntity {
    constructor(
        public id?: number,
        public priorityRemedy?: string,
        public priorityGlpi?: string,
        public priorityGlpiId?: number,
        public urgency?: BaseEntity,
        public impact?: BaseEntity,
    ) {
    }
}
