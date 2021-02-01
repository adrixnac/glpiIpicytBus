
package mx.edu.ipicyt.imssipicytsd.soapserver;

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

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    // Configure our Spring Beans

    @Bean
    public ServletRegistrationBean messageDispactherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(false);
        return new ServletRegistrationBean(servlet, "/ws_i_solicitud_tk_imms_ipicyt/*");
    }

    @Bean(name = "getTicket")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema ticketServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TicketServicePort");
        wsdl11Definition.setLocationUri("https://ipicytbuss-glpi-mesas-qa.cloudapps.imss.gob.mx/ws_i_solicitud_tk_imms_ipicyt");
        wsdl11Definition.setTargetNamespace("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt");
        wsdl11Definition.setSchema(ticketServiceSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema ticketServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/TicketService.xsd"));
    }

    @Bean(name = "getFile")
    public DefaultWsdl11Definition defaultFileWsdl11Definition(XsdSchema fileServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("FileServicePort");
        wsdl11Definition.setLocationUri("https://ipicytbuss-glpi-mesas-qa.cloudapps.imss.gob.mx/ws_i_solicitud_tk_imms_ipicyt");
        wsdl11Definition.setTargetNamespace("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt");
        wsdl11Definition.setSchema(fileServiceSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema fileServiceSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/TicketService.xsd"));
    }
}
