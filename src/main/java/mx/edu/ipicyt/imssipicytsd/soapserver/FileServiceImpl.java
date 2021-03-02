package mx.edu.ipicyt.imssipicytsd.soapserver;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileResponse;
import mx.edu.ipicyt.imssipicytsd.domain.FilesNotes;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.service.FileIpicytService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import  mx.edu.ipicyt.imssipicytsd.repository.FilesNotesRepository;
//import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;

@Service
public class FileServiceImpl implements FileService{
    private final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
    private final FileIpicytService fileIpicytService;
    private final FilesNotesRepository filesNotesRepository;

    public FileServiceImpl(FileIpicytService fileIpicytService,
                           FilesNotesRepository filesNotesRepository) {
        this.fileIpicytService = fileIpicytService;
        this.filesNotesRepository = filesNotesRepository;
    }

    @Override
    public GlpiResponse writeFileApplication(FileRequest FileRequest) {
        return null;
    }

    @Override
    public FileResponse processFileApplication(FileRequest fileRequest)  {
        log.debug("--- processFileApplication {} ----", fileRequest.getCompany());
        FilesNotes filesNotes= new FilesNotes();
        FileResponse fileResponse = new FileResponse();

        filesNotes = convertFileRequestToNote(fileRequest);
        FilesNotes result = filesNotesRepository.save(filesNotes);
        log.debug("--- processFileApplication result {} ----", result.toString());
        fileResponse = this.fileIpicytService.procesaFile(fileRequest, result);



        return null;
    }

    private FilesNotes convertFileRequestToNote(FileRequest fileRequest){
        FilesNotes filesNotes= new FilesNotes();
        log.debug("--- convertFileRequestToNote {} ----", fileRequest);
        filesNotes.setIdRemedyGlpi(fileRequest.getIdRemedyGlpi());
        filesNotes.setTypeTransaccion(fileRequest.getTypeTransaccion());
        filesNotes.setSubTypeTransaction(fileRequest.getSubTypeTransaction());
        filesNotes.setIdReferenciaCliente(fileRequest.getIdReferenciaCliente());
        filesNotes.setCompany(fileRequest.getCompany());
        filesNotes.setWorkLogSummary(fileRequest.getWorklogSummary());
        filesNotes.setWorkInfoNotes(fileRequest.getWorkInfoNotes());
        filesNotes.setAttachmentFileName1(fileRequest.getAttachmentFileName1());
        filesNotes.setAttachmentFileType1(fileRequest.getAttachmentFileType1());
        filesNotes.setAttachmentFileData1(fileRequest.getAttachmentFileName1()+"."+fileRequest.getAttachmentFileType1());

        filesNotes.setAttachmentFileName2(fileRequest.getAttachmentFileName2());
        filesNotes.setAttachmentFileType2(fileRequest.getAttachmentFileType2());
        filesNotes.setAttachmentFileData2(fileRequest.getAttachmentFileName2()+"."+fileRequest.getAttachmentFileType2());

        filesNotes.setAttachmentFileName2(fileRequest.getAttachmentFileName3());
        filesNotes.setAttachmentFileType2(fileRequest.getAttachmentFileType3());
        filesNotes.setAttachmentFileData2(fileRequest.getAttachmentFileName3()+"."+fileRequest.getAttachmentFileType3());
        log.debug("--- convertFileRequestToNote filesNotes {} ----", filesNotes);
        return filesNotes;

    }
}
