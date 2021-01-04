import { BaseEntity } from './../../shared';

export class Urgency implements BaseEntity {
    constructor(
        public id?: number,
        public urgencyRemedy?: string,
        public urgencyGlpi?: string,
        public urgencyGlpiId?: number,
    ) {
    }
}
