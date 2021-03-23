package mx.edu.ipicyt.imssipicytsd.service;

import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.InputMapping1;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.OutputMapping1;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ImssRemedyService extends WebServiceGatewaySupport {
    public OutputMapping1 getImss(Ticket ticket){
        InputMapping1 inputMapping1 = new InputMapping1();
        inputMapping1.setNombreProducto(ticket.getNombreProducto());
        return (OutputMapping1) getWebServiceTemplate().marshalSendAndReceive(inputMapping1);

    }
}
