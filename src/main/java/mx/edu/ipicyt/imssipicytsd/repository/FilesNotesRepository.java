package mx.edu.ipicyt.imssipicytsd.repository;

import mx.edu.ipicyt.imssipicytsd.domain.FilesNotes;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the FilesNotes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FilesNotesRepository extends JpaRepository<FilesNotes, Long> {

}
