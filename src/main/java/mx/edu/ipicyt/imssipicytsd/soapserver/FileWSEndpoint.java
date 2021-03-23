package mx.edu.ipicyt.imssipicytsd.soapserver;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class FileWSEndpoint {

    private static final String NAMESPACE_URI = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt";

    private FileService fileService;

    @Autowired
    public FileWSEndpoint(FileService fileService) {
        this.fileService = fileService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "FileRequest")
    @ResponsePayload
    public FileResponse fileApplication(@RequestPayload FileRequest fileApplicationRequest) throws Exception {
        if (fileApplicationRequest != null) {
            fileService.writeFileApplication(fileApplicationRequest);
        }

        return fileService.processFileApplication(fileApplicationRequest);
    }
}
