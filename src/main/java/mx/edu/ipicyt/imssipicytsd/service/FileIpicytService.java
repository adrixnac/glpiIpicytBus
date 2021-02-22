package mx.edu.ipicyt.imssipicytsd.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.FileResponse;
import mx.edu.ipicyt.imssipicytsd.config.ApplicationProperties;
import mx.edu.ipicyt.imssipicytsd.domain.Session;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileIpicytService {
    private final Logger log = LoggerFactory.getLogger(FileIpicytService.class);
    private final String glpiAuthorization;
    private final String glpiToken;
    private final String glpiURL;
    private static final String BOUNDARY = "------------------------f34ed144c46e1ca7";

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
                    this.insertaArchivos(fileRequest, fileAPath);
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

    private void insertaArchivos(FileRequest fileRequest, String fileAttachment) {
        log.debug("insertaArchivos - fileRequest {}",fileRequest );
        log.debug("insertaArchivos - fileAPath {}",fileAttachment );
        String token = this.GetSession().getSession_token();
        File file = new File(fileAttachment);
        String urlString = "http://0.0.0.0/apirest.php/Ticket/"+fileRequest.getIdRemedyGlpi()+"/ITILFollowup";
        HttpClient client = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(urlString) ;
        MultipartEntity multiPartEntity = new MultipartEntity();

        try {
            multiPartEntity.addPart("uploadManifest",new StringBody("{\"input\": {\"items_id\":\"2021010060\",\"name\": \"Uploaded document\", \"requesttypes_id\":\"1\",\"content\": \"Contenido eddy\", \"itemtype\": \"Ticket\" ,\"_filename\" : [\"prueba.pdf\"]}};type=application/json"));

            FileBody fileBody = new FileBody(file, "application/octet-stream") ;
            multiPartEntity.addPart("filename[0]", fileBody);
            multiPartEntity.addPart("fileDescription", new StringBody("archivo Remedy")) ;
            multiPartEntity.addPart("fileName", new StringBody("prueba.pdf")) ;
            postRequest.setEntity(multiPartEntity) ;
            postRequest.addHeader("Content-Type", "multipart/form-data;boundary="+BOUNDARY);
            postRequest.addHeader("Session-Token", token);
            postRequest.addHeader("App-Token", "Dd&WSgu9qGn");
            postRequest.addHeader("Authorization", "Basic aG90bGluZXIucmVzdDpxd2VyMTIzNA==");


            log.debug("---postRequest getRequestLine --- {}", postRequest.getRequestLine());
            log.debug("---postRequest getMethod --- {}", postRequest.getMethod());
            HttpResponse response = client.execute(postRequest) ;
            log.debug("---insertaArchivos response --- {}", response.toString());

            if (response != null)
            {
                System.out.println(response.getStatusLine().getStatusCode());
            }
        } catch (UnsupportedEncodingException e) {
            log.debug("---insertaArchivos catch 1  ---");
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            log.debug("---insertaArchivos catch 2  --- ");
            e.printStackTrace();
        } catch (IOException e) {
            log.debug("---insertaArchivos catch 3  ---");
            e.printStackTrace();
        }

    }

    private void updateTIcketGLPI(String jsonString, String idReferenciaCliente) {
        log.debug("updateTIcketGLPI jsonString {}", jsonString);
        log.debug("updateTIcketGLPI idReferenciaCliente {}", idReferenciaCliente);
        String token = this.GetSession().getSession_token();
        Content content = null;
        try {
            content = Request.Post("http://localhost/apirest.php/Ticket/"+idReferenciaCliente+"/ITILFollowup")
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
