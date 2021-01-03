package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.SubtypeTransaction;
import mx.edu.ipicyt.imssipicytsd.repository.SubtypeTransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class SubtypeTransactionResourceImp {

    private final Logger log = LoggerFactory.getLogger(SubtypeTransactionResourceImp.class);
    private static final String ENTITY_NAME = "subtypeTransaction";
    private final SubtypeTransactionRepository subtypeTransactionRepository;

    public SubtypeTransactionResourceImp(SubtypeTransactionRepository subtypeTransactionRepository) {
        this.subtypeTransactionRepository = subtypeTransactionRepository;
    }

    /**
     * GET  /subtype-transactions/remedy/:subtypeTransactionRemedy : get the "id" subtypeTransaction.
     *
     * @param subtypeTransactionRemedy the subtypeTransaction of the subtypeTransaction to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the subtypeTransaction, or with status 404 (Not Found)
     */
    @GetMapping("/subtype-transactions/remedy/{subtypeTransactionRemedy}")
    @Timed
    public ResponseEntity<SubtypeTransaction> getSubtypeTransaction(@PathVariable String subtypeTransactionRemedy) {
        log.debug("REST request to get SubtypeTransaction : {}", subtypeTransactionRemedy);
        SubtypeTransaction subtypeTransaction = subtypeTransactionRepository.findSubtypeTransactionBySubTypeTransactionRemedy(subtypeTransactionRemedy);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(subtypeTransaction));
    }
}
