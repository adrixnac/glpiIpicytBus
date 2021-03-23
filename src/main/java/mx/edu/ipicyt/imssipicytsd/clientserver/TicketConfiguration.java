package mx.edu.ipicyt.imssipicytsd.clientserver;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class TicketConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("mx.edu.ipicyt.imssipicytsd.clientserver.wsdl");
        return marshaller;
    }
}
