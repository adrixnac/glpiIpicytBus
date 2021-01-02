package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.edu.ipicyt.imssipicytsd.domain.SubtypeTransaction;

import mx.edu.ipicyt.imssipicytsd.repository.SubtypeTransactionRepository;
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
 * REST controller for managing SubtypeTransaction.
 */
@RestController
@RequestMapping("/api")
public class SubtypeTransactionResource {

    private final Logger log = LoggerFactory.getLogger(SubtypeTransactionResource.class);

    private static final String ENTITY_NAME = "subtypeTransaction";

    private final SubtypeTransactionRepository subtypeTransactionRepository;

    public SubtypeTransactionResource(SubtypeTransactionRepository subtypeTransactionRepository) {
        this.subtypeTransactionRepository = subtypeTransactionRepository;
    }

    /**
     * POST  /subtype-transactions : Create a new subtypeTransaction.
     *
     * @param subtypeTransaction the subtypeTransaction to create
     * @return the ResponseEntity with status 201 (Created) and with body the new subtypeTransaction, or with status 400 (Bad Request) if the subtypeTransaction has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/subtype-transactions")
    @Timed
    public ResponseEntity<SubtypeTransaction> createSubtypeTransaction(@Valid @RequestBody SubtypeTransaction subtypeTransaction) throws URISyntaxException {
        log.debug("REST request to save SubtypeTransaction : {}", subtypeTransaction);
        if (subtypeTransaction.getId() != null) {
            throw new BadRequestAlertException("A new subtypeTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SubtypeTransaction result = subtypeTransactionRepository.save(subtypeTransaction);
        return ResponseEntity.created(new URI("/api/subtype-transactions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /subtype-transactions : Updates an existing subtypeTransaction.
     *
     * @param subtypeTransaction the subtypeTransaction to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated subtypeTransaction,
     * or with status 400 (Bad Request) if the subtypeTransaction is not valid,
     * or with status 500 (Internal Server Error) if the subtypeTransaction couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/subtype-transactions")
    @Timed
    public ResponseEntity<SubtypeTransaction> updateSubtypeTransaction(@Valid @RequestBody SubtypeTransaction subtypeTransaction) throws URISyntaxException {
        log.debug("REST request to update SubtypeTransaction : {}", subtypeTransaction);
        if (subtypeTransaction.getId() == null) {
            return createSubtypeTransaction(subtypeTransaction);
        }
        SubtypeTransaction result = subtypeTransactionRepository.save(subtypeTransaction);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, subtypeTransaction.getId().toString()))
            .body(result);
    }

    /**
     * GET  /subtype-transactions : get all the subtypeTransactions.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of subtypeTransactions in body
     */
    @GetMapping("/subtype-transactions")
    @Timed
    public List<SubtypeTransaction> getAllSubtypeTransactions() {
        log.debug("REST request to get all SubtypeTransactions");
        return subtypeTransactionRepository.findAll();
        }

    /**
     * GET  /subtype-transactions/:id : get the "id" subtypeTransaction.
     *
     * @param id the id of the subtypeTransaction to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the subtypeTransaction, or with status 404 (Not Found)
     */
    @GetMapping("/subtype-transactions/{id}")
    @Timed
    public ResponseEntity<SubtypeTransaction> getSubtypeTransaction(@PathVariable Long id) {
        log.debug("REST request to get SubtypeTransaction : {}", id);
        SubtypeTransaction subtypeTransaction = subtypeTransactionRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(subtypeTransaction));
    }

    /**
     * DELETE  /subtype-transactions/:id : delete the "id" subtypeTransaction.
     *
     * @param id the id of the subtypeTransaction to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/subtype-transactions/{id}")
    @Timed
    public ResponseEntity<Void> deleteSubtypeTransaction(@PathVariable Long id) {
        log.debug("REST request to delete SubtypeTransaction : {}", id);
        subtypeTransactionRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
