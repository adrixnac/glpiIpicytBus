package mx.edu.ipicyt.imssipicytsd.soapserver;

import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.TicketRequest;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.TicketResponse;

public interface TicketService {

    GlpiResponse writeTicketApplication(TicketRequest ticketRequest);

    TicketResponse processTicketApplication(TicketRequest ticketRequest);
}
