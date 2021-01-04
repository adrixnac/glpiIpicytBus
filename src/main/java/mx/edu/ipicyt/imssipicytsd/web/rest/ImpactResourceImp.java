package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.Impact;
import mx.edu.ipicyt.imssipicytsd.repository.ImpactRepository;
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
public class ImpactResourceImp {
    private final Logger log = LoggerFactory.getLogger(ImpactResourceImp.class);
    private static final String ENTITY_NAME = "impact";
    private final ImpactRepository impactRepository;

    public ImpactResourceImp(ImpactRepository impactRepository) {
        this.impactRepository = impactRepository;
    }

    /**
     * GET  /impacts/:impactRemedy : get the "impactRemedy" impact.
     *
     * @param impactRemedy the impactRemedy of the impact to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the impact, or with status 404 (Not Found)
     */
    @GetMapping("/impacts/remedy/{impactRemedy}")
    @Timed
    public ResponseEntity<Impact> getImpactRemedy(@PathVariable Long impactRemedy) {
        log.debug("REST request to get Impact : {}", impactRemedy);
        Impact impact = impactRepository.findOne(impactRemedy);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(impact));
    }

}
