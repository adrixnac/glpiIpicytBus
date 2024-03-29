package mx.edu.ipicyt.imssipicytsd.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileResponse;
import mx.edu.ipicyt.imssipicytsd.config.ApplicationProperties;
import mx.edu.ipicyt.imssipicytsd.domain.FilesNotes;
import mx.edu.ipicyt.imssipicytsd.domain.Session;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;


@Service
public class FileIpicytService {
    private final Logger log = LoggerFactory.getLogger(FileIpicytService.class);
    private final String glpiAuthorization;
    private final String glpiToken;
    private final String glpiURL;
    private final String glpiFilesUrl;
    
    private static final String BOUNDARY = "------------------------f34ed144c46e1ca7";

    public FileIpicytService(ApplicationProperties glpi) {
        this.glpiURL = glpi.getGlpiUrl();
        this.glpiAuthorization = glpi.getGlpiAuthorization();
        this.glpiToken = glpi.getGlpiToken();
        this.glpiFilesUrl = glpi.getGlpiFilesUrl();
    }

    public FileResponse procesaFile(FileRequest fileRequest, FilesNotes result) {
        log.debug("PROCESA FILE {}", fileRequest.toString());
        FileResponse fileResponse = new FileResponse();
        String jsonString = "";
        String fileAPath= "";
        String fileBPath= "";
        String fileCPath= "";
        String ptr = null;
        String fileA= "";
        String fileB= "";
        String fileC= "";

//        log.debug("fileRequest.getAttachmentFileData1() {}", fileRequest.getAttachmentFileName1().length());
        /* la nota no tiene un archivo*/
        try {
            if (fileRequest.getAttachmentFileName1() == null && fileRequest.getAttachmentFileName2() == null && fileRequest.getAttachmentFileName3() == null ) {
                log.debug("procesa file sin archivo");
                jsonString = this.insertaNotas(fileRequest.getWorkInfoNotes(), fileRequest.getWorklogSummary(), fileRequest.getIdReferenciaCliente(), fileRequest.getIdRemedyGlpi());
                fileResponse =this.updateTIcketGLPI(jsonString, fileRequest.getIdReferenciaCliente());
            } else {
                if (!fileRequest.getAttachmentFileName1().isEmpty()) {
                    log.debug("procesa atachment 1");
                    try {
                        fileAPath = this.procesaFileToHost(fileRequest.getIdRemedyGlpi(), fileRequest.getAttachmentFileName1(), fileRequest.getAttachmentFileData1());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileResponse = this.insertaArchivos(fileRequest, fileAPath, result);
                }


            }
        }
        catch(NullPointerException e)
        {
            System.out.print("Caught NullPointerException");
        }


        return fileResponse;
    }

    private String procesaFileToHost(String getIdRemedyGlpi , String attachmentFileName1, byte[] attachmentFileData1) throws IOException {
        log.debug("procesaFileToHost.attachmentFileName1 {}", attachmentFileName1);
        Files.createDirectories(Paths.get("/tmp/storage/"+ getIdRemedyGlpi+"/"));
        String urlPathFile = "/tmp/storage/"+ getIdRemedyGlpi+"/" + attachmentFileName1.trim().toLowerCase();
        FileUtils.writeByteArrayToFile(new File(urlPathFile), attachmentFileData1);
        return urlPathFile;

    }

    private FileResponse insertaArchivos(FileRequest fileRequest, String fileAttachment, FilesNotes result) {
        fileRequest.setWorklogSummary(fileRequest.getWorklogSummary() + "<br /><strong>Para consultar el archivo visite el siguiente enlace</strong>:<br><a target='_blank' href='"+ glpiFilesUrl + result.getId()+"'>GLPI-Remedy Bus</a> " );
        String jsonString = this.insertaNotas(fileRequest.getWorkInfoNotes(), fileRequest.getWorklogSummary(), fileRequest.getIdReferenciaCliente(), fileRequest.getIdRemedyGlpi());
        return this.updateTIcketGLPI(jsonString, fileRequest.getIdReferenciaCliente());

    }

    private FileResponse updateTIcketGLPI(String jsonString, String idReferenciaCliente) {
        FileResponse fileResponse = new FileResponse();
        log.debug("updateTIcketGLPI jsonString {}", jsonString);
        log.debug("updateTIcketGLPI idReferenciaCliente {}", idReferenciaCliente);
        String token = this.GetSession().getSession_token();
        Content content = null;
        try {
            content = Request.Post("http://10.100.10.3/apirest.php/Ticket/"+idReferenciaCliente+"/ITILFollowup")
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Session-Token", token)
                                .addHeader("App-Token", "Dd&WSgu9qGn")
                                .addHeader("Authorization", "Basic aG90bGluZXIucmVzdDpxd2VyMTIzNA==")
                                .bodyString(jsonString, ContentType.APPLICATION_JSON)
                                .execute().returnContent();

        } catch (IOException e) {
            e.printStackTrace();
            fileResponse.setValue("NULL");
            fileResponse.setGlpiTicketsId("");
            fileResponse.setResultMessage(e.getCause().toString());
            fileResponse.setIdReferenciaCliente(idReferenciaCliente);
            fileResponse.setStatusTransaccionId("ERROR");
            return fileResponse;
        }

        System.out.println("Contenido post"+ content);
        log.debug("Contenido Ipicyt: ", content.toString());
        fileResponse.setValue("NULL");
        fileResponse.setGlpiTicketsId("");
        fileResponse.setResultMessage(content.toString());
        fileResponse.setIdReferenciaCliente(idReferenciaCliente);
        fileResponse.setStatusTransaccionId("SUCCESS");

        return fileResponse;

    }


    private String insertaNotas(String workInfoNotes, String worklogSummary, String idReferenciaCliente, String idRemedyGlpi) {
        log.debug("insertaNotas  workInfoNotes {}", workInfoNotes);
        log.debug("insertaNotas  worklogSummary {}", worklogSummary);
        log.debug("insertaNotas  idReferenciaCliente {}", idReferenciaCliente);
        log.debug("insertaNotas  idRemedyGlpi {}", idRemedyGlpi);
        String json= "{\"input\": {\"items_id\": \""+idRemedyGlpi+"\",\"itemtype\": \"Ticket\",\"is_private\": \"0\",\"requesttypes_id\": \"1\",\"content\":\""+idRemedyGlpi+":"+worklogSummary+"<br>"+workInfoNotes+ "\"}}";

        log.debug("JSON RESULTADO {}", json);
        return json;
    }



    private void creaJsonArchivos(FileRequest fileRequest){
    }

    private Session GetSession(){
        // Inicia Sesión (GET )
        log.debug("GLPI get session ");
        log.debug("Basic {} ", this.glpiAuthorization);
        log.debug("this.glpiToken {}", this.glpiToken);

        try {

            // Create request
            Content content = Request.Get(this.glpiURL + "/initSession")

                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic " + this.glpiAuthorization)
                .addHeader("App-Token", this.glpiToken)
                .execute().returnContent();


            // Print content
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(content.toString());// response will be the json String
            Session session = gson.fromJson(object, Session.class);
            return session;

        }
        catch (IOException e) { System.out.println(e); }

        return null;
    }

    private void CloseSession(String token) {

        // Termina Sesión (GET )

        try {

            // Create request
            Content content = Request.Get(this.glpiURL + "/killSession/")

                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Session-Token", token)
                .addHeader("Authorization", "Basic " + this.glpiAuthorization)
                .addHeader("App-Token", this.glpiToken)

                // Fetch request and return content
                .execute().returnContent();

            // Print content
            System.out.println(content);
        }
        catch (IOException e) { System.out.println(e); }
    }


}
