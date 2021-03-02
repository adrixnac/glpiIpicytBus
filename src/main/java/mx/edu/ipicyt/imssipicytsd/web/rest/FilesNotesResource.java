package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.edu.ipicyt.imssipicytsd.domain.FilesNotes;

import mx.edu.ipicyt.imssipicytsd.repository.FilesNotesRepository;
import mx.edu.ipicyt.imssipicytsd.soapserver.FileService;
import mx.edu.ipicyt.imssipicytsd.web.rest.errors.BadRequestAlertException;
import mx.edu.ipicyt.imssipicytsd.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing FilesNotes.
 */
@RestController
@RequestMapping("/api")
public class FilesNotesResource {

    private final Logger log = LoggerFactory.getLogger(FilesNotesResource.class);

    private static final String ENTITY_NAME = "filesNotes";

    private final FilesNotesRepository filesNotesRepository;

    public FilesNotesResource(FilesNotesRepository filesNotesRepository, FileService fileService) {
        this.filesNotesRepository = filesNotesRepository;
    }

    /**
     * POST  /files-notes : Create a new filesNotes.
     *
     * @param filesNotes the filesNotes to create
     * @return the ResponseEntity with status 201 (Created) and with body the new filesNotes, or with status 400 (Bad Request) if the filesNotes has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/files-notes")
    @Timed
    public ResponseEntity<FilesNotes> createFilesNotes(@Valid @RequestBody FilesNotes filesNotes) throws URISyntaxException {
        log.debug("REST request to save FilesNotes : {}", filesNotes);
        if (filesNotes.getId() != null) {
            throw new BadRequestAlertException("A new filesNotes cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FilesNotes result = filesNotesRepository.save(filesNotes);
        return ResponseEntity.created(new URI("/api/files-notes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /files-notes : Updates an existing filesNotes.
     *
     * @param filesNotes the filesNotes to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated filesNotes,
     * or with status 400 (Bad Request) if the filesNotes is not valid,
     * or with status 500 (Internal Server Error) if the filesNotes couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/files-notes")
    @Timed
    public ResponseEntity<FilesNotes> updateFilesNotes(@Valid @RequestBody FilesNotes filesNotes) throws URISyntaxException {
        log.debug("REST request to update FilesNotes : {}", filesNotes);
        if (filesNotes.getId() == null) {
            return createFilesNotes(filesNotes);
        }
        FilesNotes result = filesNotesRepository.save(filesNotes);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, filesNotes.getId().toString()))
            .body(result);
    }

    /**
     * GET  /files-notes : get all the filesNotes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of filesNotes in body
     */
    @GetMapping("/files-notes")
    @Timed
    public List<FilesNotes> getAllFilesNotes() {
        log.debug("REST request to get all FilesNotes");
        return filesNotesRepository.findAll();
        }

    /**
     * GET  /files-notes/:id : get the "id" filesNotes.
     *
     * @param id the id of the filesNotes to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the filesNotes, or with status 404 (Not Found)
     */
    @GetMapping("/files-notes/{id}")
    @Timed
    public ResponseEntity<FilesNotes> getFilesNotes(@PathVariable Long id) {
        log.debug("REST request to get FilesNotes : {}", id);
        FilesNotes filesNotes = filesNotesRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(filesNotes));
    }

    /**
     * DELETE  /files-notes/:id : delete the "id" filesNotes.
     *
     * @param id the id of the filesNotes to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/files-notes/{id}")
    @Timed
    public ResponseEntity<Void> deleteFilesNotes(@PathVariable Long id) {
        log.debug("REST request to delete FilesNotes : {}", id);
        filesNotesRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
