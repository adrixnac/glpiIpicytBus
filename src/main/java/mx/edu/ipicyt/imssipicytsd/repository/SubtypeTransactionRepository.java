package mx.edu.ipicyt.imssipicytsd.repository;

import mx.edu.ipicyt.imssipicytsd.domain.SubtypeTransaction;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the SubtypeTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SubtypeTransactionRepository extends JpaRepository<SubtypeTransaction, Long> {

}
