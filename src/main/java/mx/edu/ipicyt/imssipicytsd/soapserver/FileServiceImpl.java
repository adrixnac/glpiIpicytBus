package mx.edu.ipicyt.imssipicytsd.soapserver;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileResponse;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.service.FileIpicytService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class FileServiceImpl implements FileService{
    private final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
    private final FileIpicytService fileIpicytService;

    public FileServiceImpl(FileIpicytService fileIpicytService) {
        this.fileIpicytService = fileIpicytService;
    }

    @Override
    public GlpiResponse writeFileApplication(FileRequest FileRequest) {
        return null;
    }

    @Override
    public FileResponse processFileApplication(FileRequest fileRequest)  {
        log.debug("--- processFileApplication {} ----", fileRequest.getCompany());
        FileResponse fileResponse = new FileResponse();
        fileResponse = this.fileIpicytService.procesaFile(fileRequest);
        return null;
    }
}
