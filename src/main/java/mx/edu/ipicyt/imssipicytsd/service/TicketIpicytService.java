package mx.edu.ipicyt.imssipicytsd.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import mx.edu.ipicyt.imssipicytsd.config.ApplicationProperties;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.domain.Session;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
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

    public TicketIpicytService(TicketRepository ticketRepository, ApplicationProperties glpi) {
        this.ticketRepository = ticketRepository;
        this.glpiURL = glpi.getGlpiUrl();
        this.glpiAuthorization = glpi.getGlpiAuthorization();
        this.glpiToken = glpi.getGlpiToken();
    }

    public GlpiResponse createTicket(@Valid @RequestBody Ticket ticket) throws URISyntaxException {
        log.debug("Contenido Ipicyt createTicket: ", ticket.toString());
        String token = "";

        log.debug("Session-Token {}", this.glpiToken);
        log.debug("App-Token {}", this.glpiToken);
        log.debug("Authorization {}", this.glpiAuthorization);

        token = this.GetSession().getSession_token();
        try {

            log.debug("Entra al try:  {}", token);

            Content content = Request.Post(this.glpiURL + "/Ticket/")
                .addHeader("Content-Type", "application/json")
                .addHeader("Session-Token", token)
                .addHeader("App-Token", this.glpiToken)
                .addHeader("Authorization", "Basic " + this.glpiAuthorization)
                .bodyString(this.generateJSON(ticket), ContentType.APPLICATION_JSON)
                .execute().returnContent();

            // Print content
            System.out.println("Contenido post"+ content);
            log.debug("Contenido Ipicyt: ", content.toString());

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(content.toString());// response will be the json String
            GlpiResponse glpiResponse = gson.fromJson(object, GlpiResponse.class);
            Ticket ticketUpdate = ticketRepository.findOne(ticket.getId());
            log.debug("Entra al ticketRepository:  {}", ticketUpdate.toString());
            ticketUpdate.setIdGlpi(glpiResponse.getId());
            Ticket result = ticketRepository.save(ticketUpdate);
            log.debug("Entra al result:  {}", result.toString());

            return glpiResponse;
        }
        catch (IOException | JSONException e) { System.out.println(e); }

        this.CloseSession(token);
        return null;
    }

    public GlpiResponse updateTicket( Ticket ticket){
        log.debug("ticket a actualizar: {}",ticket.getIdGlpi());
        String token = "";
        token = this.GetSession().getSession_token();
        try {

            // Create request
            Content content = Request.Put(this.glpiURL + "/Ticket/" + ticket.getIdGlpi())

                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Session-Token", token)
                .addHeader("Authorization", "Basic " + this.glpiAuthorization)
                .addHeader("App-Token", this.glpiToken)
                // Add body
                .bodyString(this.generateJSON(ticket), ContentType.APPLICATION_JSON)
                // Fetch request and return content
                .execute().returnContent();

            // Print content
            System.out.println("Contenido post"+ content);
            log.debug("Contenido Ipicyt: ", content.toString());


        }
        catch (IOException | JSONException e) { System.out.println(e); }

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

    private String generateJSON(Ticket ticket) throws JSONException {

        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("name",ticket.getIdRemedyGlpi() + "-"+ ticket.getNombreProducto()+" - "+ ticket.getGlpiTicketsName());
        //item.put("date",ticket.getActualSysDate());
        item.put("status",ticket.getSubTypeTransaction());
        item.put("users_id_recipient","");
        item.put("content",ticket.getGlpiTicketsContent());
        item.put("requesttypes_id","");
        item.put("urgency",ticket.getUrgency());
        item.put("impact",ticket.getImpact());
        item.put("priority",ticket.getGlpiTicketsRequesttypesId());
        item.put("itilcategories_id",ticket.getProdCat01());
        item.put("global_validation","1");
        item.put("content",ticket.getGlpiTicketsContent());
        array.put(item);
        json.put("input",array);
        String tmp=json.toString();
        tmp = tmp.replace("[","");
        tmp = tmp.replace("]","");
        log.debug("JSON resultado {}", tmp);
        return tmp;
    }



}
