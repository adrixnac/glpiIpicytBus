package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.edu.ipicyt.imssipicytsd.domain.Urgency;

import mx.edu.ipicyt.imssipicytsd.repository.UrgencyRepository;
import mx.edu.ipicyt.imssipicytsd.web.rest.errors.BadRequestAlertException;
import mx.edu.ipicyt.imssipicytsd.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Urgency.
 */
@RestController
@RequestMapping("/api")
public class UrgencyResource {

    private final Logger log = LoggerFactory.getLogger(UrgencyResource.class);

    private static final String ENTITY_NAME = "urgency";

    private final UrgencyRepository urgencyRepository;

    public UrgencyResource(UrgencyRepository urgencyRepository) {
        this.urgencyRepository = urgencyRepository;
    }

    /**
     * POST  /urgencies : Create a new urgency.
     *
     * @param urgency the urgency to create
     * @return the ResponseEntity with status 201 (Created) and with body the new urgency, or with status 400 (Bad Request) if the urgency has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/urgencies")
    @Timed
    public ResponseEntity<Urgency> createUrgency(@Valid @RequestBody Urgency urgency) throws URISyntaxException {
        log.debug("REST request to save Urgency : {}", urgency);
        if (urgency.getId() != null) {
            throw new BadRequestAlertException("A new urgency cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Urgency result = urgencyRepository.save(urgency);
        return ResponseEntity.created(new URI("/api/urgencies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /urgencies : Updates an existing urgency.
     *
     * @param urgency the urgency to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated urgency,
     * or with status 400 (Bad Request) if the urgency is not valid,
     * or with status 500 (Internal Server Error) if the urgency couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/urgencies")
    @Timed
    public ResponseEntity<Urgency> updateUrgency(@Valid @RequestBody Urgency urgency) throws URISyntaxException {
        log.debug("REST request to update Urgency : {}", urgency);
        if (urgency.getId() == null) {
            return createUrgency(urgency);
        }
        Urgency result = urgencyRepository.save(urgency);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, urgency.getId().toString()))
            .body(result);
    }

    /**
     * GET  /urgencies : get all the urgencies.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of urgencies in body
     */
    @GetMapping("/urgencies")
    @Timed
    public List<Urgency> getAllUrgencies() {
        log.debug("REST request to get all Urgencies");
        return urgencyRepository.findAll();
        }

    /**
     * GET  /urgencies/:id : get the "id" urgency.
     *
     * @param id the id of the urgency to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the urgency, or with status 404 (Not Found)
     */
    @GetMapping("/urgencies/{id}")
    @Timed
    public ResponseEntity<Urgency> getUrgency(@PathVariable Long id) {
        log.debug("REST request to get Urgency : {}", id);
        Urgency urgency = urgencyRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(urgency));
    }

    /**
     * DELETE  /urgencies/:id : delete the "id" urgency.
     *
     * @param id the id of the urgency to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/urgencies/{id}")
    @Timed
    public ResponseEntity<Void> deleteUrgency(@PathVariable Long id) {
        log.debug("REST request to delete Urgency : {}", id);
        urgencyRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
