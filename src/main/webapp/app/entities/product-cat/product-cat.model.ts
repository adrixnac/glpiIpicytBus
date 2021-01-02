import { BaseEntity } from './../../shared';

export class ProductCat implements BaseEntity {
    constructor(
        public id?: number,
        public productCatRemedy?: string,
        public productCatGlpi?: string,
        public productCatGlpiId?: string,
    ) {
    }
}
