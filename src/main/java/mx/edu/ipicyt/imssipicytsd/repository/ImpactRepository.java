package mx.edu.ipicyt.imssipicytsd.repository;

import mx.edu.ipicyt.imssipicytsd.domain.Impact;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Impact entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImpactRepository extends JpaRepository<Impact, Long> {
    Impact findImpactByImpactRemedy(String impactRemedy);
}
