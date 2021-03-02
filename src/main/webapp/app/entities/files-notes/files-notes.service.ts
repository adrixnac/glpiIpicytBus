import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SERVER_API_URL } from '../../app.constants';

import { FilesNotes } from './files-notes.model';
import { createRequestOption } from '../../shared';

export type EntityResponseType = HttpResponse<FilesNotes>;

@Injectable()
export class FilesNotesService {

    private resourceUrl =  SERVER_API_URL + 'api/files-notes';

    constructor(private http: HttpClient) { }

    create(filesNotes: FilesNotes): Observable<EntityResponseType> {
        const copy = this.convert(filesNotes);
        return this.http.post<FilesNotes>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(filesNotes: FilesNotes): Observable<EntityResponseType> {
        const copy = this.convert(filesNotes);
        return this.http.put<FilesNotes>(this.resourceUrl, copy, { observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<FilesNotes>(`${this.resourceUrl}/${id}`, { observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<FilesNotes[]>> {
        const options = createRequestOption(req);
        return this.http.get<FilesNotes[]>(this.resourceUrl, { params: options, observe: 'response' })
            .map((res: HttpResponse<FilesNotes[]>) => this.convertArrayResponse(res));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: FilesNotes = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<FilesNotes[]>): HttpResponse<FilesNotes[]> {
        const jsonResponse: FilesNotes[] = res.body;
        const body: FilesNotes[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to FilesNotes.
     */
    private convertItemFromServer(filesNotes: FilesNotes): FilesNotes {
        const copy: FilesNotes = Object.assign({}, filesNotes);
        return copy;
    }

    /**
     * Convert a FilesNotes to a JSON which can be sent to the server.
     */
    private convert(filesNotes: FilesNotes): FilesNotes {
        const copy: FilesNotes = Object.assign({}, filesNotes);
        return copy;
    }
}
