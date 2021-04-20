package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt.OutputMapping1;
import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import mx.edu.ipicyt.imssipicytsd.service.ImssRemedyService;
import mx.edu.ipicyt.imssipicytsd.service.TicketIpicytService;
import mx.edu.ipicyt.imssipicytsd.soapclient.SoapClientConfig;
import mx.edu.ipicyt.imssipicytsd.web.rest.errors.BadRequestAlertException;
import mx.edu.ipicyt.imssipicytsd.web.rest.util.HeaderUtil;
import mx.edu.ipicyt.imssipicytsd.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.xml.soap.*;

/**
 * REST controller for managing Ticket.
 */
@RestController
@RequestMapping("/api")
public class TicketResource {

    private final Logger log = LoggerFactory.getLogger(TicketResource.class);
    private static final String ENTITY_NAME = "ticket";
    private final TicketRepository ticketRepository;
    private final TicketIpicytService ticketIpicytService;

    public TicketResource(TicketRepository ticketRepository, TicketIpicytService ticketIpicytService) {
        this.ticketRepository = ticketRepository;
        this.ticketIpicytService = ticketIpicytService;
    }

    /**
     * POST /tickets : Create a new ticket.
     *
     * @param ticket the ticket to create
     * @return the ResponseEntity with status 201 (Created) and with body the new
     *         ticket, or with status 400 (Bad Request) if the ticket has already an
     *         ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tickets")
    @Timed
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) throws URISyntaxException {
        log.debug("REST request to save Ticket : {}", ticket);

        try {

            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            String url = "http://172.16.162.38/services/ARService?server=remedy&webService=PCT_Actualiza_WS";
            SOAPMessage soapResponse = soapConnection.call(UpdateTicketResueltoSOAPRequest(), url);

            // print SOAP Response
            System.out.print("Response SOAP Message:");
            soapResponse.writeTo(System.out);

            soapConnection.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        if (ticket.getId() != null) {
            throw new BadRequestAlertException("A new ticket cannot already have an ID", ENTITY_NAME, "idexists");
        }

        return createTicket(ticket);
        /*Ticket result = new Ticket();// ticketRepository.save(ticket);
        GlpiResponse glpiResponse = new GlpiResponse();
        // glpiResponse = this.ticketIpicytService.createTicket(ticket);
        log.debug("REST request to save GlpiResponse : {}", glpiResponse);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
                SoapClientConfig.class);
        ImssRemedyService imssRemedyService = annotationConfigApplicationContext.getBean(ImssRemedyService.class);
        OutputMapping1 imssResult = imssRemedyService.getImss(ticket);

        if (imssResult != null) {
            log.debug("IMSS funcionando {}", imssResult.toString());
        } else {
            log.debug("IMSS no funcionando {}", imssResult.toString());
        }

        log.debug("REST request to save Remedy Response : {}", glpiResponse);
        return ResponseEntity.created(new URI("/api/tickets/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);*/
    }

    private static SOAPMessage UpdateTicketSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "PCT_Actualiza_WS";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        /*
         * Constructed SOAP Request Message: <SOAP-ENV:Envelope
         * xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
         * xmlns:example="http://ws.cdyne.com/"> <SOAP-ENV:Header/> <SOAP-ENV:Body>
         * <example:VerifyEmail> <example:email>mutantninja@gmail.com</example:email>
         * <example:LicenseKey>123</example:LicenseKey> </example:VerifyEmail>
         * </SOAP-ENV:Body> </SOAP-ENV:Envelope>
         */
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("UPDATE", "urn");

        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Impact", "urn");
        soapBodyElem1.addTextNode("1-Extensive/Widespread");

        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("Urgency", "urn");
        soapBodyElem2.addTextNode("1-Critical");

        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Action", "urn");
        soapBodyElem3.addTextNode("UPDATE");

        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("Ticket_Proveedor__c", "urn");
        soapBodyElem4.addTextNode("2021030016");

        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("Type", "urn");
        soapBodyElem5.addTextNode("Incidente");

        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("Ticket_Number", "urn");
        soapBodyElem6.addTextNode("INC840604");

        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("Work_Info_Notes", "urn");
        soapBodyElem7.addTextNode("Se cambia a resuelto");

        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("Work_Info_View_Access", "urn");
        soapBodyElem8.addTextNode("Public");

        SOAPElement soapBodyElem9 = soapBodyElem.addChildElement("Work_Info_Type", "urn");
        soapBodyElem9.addTextNode("General Information");

        soapBodyElem.addChildElement("Status", "urn").addTextNode("Resolved");
        soapBodyElem.addChildElement("Resolution", "urn").addTextNode("Todo Ok");

        SOAPHeader header = envelope.getHeader();

        SOAPElement security = header.addChildElement("AuthenticationInfo", "urn");

        SOAPElement username = security.addChildElement("userName", "urn");
        username.addTextNode("ws.usuario_imss");

        SOAPElement password = security.addChildElement("password", "urn");
        password.addTextNode("KUH7864SR...ghd");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("userName", "ws.usuario_imss");
        headers.addHeader("password", "KUH7864SR...ghd");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

    private static SOAPMessage createTicketSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "PCT_Creacion_WS";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        /*
         * Constructed SOAP Request Message: <SOAP-ENV:Envelope
         * xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
         * xmlns:example="http://ws.cdyne.com/"> <SOAP-ENV:Header/> <SOAP-ENV:Body>
         * <example:VerifyEmail> <example:email>mutantninja@gmail.com</example:email>
         * <example:LicenseKey>123</example:LicenseKey> </example:VerifyEmail>
         * </SOAP-ENV:Body> </SOAP-ENV:Envelope>
         */
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("CREATE", "urn");

        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Impacto", "urn");
        soapBodyElem1.addTextNode("1-Extensive/Widespread");

        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("Urgencia", "urn");
        soapBodyElem2.addTextNode("1-Critical");

        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Accion", "urn");
        soapBodyElem3.addTextNode("CREATEINC");

        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("Descripcion", "urn");
        soapBodyElem4.addTextNode("CREACION WS 03 App IPICYT BUS");

        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("Notas", "urn");
        soapBodyElem5.addTextNode("NOTAS App IPICYT BUS");

        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("ProdCat01", "urn");
        soapBodyElem6.addTextNode("SW ABASTO Y RH");

        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("ProdCat02", "urn");
        soapBodyElem7.addTextNode("RECURSOS HUMANOS");

        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("ProdCat03", "urn");
        soapBodyElem8.addTextNode("SIAP (SISTEMA INTEGRAL DE ADMINISTRACION DE PERSONAL)");

        soapBodyElem.addChildElement("Nombre_producto", "urn").addTextNode("CALCULO DE TRABAJADORES");
        soapBodyElem.addChildElement("CatOp01", "urn").addTextNode("APLICACIONES");
        soapBodyElem.addChildElement("CatOp02", "urn").addTextNode("ACCESO A SERVICIOS DE TI");
        soapBodyElem.addChildElement("CatOp03", "urn").addTextNode("DAR DE ALTA CUENTA DE USUARIO");
        soapBodyElem.addChildElement("Ticket_Proveedor", "urn").addTextNode("SOAPUI00008");
        soapBodyElem.addChildElement("Estado", "urn").addTextNode("In Progress");
        soapBodyElem.addChildElement("Tipo", "urn").addTextNode("Incidente");

        SOAPHeader header = envelope.getHeader();
        SOAPElement security = header.addChildElement("AuthenticationInfo", "urn");

        SOAPElement username = security.addChildElement("userName", "urn");
        username.addTextNode("ws.usuario_imss");

        SOAPElement password = security.addChildElement("password", "urn");
        password.addTextNode("KUH7864SR...ghd");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("userName", "ws.usuario_imss");
        headers.addHeader("password", "KUH7864SR...ghd");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }


    private static SOAPMessage UpdateTicketResueltoSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "PCT_Actualiza_WS";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        /*
         * Constructed SOAP Request Message: <SOAP-ENV:Envelope
         * xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
         * xmlns:example="http://ws.cdyne.com/"> <SOAP-ENV:Header/> <SOAP-ENV:Body>
         * <example:VerifyEmail> <example:email>mutantninja@gmail.com</example:email>
         * <example:LicenseKey>123</example:LicenseKey> </example:VerifyEmail>
         * </SOAP-ENV:Body> </SOAP-ENV:Envelope>
         */
        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("UPDATE", "urn");

        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Impact", "urn");
        soapBodyElem1.addTextNode("1-Extensive/Widespread");

        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("Urgency", "urn");
        soapBodyElem2.addTextNode("1-Critical");

        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Action", "urn");
        soapBodyElem3.addTextNode("UPDATE");

        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("Ticket_Proveedor__c", "urn");
        soapBodyElem4.addTextNode("2021030016");

        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("Type", "urn");
        soapBodyElem5.addTextNode("Incidente");

        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("Ticket_Number", "urn");
        soapBodyElem6.addTextNode("INC840604");

        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("Work_Info_Notes", "urn");
        soapBodyElem7.addTextNode("Se cambia a resuelto");
        soapBodyElem.addChildElement("Work_Info_View_Access", "urn").addTextNode("Public");

        soapBodyElem.addChildElement("Work_Info_Type", "urn").addTextNode("General Information");

        soapBodyElem.addChildElement("Status", "urn").addTextNode("Resolved");
        soapBodyElem.addChildElement("Resolution", "urn").addTextNode("Todo Ok");
        soapBodyElem.addChildElement("Resolution_Category", "urn").addTextNode("APLICACIONES Y SOFTWARE");
        soapBodyElem.addChildElement("Resolution_Category_Tier_2", "urn").addTextNode("ERROR EN CONFIGURACION");
        soapBodyElem.addChildElement("Resolution_Category_Tier_3", "urn").addTextNode("SE REALIZA CONFIGURACION REQUERIDA");

        soapBodyElem.addChildElement("Closure_Product_Category_Tier1", "urn").addTextNode("SW ABASTO Y RH");
        soapBodyElem.addChildElement("Closure_Product_Category_Tier2", "urn").addTextNode("RECURSOS HUMANOS");
        soapBodyElem.addChildElement("Closure_Product_Category_Tier3", "urn").addTextNode("SIAP (SISTEMA INTEGRAL DE ADMINISTRACION DE PERSONAL)");


        SOAPHeader header = envelope.getHeader();

        SOAPElement security = header.addChildElement("AuthenticationInfo", "urn");

        SOAPElement username = security.addChildElement("userName", "urn");
        username.addTextNode("ws.usuario_imss");

        SOAPElement password = security.addChildElement("password", "urn");
        password.addTextNode("KUH7864SR...ghd");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("userName", "ws.usuario_imss");
        headers.addHeader("password", "KUH7864SR...ghd");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

    /**
     * PUT /tickets : Updates an existing ticket.
     *
     * @param ticket the ticket to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     *         ticket, or with status 400 (Bad Request) if the ticket is not valid,
     *         or with status 500 (Internal Server Error) if the ticket couldn't be
     *         updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tickets")
    @Timed
    public ResponseEntity<Ticket> updateTicket(@Valid @RequestBody Ticket ticket) throws URISyntaxException {
        log.debug("REST request to update Ticket : {}", ticket);
        if (ticket.getId() == null) {
            return createTicket(ticket);
        }
        Ticket result = ticketRepository.save(ticket);
        GlpiResponse glpiResponse = new GlpiResponse();
        glpiResponse = this.ticketIpicytService.updateTicket(ticket);

        ImssRemedyService imssRemedyService = new ImssRemedyService();
        OutputMapping1 imssResult = imssRemedyService.getImss(ticket);

        if (imssResult != null) {
            log.debug("IMSS funcionando {}", imssResult.toString());
        } else {
            log.debug("IMSS no funcionando {}", imssResult.toString());
        }

        log.debug("REST request to save Remedy Response : {}", glpiResponse);

        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ticket.getId().toString()))
                .body(result);
    }

    /**
     * GET /tickets : get all the tickets.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of tickets in
     *         body
     */
    @GetMapping("/tickets")
    @Timed
    public ResponseEntity<List<Ticket>> getAllTickets(Pageable pageable) {
        log.debug("REST request to get a page of Tickets");
        Page<Ticket> page = ticketRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/tickets");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET /tickets/:id : get the "id" ticket.
     *
     * @param id the id of the ticket to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ticket, or
     *         with status 404 (Not Found)
     */
    @GetMapping("/tickets/{id}")
    @Timed
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        log.debug("REST request to get Ticket : {}", id);
        Ticket ticket = ticketRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ticket));
    }

    /**
     * PUT /tickets/translate/:id : update the "id" ticket on Remedy.
     *
     * @param id the id of the ticket to update
     * @return the ResponseEntity with status 200 (OK)
     */
    @PutMapping("/tickets/translate/{id}")
    @Timed
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        log.debug("REST request to delete Ticket : {}", id);
        Ticket ticket = ticketRepository.findOne(id);
        this.ticketIpicytService.remedyUpdate(ticket);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
