import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { ProductCat } from './product-cat.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<ProductCat>;

@Injectable()
export class ProductCatService {

    private resourceUrl =  SERVER_API_URL + 'api/product-cats';

    constructor(private http: HttpClient) { }

    create(productCat: ProductCat): Observable<EntityResponseType> {
        const copy = this.convert(productCat);
        return this.http.post<ProductCat>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(productCat: ProductCat): Observable<EntityResponseType> {
        const copy = this.convert(productCat);
        return this.http.put<ProductCat>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ProductCat>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<ProductCat[]>> {
        const options = createRequestOption(req);
        return this.http.get<ProductCat[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<ProductCat[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: ProductCat = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<ProductCat[]>): HttpResponse<ProductCat[]> {
        const jsonResponse: ProductCat[] = res.body;
        const body: ProductCat[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to ProductCat.
     */
    private convertItemFromServer(productCat: ProductCat): ProductCat {
        const copy: ProductCat = Object.assign({}, productCat);
        return copy;
    }

    /**
     * Convert a ProductCat to a JSON which can be sent to the server.
     */
    private convert(productCat: ProductCat): ProductCat {
        const copy: ProductCat = Object.assign({}, productCat);
        return copy;
    }
}
