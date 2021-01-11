package mx.edu.ipicyt.imssipicytsd.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import mx.edu.ipicyt.imssipicytsd.config.ApplicationProperties;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.domain.Session;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import mx.edu.ipicyt.imssipicytsd.service.util.BussinessRules;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class TicketIpicytService {
    private static final Logger log = LoggerFactory.getLogger(TicketIpicytService.class);
    private final TicketRepository ticketRepository;
    private final String glpiAuthorization;
    private final String glpiToken;
    private final String glpiURL;
    private final BussinessRules bussinessRules;

    public TicketIpicytService(TicketRepository ticketRepository, ApplicationProperties glpi, BussinessRules bussinessRules) {
        this.ticketRepository = ticketRepository;
        this.glpiURL = glpi.getGlpiUrl();
        this.glpiAuthorization = glpi.getGlpiAuthorization();
        this.glpiToken = glpi.getGlpiToken();
        this.bussinessRules = bussinessRules;
    }

    public GlpiResponse createTicket(@Valid @RequestBody Ticket ticket) throws URISyntaxException {
        log.debug("Contenido Ipicyt createTicket: ", ticket.toString());
        String jsonArmed = this.bussinessRules.JsonGLPI(ticket);
        log.debug("JSON ARMADO {}",jsonArmed);
        String token = "";

        token = this.GetSession().getSession_token();

        Content content = null;
        try {
            content = Request.Post("http://10.100.10.3/apirest.php/Ticket/")

                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Session-Token", token)
                .addHeader("App-Token", "Dd&WSgu9qGn")
                .addHeader("Authorization", "Basic aG90bGluZXIucmVzdDpxd2VyMTIzNA==")

                // Add body
                .bodyString(jsonArmed, ContentType.APPLICATION_JSON)

                // Fetch request and return content
                .execute().returnContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print content
            System.out.println("Contenido post"+ content);
            log.debug("Contenido Ipicyt: ", content.toString());

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            if(content.toString() != null ) {
                JsonObject object = (JsonObject) parser.parse(content.toString());// response will be the json String
                GlpiResponse glpiResponse = gson.fromJson(object, GlpiResponse.class);
                Ticket ticketUpdate = ticketRepository.findOne(ticket.getId());
                log.debug("Entra al ticketRepository:  {}", ticketUpdate.toString());
                ticketUpdate.setIdGlpi(glpiResponse.getId());
                Ticket result = ticketRepository.save(ticketUpdate);
                log.debug("Entra al result:  {}", result.toString());

                return glpiResponse;
            }

        this.CloseSession(token);
        return null;
    }

    public GlpiResponse updateTicket( @Valid @RequestBody Ticket ticket ) {
        log.debug("Contenido Ipicyt UPDATE TICKET: {}", ticket.toString());
        String jsonArmed = this.bussinessRules.JsonGLPI(ticket);
        log.debug("JSON ARMADO {}",jsonArmed);
        String token = "";
        token = this.GetSession().getSession_token();
        Content content = null;
        // setGlpiTicketsId


        try {
            content = Request.Put("http://10.100.10.3/apirest.php/Ticket/"+ticket.getIdGlpi())

                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Session-Token", token)
                .addHeader("App-Token", "Dd&WSgu9qGn")
                .addHeader("Authorization", "Basic aG90bGluZXIucmVzdDpxd2VyMTIzNA==")

                // Add body
                .bodyString(jsonArmed, ContentType.APPLICATION_JSON)

                // Fetch request and return content
                .execute().returnContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Contenido PUT"+ content);
        log.debug("Contenido Ipicyt: ", content.toString());

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        if(content.toString() != null ) {

            GlpiResponse glpiResponse = new GlpiResponse();
            glpiResponse.setType_transaccion("UPDATE");
            glpiResponse.setStatus_transaccion("COMPLETADO");
            glpiResponse.setResult_message("Actualización del ticket"+ ticket.toString());
            glpiResponse.setId_referencia_cliente(ticket.getIdReferenciaCliente());
            glpiResponse.setGlpi_tickets_id(ticket.getIdGlpi());
            glpiResponse.setMessage("Ticket actualizado");

            return glpiResponse;
        }

        this.CloseSession(token);
        return null;

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
