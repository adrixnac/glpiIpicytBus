import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { Urgency } from './urgency.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<Urgency>;

@Injectable()
export class UrgencyService {

    private resourceUrl =  SERVER_API_URL + 'api/urgencies';

    constructor(private http: HttpClient) { }

    create(urgency: Urgency): Observable<EntityResponseType> {
        const copy = this.convert(urgency);
        return this.http.post<Urgency>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(urgency: Urgency): Observable<EntityResponseType> {
        const copy = this.convert(urgency);
        return this.http.put<Urgency>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<Urgency>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<Urgency[]>> {
        const options = createRequestOption(req);
        return this.http.get<Urgency[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<Urgency[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: Urgency = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<Urgency[]>): HttpResponse<Urgency[]> {
        const jsonResponse: Urgency[] = res.body;
        const body: Urgency[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to Urgency.
     */
    private convertItemFromServer(urgency: Urgency): Urgency {
        const copy: Urgency = Object.assign({}, urgency);
        return copy;
    }

    /**
     * Convert a Urgency to a JSON which can be sent to the server.
     */
    private convert(urgency: Urgency): Urgency {
        const copy: Urgency = Object.assign({}, urgency);
        return copy;
    }
}
