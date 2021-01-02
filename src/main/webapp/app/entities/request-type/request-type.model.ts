import { BaseEntity } from './../../shared';

export class RequestType implements BaseEntity {
    constructor(
        public id?: number,
        public requestTypeRemedy?: string,
        public requestTypeGlpi?: string,
        public requestTypeGlpiId?: number,
    ) {
    }
}
