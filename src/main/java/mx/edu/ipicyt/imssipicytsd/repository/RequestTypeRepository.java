package mx.edu.ipicyt.imssipicytsd.repository;

import mx.edu.ipicyt.imssipicytsd.domain.RequestType;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the RequestType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RequestTypeRepository extends JpaRepository<RequestType, Long> {
    RequestType findRequestTypeByRequestTypeRemedy(String requestTypeRemedy);
    RequestType findFirstByRequestTypeRemedyEquals(String requestTypeRemedy);
}
