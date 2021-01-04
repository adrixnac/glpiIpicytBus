import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { Impact } from './impact.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<Impact>;

@Injectable()
export class ImpactService {

    private resourceUrl =  SERVER_API_URL + 'api/impacts';

    constructor(private http: HttpClient) { }

    create(impact: Impact): Observable<EntityResponseType> {
        const copy = this.convert(impact);
        return this.http.post<Impact>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(impact: Impact): Observable<EntityResponseType> {
        const copy = this.convert(impact);
        return this.http.put<Impact>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<Impact>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<Impact[]>> {
        const options = createRequestOption(req);
        return this.http.get<Impact[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<Impact[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: Impact = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<Impact[]>): HttpResponse<Impact[]> {
        const jsonResponse: Impact[] = res.body;
        const body: Impact[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to Impact.
     */
    private convertItemFromServer(impact: Impact): Impact {
        const copy: Impact = Object.assign({}, impact);
        return copy;
    }

    /**
     * Convert a Impact to a JSON which can be sent to the server.
     */
    private convert(impact: Impact): Impact {
        const copy: Impact = Object.assign({}, impact);
        return copy;
    }
}
