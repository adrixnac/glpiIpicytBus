package mx.edu.ipicyt.imssipicytsd.repository;

import mx.edu.ipicyt.imssipicytsd.domain.Priority;
import mx.edu.ipicyt.imssipicytsd.domain.Urgency;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Priority entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
