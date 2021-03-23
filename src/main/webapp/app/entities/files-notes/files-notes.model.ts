import { BaseEntity } from './../../shared';

export class FilesNotes implements BaseEntity {
    constructor(
        public id?: number,
        public idRemedyGlpi?: string,
        public typeTransaccion?: string,
        public subTypeTransaction?: string,
        public idReferenciaCliente?: string,
        public company?: string,
        public workLogSummary?: string,
        public workInfoNotes?: string,
        public attachmentFileName1?: string,
        public attachmentFileType1?: string,
        public attachmentFileData1?: string,
        public attachmentFileName2?: string,
        public attachmentFileType2?: string,
        public attachmentFileData2?: string,
        public attachmentFileName3?: string,
        public attachmentFileType3?: string,
        public attachmentFileData3?: string,
        public createDate?: any,
    ) {
    }
}
