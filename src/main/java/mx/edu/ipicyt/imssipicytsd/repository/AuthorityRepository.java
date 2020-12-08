package mx.edu.ipicyt.imssipicytsd.repository;

import mx.edu.ipicyt.imssipicytsd.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
