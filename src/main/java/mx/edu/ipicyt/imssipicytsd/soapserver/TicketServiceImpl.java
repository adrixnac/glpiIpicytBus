package mx.edu.ipicyt.imssipicytsd.soapserver;

import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.TicketRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.TicketResponse;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import mx.edu.ipicyt.imssipicytsd.service.TicketIpicytService;
import mx.edu.ipicyt.imssipicytsd.service.util.Utils;
import mx.edu.ipicyt.imssipicytsd.web.rest.TicketResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;



@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private final TicketIpicytService ticketIpicytService;
    private final Logger log = LoggerFactory.getLogger(TicketResource.class);


    public TicketServiceImpl(TicketRepository ticketRepository, TicketIpicytService ticketIpicytService) {
        this.ticketRepository = ticketRepository;
        this.ticketIpicytService = ticketIpicytService;
    }

    @Override
    public GlpiResponse writeTicketApplication(TicketRequest ticketRequest) {

        // busca en la base de datos sí existe el ticket; sí no existe es una creación
        String ticketSolicitado = ticketRequest.getTicketIPICYT();
        GlpiResponse glpiResponse = new GlpiResponse();

        if (ticketSolicitado == ""){
            Ticket ticket = new Ticket();
            ticket.setIdRemedyGlpi(ticketRequest.getIdReferenciaCliente());
            ticket.setGlpiTicketsName(ticketRequest.getNombreProducto());
            ticket.setCaller(ticketRequest.getCaller());
            ticket.setGlpiTicketsRequesttypesId(ticketRequest.getGlpiTicketsRequesttypesId());
            //ticket.setActualSysDate(request.getActualSysDate());
            ticket.setCallerEmail(ticketRequest.getCalleEmail());
            ticket.setCatOp01(ticketRequest.getCatOp01());
            ticket.setCatOp02(ticketRequest.getCatOp02());
            ticket.setCompany(ticketRequest.getCompany());
            ticket.setContactType(ticketRequest.getContactType());
            ticket.setUrgency(ticketRequest.getUrgency());
            ticket.setTypeTransaccion(ticketRequest.getTypeTransaccion());
            ticket.setProdCat03(ticketRequest.getProdCat03());
            ticket.setProdCat02(ticketRequest.getProdCat02());
            ticket.setProdCat01(ticketRequest.getProdCat01());
            ticket.setNotes(ticketRequest.getNotes());
            ticket.setNombreProducto(ticketRequest.getNombreProducto());
            ticket.setImpact(ticketRequest.getImpact());
            ticket.setIdReferenciaCliente(ticketRequest.getIdReferenciaCliente());
            ticket.setSubTypeTransaction(ticketRequest.getSubTypeTransaction());
            ticket.setIdReferenciaCliente(ticketRequest.getIdReferenciaCliente());

            Ticket result = ticketRepository.save(ticket);
            log.debug("TICKET DE SALIDA {}", result.toString() );

            glpiResponse.setId(result.getIdGlpi());
           if(result != null) {
               glpiResponse.setMessage("");
               glpiResponse.setId(ticket.getIdGlpi());
               glpiResponse.setId_referencia_cliente(ticket.getIdReferenciaCliente());
               glpiResponse.setStatus_transaccion("COMPLETADO");
               glpiResponse.setType_transaccion("INSERT");
           }else{
               glpiResponse.setMessage("Error al crear el ticket");
               glpiResponse.setId(ticket.getIdGlpi());
               glpiResponse.setId_referencia_cliente(ticket.getIdReferenciaCliente());
               glpiResponse.setStatus_transaccion("ERROR");
               glpiResponse.setType_transaccion("INSERT");
           }



        }
        // sí existe es una actualización

        return glpiResponse;
    }

    @Override
    public TicketResponse processTicketApplication(TicketRequest ticketRequest)  {
        TicketResponse ticketResponse = new TicketResponse();
        Utils utils = new Utils();
        String ticketSolicitado = ticketRequest.getTicketIPICYT();
        Ticket ticket = new Ticket();

        GlpiResponse glpiResponse = new GlpiResponse();
        log.debug("FECHA ACTUAL - SOAP {}", ticketRequest.getActualSysDate());
        ticket.setActualSysDate(utils.convertStringToInstant(ticketRequest.getActualSysDate()));
        ticket.setIdGlpi(ticketSolicitado);
        ticket.setGlpiTicketsContent(ticketRequest.getGlpiTicketsContent());
        ticket.setGlpiTicketsName(ticketRequest.getGlpiTicketsName());
        ticket.setProdCat01(ticketRequest.getProdCat01());
        ticket.setProdCat02(ticketRequest.getProdCat02());
        ticket.setProdCat03(ticketRequest.getProdCat03());
        ticket.setImpact(ticketRequest.getImpact());
        ticket.setGlpiTicketsRequesttypesId(ticketRequest.getGlpiTicketsRequesttypesId());
        ticket.setCompany(ticketRequest.getCompany());
        ticket.setCatOp01(ticketRequest.getCatOp01());
        ticket.setCatOp02(ticketRequest.getCatOp02());
        ticket.setCatOp03(ticketRequest.getCatOp03());
        ticket.callerPhone(ticketRequest.getCallerPhone());
        ticket.setContactType(ticketRequest.getContactType());
        ticket.setIdRemedyGlpi(String.valueOf(ticketRequest.getIdRemedyGlpi()));
        ticket.setCallerPhone(ticketRequest.getCallerPhone());
        ticket.setCallerEmail(ticketRequest.getCalleEmail());
        ticket.setGlpiTicketsContent(ticketRequest.getGlpiTicketsRequesttypesId());
        ticket.setUrgency(ticketRequest.getUrgency());
        ticket.idReferenciaCliente(ticketRequest.getIdReferenciaCliente());
        ticket.caller(ticketRequest.getCaller());
        ticket.setSubTypeTransaction(ticketRequest.getSubTypeTransaction());
        ticket.setIdPriority(ticketRequest.getPriority());

        // nuevo ticket
        if ( ticketSolicitado.isEmpty() ){
            log.debug("ticket para ser creado {}", ticket.toString());
            Ticket result = ticketRepository.save(ticket);
            try {
                log.debug("ticket para ser creado en GLPI{}", ticket.toString());
                glpiResponse = this.ticketIpicytService.createTicket(ticket);
                log.debug("ticket ya creado en GLPI{}", ticket.toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            log.debug("REST request to save GlpiResponse : {}", glpiResponse);
            ticketResponse.setTypeTransaccion("INSERT");
            ticketResponse.setStatusTransaccionId("COMPLETADO");
            ticketResponse.setResultMessage("Ticket creado");
            ticketResponse.setGlpiTicketsId(glpiResponse.getId());

        }else {
            log.debug("ticket para ser actualizado {}", ticket.toString());
            Ticket result = ticketRepository.save(ticket);
            ticketResponse.setGlpiTicketsId(glpiResponse.getId());
            glpiResponse = this.ticketIpicytService.updateTicket(ticket);
            log.debug("ticket ya actualizado en GLPI{}", ticket.toString());
            log.debug("REST request to update GlpiResponse : {}", glpiResponse);
            ticketResponse.setTypeTransaccion("UPDATE");
            ticketResponse.setGlpiTicketsId(glpiResponse.getGlpi_tickets_id());
            ticketResponse.setIdReferenciaCliente(glpiResponse.getId_referencia_cliente());
            ticketResponse.setStatusTransaccionId("COMPLETADO");
            ticketResponse.setResultMessage("");
        }
        return ticketResponse;
    }
}
