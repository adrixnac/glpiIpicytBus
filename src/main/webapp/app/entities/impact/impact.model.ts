import { BaseEntity } from './../../shared';

export class Impact implements BaseEntity {
    constructor(
        public id?: number,
        public impactRemedy?: string,
        public impactGlpi?: string,
        public impactGlpiId?: string,
    ) {
    }
}
