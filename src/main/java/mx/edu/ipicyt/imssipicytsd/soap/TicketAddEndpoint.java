package mx.edu.ipicyt.imssipicytsd.soap;
import https._10_100_10_1.wsdl._public.glpi.ws_a_solicitud_tk_imms_ipicyt.GetTicketRequest;
import https._10_100_10_1.wsdl._public.glpi.ws_a_solicitud_tk_imms_ipicyt.GetTicketResponse;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import mx.edu.ipicyt.imssipicytsd.service.TicketIpicytService;
import mx.edu.ipicyt.imssipicytsd.web.rest.UserResource;
import https._10_100_10_1.wsdl._public.glpi.ws_a_solicitud_tk_imms_ipicyt.TicketDetails;
import mx.edu.ipicyt.imssipicytsd.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.*;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import java.net.URI;
import java.net.URISyntaxException;

@Endpoint
public class TicketAddEndpoint {
    private final Logger log = LoggerFactory.getLogger(UserResource.class);
    private static final String NAMESPACE_URI = "https://10.100.10.1/WSDL/public/glpi/ws_a_solicitud_tk_imms_ipicyt";
    private final TicketRepository ticketRepository;
    private final TicketIpicytService ticketIpicytService;

    public TicketAddEndpoint(TicketRepository ticketRepository, TicketIpicytService ticketIpicytService) {
        this.ticketRepository = ticketRepository;
        this.ticketIpicytService = ticketIpicytService;
    }

    @PayloadRoot(namespace = "NAMESPACE_URI", localPart = "setTicket")
    @ResponsePayload
    public GetTicketResponse setTicket(@RequestPayload GetTicketRequest request) throws URISyntaxException {
        GetTicketResponse response = new GetTicketResponse();
        TicketDetails ticketDetails = new TicketDetails();
        Ticket ticket = new Ticket();
        ticket.setIdRemedyGlpi(request.getIdReferenciaCliente());
        ticket.setGlpiTicketsName(request.getNombreProducto());
        ticket.setCaller(request.getCaller());
        ticket.setGlpiTicketsRequesttypesId(request.getGlpiTicketsRequesttypesId());
        //ticket.setActualSysDate(request.getActualSysDate());
        ticket.setCallerEmail(request.getCalleEmail());
        ticket.setCatOp01(request.getCatOp01());
        ticket.setCatOp02(request.getCatOp02());
        ticket.setCompany(request.getCompany());
        ticket.setContactType(request.getContactType());
        ticket.setUrgency(request.getUrgency());
        ticket.setTypeTransaccion(request.getTypeTransaccion());
        ticket.setProdCat03(request.getProdCat03());
        ticket.setProdCat02(request.getProdCat02());
        ticket.setProdCat01(request.getProdCat01());
        ticket.setNotes(request.getNotes());
        ticket.setNombreProducto(request.getNombreProducto());
        ticket.setImpact(request.getImpact());
        ticket.setIdReferenciaCliente(request.getIdReferenciaCliente());
        ticket.setSubTypeTransaction(request.getSubTypeTransaction());
        ticket.setIdReferenciaCliente(request.getIdReferenciaCliente());

        Ticket result = ticketRepository.save(ticket);
        GlpiResponse glpiResponse = new GlpiResponse();
        glpiResponse = this.ticketIpicytService.updateTicket(ticket);
        response.setTicketDetails(ticketDetails);
        try {
            glpiResponse = this.ticketIpicytService.createTicket(ticket);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        log.debug("REST request to save GlpiResponse : {}", glpiResponse);

        ResponseEntity<Ticket> createTicket = ResponseEntity.created(new URI("/api/tickets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("ticket", result.getId().toString()))
            .body(result);
        return response;
    }


}
