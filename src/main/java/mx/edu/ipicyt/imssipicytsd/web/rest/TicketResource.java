package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.GlpiResponse;
import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import mx.edu.ipicyt.imssipicytsd.service.TicketIpicytService;
import mx.edu.ipicyt.imssipicytsd.web.rest.errors.BadRequestAlertException;
import mx.edu.ipicyt.imssipicytsd.web.rest.util.HeaderUtil;
import mx.edu.ipicyt.imssipicytsd.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
     * POST  /tickets : Create a new ticket.
     *
     * @param ticket the ticket to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ticket, or with status 400 (Bad Request) if the ticket has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tickets")
    @Timed
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) throws URISyntaxException {
        log.debug("REST request to save Ticket : {}", ticket);
        if (ticket.getId() != null) {
            throw new BadRequestAlertException("A new ticket cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Ticket result = ticketRepository.save(ticket);
        GlpiResponse glpiResponse = new GlpiResponse();
        glpiResponse = this.ticketIpicytService.createTicket(ticket);
        log.debug("REST request to save GlpiResponse : {}", glpiResponse);

        return ResponseEntity.created(new URI("/api/tickets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tickets : Updates an existing ticket.
     *
     * @param ticket the ticket to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ticket,
     * or with status 400 (Bad Request) if the ticket is not valid,
     * or with status 500 (Internal Server Error) if the ticket couldn't be updated
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
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ticket.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tickets : get all the tickets.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of tickets in body
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
     * GET  /tickets/:id : get the "id" ticket.
     *
     * @param id the id of the ticket to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ticket, or with status 404 (Not Found)
     */
    @GetMapping("/tickets/{id}")
    @Timed
    public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
        log.debug("REST request to get Ticket : {}", id);
        Ticket ticket = ticketRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(ticket));
    }

    /**
     * PUT  /tickets/translate/:id : update the "id" ticket on Remedy.
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
