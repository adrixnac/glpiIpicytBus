package mx.edu.ipicyt.imssipicytsd.soapclient;

import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.service.ImssRemedyService;
import org.opensaml.xmlsec.signature.J;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
    private final Logger log = LoggerFactory.getLogger(SoapClientConfig.class);
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt");
        return jaxb2Marshaller;
    }

    @Bean
    public ImssRemedyService imssRemedyService(Jaxb2Marshaller jaxb2Marshaller){
        log.debug("-- imssRemedyService --");
        ImssRemedyService imssRemedyService = new ImssRemedyService();
        imssRemedyService.setDefaultUri("http://172.16.162.38//services/ARService?server=remedy&amp;webService=PCT_Actualiza_WS");
        imssRemedyService.setMarshaller(jaxb2Marshaller);
        imssRemedyService.setUnmarshaller(jaxb2Marshaller);
        return imssRemedyService;

    }
}
