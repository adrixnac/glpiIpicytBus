package mx.edu.ipicyt.imssipicytsd.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.domain.Session;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
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

    public TicketIpicytService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public GlpiResponse createTicket(@Valid @RequestBody Ticket ticket) throws URISyntaxException {
        log.debug("Contenido Ipicyt createTicket: ", ticket.toString());
        String token = "";



        token = this.GetSession().getSession_token();
        try {

            log.debug("Entra al try:  {}", token);

            // Create request
            Content content = Request.Post("http://0.0.0.0:83/apirest.php/Ticket/")

                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Session-Token", token)
                .addHeader("Authorization", "")

                // Add body
                .bodyString("{\"input\": {\"status\": 1," +
                    "\"global_validation\": 1," +
                    "\"itilcategories_id\": "+ ticket.getCatOp01() +
                    ",\"priority\": "+ ticket.getUrgency()+
                    ",\"type\": "+ ticket.getGlpiTicketsRequesttypesId()+"," +
                    "\"requesttypes_id\": "+ ticket.getContactType()+
                    ",\"date\": \"2020-11-01 00:00:00\"," +
                    "\"time_to_resolve\": \"14-11-2020 00:00\"," +
                    "\"urgency\": "+ ticket.getUrgency()+"," +
                    "\"impact\": " +ticket.getImpact()+ "," +
                    "\"locations_id\": 1," +
                    "\"name\": \" MSI IMSS Ticket " + ticket.getIdRemedyGlpi() + " - " + ticket.getGlpiTicketsName() + " \"," +
                    "\"content\": \" "+ ticket.getGlpiTicketsContent()+ "\"}}",
                    ContentType.APPLICATION_JSON)
                // Fetch request and return content
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
        catch (IOException e) { System.out.println(e); }

        this.CloseSession(token);
        return null;
    }

    public GlpiResponse updateTicket( Ticket ticket){
        String token = "";
        token = this.GetSession().getSession_token();
        try {

            // Create request
            Content content = Request.Put("http://0.0.0.0:83/apirest.php/Ticket/"+ticket.getIdRemedyGlpi())

                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Session-Token", token)

                // Add body
                .bodyString("{\"input\": {\"status\": 1," +
                        "\"global_validation\": 1," +
                        "\"itilcategories_id\": "+ ticket.getCatOp01() +
                        ",\"priority\": "+ ticket.getUrgency()+
                        ",\"type\": "+ ticket.getGlpiTicketsRequesttypesId()+"," +
                        "\"requesttypes_id\": "+ ticket.getContactType()+
                        ",\"date\": \"2020-11-01 00:00:00\"," +
                        "\"time_to_resolve\": \"14-11-2020 00:00\"," +
                        "\"urgency\": "+ ticket.getUrgency()+"," +
                        "\"impact\": " +ticket.getImpact()+ "," +
                        "\"locations_id\": 1," +
                        "\"name\": \" MSI IMSS Ticket " + ticket.getIdRemedyGlpi() + " - " + ticket.getGlpiTicketsName() + " \"," +
                        "\"content\": \" "+ ticket.getGlpiTicketsContent()+ "\"}}",
                    ContentType.APPLICATION_JSON)

                // Fetch request and return content
                .execute().returnContent();

            // Print content
            System.out.println("Contenido post"+ content);
            log.debug("Contenido Ipicyt: ", content.toString());


        }
        catch (IOException e) { System.out.println(e); }

        return null;
    }


    private Session GetSession(){
        // Inicia Sesión (GET )

        try {

            // Create request
            Content content = Request.Get("http://0.0.0.0:83/apirest.php/initSession/")
                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic Z2xwaTpnbHBp")
                .addHeader("App-Token", "Uhy6zT5OrjAOkxt7CETA9uNOua9KpBFHiZdn9s51")
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
            Content content = Request.Get("http://0.0.0.0:83/apirest.php/killSession/")

                // Add headers
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic Z2xwaTpnbHBp")
                .addHeader("App-Token", "Uhy6zT5OrjAOkxt7CETA9uNOua9KpBFHiZdn9s51")
                .addHeader("Session-Token", token)

                // Fetch request and return content
                .execute().returnContent();

            // Print content
            System.out.println(content);
        }
        catch (IOException e) { System.out.println(e); }
    }



}
