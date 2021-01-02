import { BaseEntity } from './../../shared';

export class ContactType implements BaseEntity {
    constructor(
        public id?: number,
        public contactTypeRemedy?: string,
        public contactTypeGlpi?: string,
        public contactTypeGlpiId?: number,
    ) {
    }
}
