package mx.edu.ipicyt.imssipicytsd.soapclient;

import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.service.ImssRemedyService;
import org.opensaml.xmlsec.signature.J;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;

@Configuration
public class SoapClientConfig {
    private final Logger log = LoggerFactory.getLogger(SoapClientConfig.class);
    @Bean
    public Jaxb2Marshaller marshaller() throws SOAPException {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(
            MessageFactory.newInstance());
        messageFactory.afterPropertiesSet();
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory);
        webServiceTemplate.setMarshaller(jaxb2Marshaller);
        webServiceTemplate.afterPropertiesSet();
        jaxb2Marshaller.setContextPath("https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt");
        return jaxb2Marshaller;
    }

    @Bean
    public ImssRemedyService imssRemedyService(Jaxb2Marshaller jaxb2Marshaller){
        log.debug("-- imssRemedyService --");
        ImssRemedyService imssRemedyService = new ImssRemedyService();
        imssRemedyService.setDefaultUri("http://http://172.16.162.38/services/ARService?server=remedy&amp;webService=PCT_Actualiza_WS");
        imssRemedyService.setMarshaller(jaxb2Marshaller);
        imssRemedyService.setUnmarshaller(jaxb2Marshaller);
        return imssRemedyService;

    }
}
