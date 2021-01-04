package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.Transaction;
import mx.edu.ipicyt.imssipicytsd.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TransactionResourceImp {
    private final Logger log = LoggerFactory.getLogger(TransactionResourceImp.class);
    private static final String ENTITY_NAME = "transaction";
    private final TransactionRepository transactionRepository;

    public TransactionResourceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * GET  /transactions/remedy/:transactionRemedy : get the "transactionRemedy" transaction.
     *
     * @param transactionRemedy the id of the transaction to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the transaction, or with status 404 (Not Found)
     */
    @GetMapping("/transactions/remedy/{transactionRemedy}")
    @Timed
    public ResponseEntity<Transaction> getTransactionRemedy(@PathVariable String transactionRemedy) {
        log.debug("REST request to get Transaction : {}", transactionRemedy);
        Transaction transaction = transactionRepository.findTransactionByTransactionRemedy(transactionRemedy);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(transaction));
    }





}
