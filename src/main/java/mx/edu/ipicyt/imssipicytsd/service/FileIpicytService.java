package mx.edu.ipicyt.imssipicytsd.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileResponse;
import mx.edu.ipicyt.imssipicytsd.config.ApplicationProperties;
import mx.edu.ipicyt.imssipicytsd.domain.Session;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.IOException;
import org.apache.http.HttpEntity;
import java.io.File;
import  org.apache.http.entity.mime.MultipartEntityBuilder;


@Service
public class FileIpicytService {
    private final Logger log = LoggerFactory.getLogger(FileIpicytService.class);
    private final String glpiAuthorization;
    private final String glpiToken;
    private final String glpiURL;

    public FileIpicytService(ApplicationProperties glpi) {
        this.glpiURL = glpi.getGlpiUrl();
        this.glpiAuthorization = glpi.getGlpiAuthorization();
        this.glpiToken = glpi.getGlpiToken();
    }

    public FileResponse procesaFile(FileRequest fileRequest) {
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
            if (fileRequest.getAttachmentFileName1() == null || fileRequest.getAttachmentFileName2() == null || fileRequest.getAttachmentFileName3() == null ) {
                log.debug("procesa file sin archivo");
                jsonString = this.insertaNotas(fileRequest.getWorkInfoNotes(), fileRequest.getWorklogSummary(), fileRequest.getIdReferenciaCliente(), fileRequest.getIdRemedyGlpi());
                this.updateTIcketGLPI(jsonString, fileRequest.getIdReferenciaCliente());
            } else {
                if (!fileRequest.getAttachmentFileName1().isEmpty()) {
                    log.debug("procesa atachment 1");
                    try {
                        fileAPath = this.procesaFileToHost(fileRequest.getAttachmentFileName1(), fileRequest.getAttachmentFileData1(), fileRequest.getAttachmentFileType1());
                        fileA = fileRequest.getAttachmentFileName1() + "." + fileRequest.getAttachmentFileType1();
                        log.debug("--- FILE A ---- {}", fileAPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.insertaArchivos(fileRequest, fileAPath, fileA);
                }

                if (!fileRequest.getAttachmentFileName2().isEmpty()) {
                    log.debug("procesa atachment 2");
                    try {
                        fileBPath = this.procesaFileToHost(fileRequest.getAttachmentFileName2(), fileRequest.getAttachmentFileData2(), fileRequest.getAttachmentFileType2());
                        fileB = fileRequest.getAttachmentFileName2() + "." + fileRequest.getAttachmentFileType2();
                        log.debug("--- FILE B ---- {}", fileBPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.insertaArchivos(fileRequest, fileBPath, fileB);
                }

                if (!fileRequest.getAttachmentFileName3().isEmpty()) {
                    log.debug("procesa atachment 3");
                    try {
                        fileCPath = this.procesaFileToHost(fileRequest.getAttachmentFileName3(), fileRequest.getAttachmentFileData3(), fileRequest.getAttachmentFileType3());
                        fileC = fileRequest.getAttachmentFileName3() + "." + fileRequest.getAttachmentFileType3();
                        log.debug("--- FILE C ---- {}", fileCPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.insertaArchivos(fileRequest, fileCPath, fileC);
                }

            }
        }
        catch(NullPointerException e)
        {
            System.out.print("Caught NullPointerException");
        }


        return fileResponse;
    }

    private String procesaFileToHost(String attachmentFileName1, byte[] attachmentFileData1, String attachmentFileType1) throws IOException {
        String urlPathFile = "/tmp/" + attachmentFileName1.trim().toLowerCase() + "." + attachmentFileType1.trim().toLowerCase();
        FileUtils.writeByteArrayToFile(new File(urlPathFile), attachmentFileData1);
        return urlPathFile;

    }

    private void insertaArchivos(FileRequest fileRequest, String fileAPath, String fileA) {
        String token = this.GetSession().getSession_token();
        log.debug("PROCESA FILE  insertaArchivos {}", fileA);
        try {
           /* HttpEntity entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .addTextBody("uploadManifest",
                    "{ \"input\": { \"itemtype\": \"Ticket\", " +
                        "\"items_id\": \" "+fileRequest.getIdReferenciaCliente()+" \", " +
                        "\"is_private\": \"0\"," +
                        "\"requesttypes_id\": \"1\", " +
                        "\"content\": \"\"+idRemedyGlpi+\":\"+worklogSummary+\"<b>\"+workInfoNotes+\"\"," +
                        "\"_filename\" : [\""+fileA+"\"]}};" +
                        "type=application/json")
            .addTextBody("filename[0]", fileAPath)
            .build();*/

            HttpEntity entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .addTextBody("uploadManifest", "{ \"input\": { \"itemtype\": \"Ticket\", \"items_id\": \"2021010134\", \"is_private\": \"0\",\"requesttypes_id\": \"1\", \"content\": \"Followup contents\",\"_filename\" : [\"file.txt\"]}};type=application/json")
            .addTextBody("filename[0]", "@/tmp/prueba.pdf")
            .build();


        // Create request
        Content content = Request.Post("http://10.100.10.3/apirest.php/Ticket/"+fileRequest.getIdReferenciaCliente()+"/ITILFollowup")

            // Add headers
            .addHeader("Content-Type", "multipart/form-data")
            .addHeader("Session-Token", token)
            .addHeader("App-Token", "Dd&WSgu9qGn")
            .addHeader("Authorization", "Basic aG90bGluZXIucmVzdDpxd2VyMTIzNA==")

            // Add body
            .body(entity)

            // Fetch request and return content
            .execute().returnContent();

        // Print content
        System.out.println(content);
    }
    catch (IOException e) { System.out.println(e); }


    }

    private void updateTIcketGLPI(String jsonString, String idReferenciaCliente) {
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
        }
        System.out.println("Contenido post"+ content);
        log.debug("Contenido Ipicyt: ", content.toString());

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
