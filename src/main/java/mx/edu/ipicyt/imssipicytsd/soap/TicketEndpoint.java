package mx.edu.ipicyt.imssipicytsd.soap;


import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import mx.edu.ipicyt.imssipicytsd.service.TicketIpicytService;
import mx.edu.ipicyt.imssipicytsd.web.rest.UserResource;
import https._10_100_10_1.wsdl._public.glpi.ws_i_solicitud_tk_imms_ipicyt.GetTicketRequest;
import https._10_100_10_1.wsdl._public.glpi.ws_i_solicitud_tk_imms_ipicyt.GetTicketResponse;
import https._10_100_10_1.wsdl._public.glpi.ws_i_solicitud_tk_imms_ipicyt.TicketDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.*;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import javax.xml.ws.Response;

@Endpoint
public class TicketEndpoint {
    private final Logger log = LoggerFactory.getLogger(UserResource.class);
    private static final String NAMESPACE_URI = "https://10.100.10.1/WSDL/public/glpi/ws_i_solicitud_tk_imms_ipicyt";
    private final TicketRepository ticketRepository;
    private final TicketIpicytService ticketIpicytService;

    public TicketEndpoint(TicketRepository ticketRepository, TicketIpicytService ticketIpicytService) {
        this.ticketRepository = ticketRepository;
        this.ticketIpicytService = ticketIpicytService;
    }

    @PayloadRoot(namespace = "NAMESPACE_URI", localPart = "getTicket")
    @ResponsePayload
    public GetTicketResponse getTicket(@RequestPayload GetTicketRequest request){

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

        return response;
    }





}
