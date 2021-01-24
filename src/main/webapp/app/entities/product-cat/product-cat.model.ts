import { BaseEntity } from './../../shared';

export class ProductCat implements BaseEntity {
    constructor(
        public id?: number,
        public productCatGlpi?: string,
        public productCatGlpiId?: number,
        public productCatStructure?: string,
    ) {
    }
}
