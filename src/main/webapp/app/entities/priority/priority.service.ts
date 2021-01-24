import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { Priority } from './priority.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<Priority>;

@Injectable()
export class PriorityService {

    private resourceUrl =  SERVER_API_URL + 'api/priorities';

    constructor(private http: HttpClient) { }

    create(priority: Priority): Observable<EntityResponseType> {
        const copy = this.convert(priority);
        return this.http.post<Priority>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(priority: Priority): Observable<EntityResponseType> {
        const copy = this.convert(priority);
        return this.http.put<Priority>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<Priority>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<Priority[]>> {
        const options = createRequestOption(req);
        return this.http.get<Priority[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<Priority[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: Priority = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<Priority[]>): HttpResponse<Priority[]> {
        const jsonResponse: Priority[] = res.body;
        const body: Priority[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to Priority.
     */
    private convertItemFromServer(priority: Priority): Priority {
        const copy: Priority = Object.assign({}, priority);
        return copy;
    }

    /**
     * Convert a Priority to a JSON which can be sent to the server.
     */
    private convert(priority: Priority): Priority {
        const copy: Priority = Object.assign({}, priority);
        return copy;
    }
}
