import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { SubtypeTransaction } from './subtype-transaction.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<SubtypeTransaction>;

@Injectable()
export class SubtypeTransactionService {

    private resourceUrl =  SERVER_API_URL + 'api/subtype-transactions';

    constructor(private http: HttpClient) { }

    create(subtypeTransaction: SubtypeTransaction): Observable<EntityResponseType> {
        const copy = this.convert(subtypeTransaction);
        return this.http.post<SubtypeTransaction>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(subtypeTransaction: SubtypeTransaction): Observable<EntityResponseType> {
        const copy = this.convert(subtypeTransaction);
        return this.http.put<SubtypeTransaction>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<SubtypeTransaction>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<SubtypeTransaction[]>> {
        const options = createRequestOption(req);
        return this.http.get<SubtypeTransaction[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<SubtypeTransaction[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: SubtypeTransaction = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<SubtypeTransaction[]>): HttpResponse<SubtypeTransaction[]> {
        const jsonResponse: SubtypeTransaction[] = res.body;
        const body: SubtypeTransaction[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to SubtypeTransaction.
     */
    private convertItemFromServer(subtypeTransaction: SubtypeTransaction): SubtypeTransaction {
        const copy: SubtypeTransaction = Object.assign({}, subtypeTransaction);
        return copy;
    }

    /**
     * Convert a SubtypeTransaction to a JSON which can be sent to the server.
     */
    private convert(subtypeTransaction: SubtypeTransaction): SubtypeTransaction {
        const copy: SubtypeTransaction = Object.assign({}, subtypeTransaction);
        return copy;
    }
}
