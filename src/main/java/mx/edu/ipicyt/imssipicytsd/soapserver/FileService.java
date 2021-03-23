package mx.edu.ipicyt.imssipicytsd.soapserver;

import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileResponse;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;

public interface FileService {

    GlpiResponse writeFileApplication(FileRequest fileRequest);

    FileResponse processFileApplication(FileRequest fileRequest);
}
