package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.edu.ipicyt.imssipicytsd.domain.Urgency;

import mx.edu.ipicyt.imssipicytsd.repository.UrgencyRepository;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

/**
 * REST controller for managing Urgency.
 */
@RestController
@RequestMapping("/api")
public class UrgencyResourceImp {

    private final Logger log = LoggerFactory.getLogger(UrgencyResourceImp.class);

    private static final String ENTITY_NAME = "urgency";

    private UrgencyRepository urgencyRepository;

    public UrgencyResourceImp(UrgencyRepository urgencyRepository) {
        this.urgencyRepository = urgencyRepository;
    }

    /**
     * GET  /urgencies/remedy/:urgencyRemedy : get the "urgencyRemedy" urgency.
     *
     * @param urgencyRemedy the id of the urgency to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the urgency, or with status 404 (Not Found)
     */
    @GetMapping("/urgencies/remedy/{urgencyRemedy}")
    @Timed
    public ResponseEntity<Urgency> getUrgencyUrgencyRemedy(@PathVariable String urgencyRemedy) {
        log.debug("REST request to get Urgency : {}", urgencyRemedy);
        Urgency urgency = urgencyRepository.findUrgencyByUrgencyRemedy(urgencyRemedy);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(urgency));
    }
}
