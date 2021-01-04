package mx.edu.ipicyt.imssipicytsd.repository;

import mx.edu.ipicyt.imssipicytsd.domain.Transaction;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Transaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findTransactionByTransactionRemedy(String transactionRemedy);
}
