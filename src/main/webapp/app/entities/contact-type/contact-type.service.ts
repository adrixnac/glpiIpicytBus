import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { ContactType } from './contact-type.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<ContactType>;

@Injectable()
export class ContactTypeService {

    private resourceUrl =  SERVER_API_URL + 'api/contact-types';

    constructor(private http: HttpClient) { }

    create(contactType: ContactType): Observable<EntityResponseType> {
        const copy = this.convert(contactType);
        return this.http.post<ContactType>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(contactType: ContactType): Observable<EntityResponseType> {
        const copy = this.convert(contactType);
        return this.http.put<ContactType>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ContactType>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<ContactType[]>> {
        const options = createRequestOption(req);
        return this.http.get<ContactType[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<ContactType[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: ContactType = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<ContactType[]>): HttpResponse<ContactType[]> {
        const jsonResponse: ContactType[] = res.body;
        const body: ContactType[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to ContactType.
     */
    private convertItemFromServer(contactType: ContactType): ContactType {
        const copy: ContactType = Object.assign({}, contactType);
        return copy;
    }

    /**
     * Convert a ContactType to a JSON which can be sent to the server.
     */
    private convert(contactType: ContactType): ContactType {
        const copy: ContactType = Object.assign({}, contactType);
        return copy;
    }
}
