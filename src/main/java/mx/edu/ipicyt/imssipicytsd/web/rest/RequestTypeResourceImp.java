package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.RequestType;
import mx.edu.ipicyt.imssipicytsd.repository.RequestTypeRepository;
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
public class RequestTypeResourceImp {
    private final Logger log = LoggerFactory.getLogger(RequestTypeResourceImp.class);
    private static final String ENTITY_NAME = "requestType";
    private final RequestTypeRepository requestTypeRepository;

    public RequestTypeResourceImp(RequestTypeRepository requestTypeRepository) {
        this.requestTypeRepository = requestTypeRepository;
    }

    /**
     * GET  /request-types/:requestTypeRemedy : get the "requestTypeRemedy" requestType.
     *
     * @param requestTypeRemedy the requestTypeRemedy of the requestType to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the requestType, or with status 404 (Not Found)
     */
    @GetMapping("/request-types/{requestTypeRemedy}")
    @Timed
    public ResponseEntity<RequestType> getRequestTypeRemedy(@PathVariable String requestTypeRemedy) {
        log.debug("REST request to get RequestType : {}", requestTypeRemedy);
        RequestType requestType = requestTypeRepository.findRequestTypeByRequestTypeRemedy(requestTypeRemedy);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(requestType));
    }

}
