package mx.edu.ipicyt.imssipicytsd.service;

import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.InputMapping1;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.OutputMapping1;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Service
public class ImssRemedyService extends WebServiceGatewaySupport {
    private final Logger log = LoggerFactory.getLogger(ImssRemedyService.class);
    public OutputMapping1 getImss(Ticket ticket){
        log.debug("--ImssRemedyService-- {}", ticket);
        InputMapping1 inputMapping1 = new InputMapping1();
        inputMapping1.setNombreProducto(ticket.getNombreProducto());
        log.debug("--inputMapping1-- {}", inputMapping1.toString());
        return (OutputMapping1) getWebServiceTemplate().marshalSendAndReceive(inputMapping1);

    }
}
