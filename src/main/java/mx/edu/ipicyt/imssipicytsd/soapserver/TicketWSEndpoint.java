package mx.edu.ipicyt.imssipicytsd.soapserver;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.TicketRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TicketWSEndpoint {

    private static final String NAMESPACE_URI = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt";

    private TicketService ticketService;

    @Autowired
    public TicketWSEndpoint(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TicketRequest")
    @ResponsePayload
    public TicketResponse TicketApplication(@RequestPayload TicketRequest ticketApplicationRequest) throws Exception {
        if (ticketApplicationRequest != null) {
            ticketService.writeTicketApplication(ticketApplicationRequest);
        }

        return ticketService.processTicketApplication(ticketApplicationRequest);
    }
}
