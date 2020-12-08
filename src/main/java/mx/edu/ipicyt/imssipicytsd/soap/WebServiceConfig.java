package mx.edu.ipicyt.imssipicytsd.soap;

import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import mx.edu.ipicyt.imssipicytsd.service.TicketIpicytService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.ws.server.endpoint.annotation.*;
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    private final Logger log = LoggerFactory.getLogger(WebServiceConfig.class);

    @Bean(name="ticketServlet")
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/WSDL/public/glpi/ws_i_solicitud_tk_imms_ipicyt/*");

    }

    @Bean(name = "tickets")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema ticketsSchema) {

        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TicketPort");
        wsdl11Definition.setLocationUri("/WSDL/public/glpi/ws_a_solicitud_tk_imms_ipicyt");
        wsdl11Definition.setTargetNamespace("https://10.100.10.1/WSDL/public/glpi/ws_i_solicitud_tk_imms_ipicyt");
        wsdl11Definition.setSchema(ticketsSchema);
        log.debug("REST request to get definition : {}", wsdl11Definition.toString());
        return wsdl11Definition;
    }

    @Bean(name="ticketServlet")
    public ServletRegistrationBean messageDispatcherServletAdd(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/WSDL/public/glpi/ws_a_solicitud_tk_imms_ipicyt/*");

    }

    @Bean(name = "tickets")
    public DefaultWsdl11Definition defaultWsdl11DefinitionAdd(XsdSchema ticketsSchema) {

        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TicketPort");
        wsdl11Definition.setLocationUri("/WSDL/public/glpi/ws_a_solicitud_tk_imms_ipicyt");
        wsdl11Definition.setTargetNamespace("https://10.100.10.1/WSDL/public/glpi/ws_a_solicitud_tk_imms_ipicyt");
        wsdl11Definition.setSchema(ticketsSchema);
        log.debug("REST request to get definition : {}", wsdl11Definition.toString());
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema ticketsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/ticket-details.xsd"));
    }
}
