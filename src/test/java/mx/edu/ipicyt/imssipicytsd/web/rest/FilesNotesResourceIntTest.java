package mx.edu.ipicyt.imssipicytsd.web.rest;

import mx.edu.ipicyt.imssipicytsd.IpicytBussApp;

import mx.edu.ipicyt.imssipicytsd.domain.FilesNotes;
import mx.edu.ipicyt.imssipicytsd.repository.FilesNotesRepository;
import mx.edu.ipicyt.imssipicytsd.soapserver.FileService;
import mx.edu.ipicyt.imssipicytsd.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static mx.edu.ipicyt.imssipicytsd.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the FilesNotesResource REST controller.
 *
 * @see FilesNotesResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IpicytBussApp.class)
public class FilesNotesResourceIntTest {

    private static final String DEFAULT_ID_REMEDY_GLPI = "AAAAAAAAAA";
    private static final String UPDATED_ID_REMEDY_GLPI = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_TRANSACCION = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_TRANSACCION = "BBBBBBBBBB";

    private static final String DEFAULT_SUB_TYPE_TRANSACTION = "AAAAAAAAAA";
    private static final String UPDATED_SUB_TYPE_TRANSACTION = "BBBBBBBBBB";

    private static final String DEFAULT_ID_REFERENCIA_CLIENTE = "AAAAAAAAAA";
    private static final String UPDATED_ID_REFERENCIA_CLIENTE = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_WORK_LOG_SUMMARY = "AAAAAAAAAA";
    private static final String UPDATED_WORK_LOG_SUMMARY = "BBBBBBBBBB";

    private static final String DEFAULT_WORK_INFO_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_WORK_INFO_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_NAME_1 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_NAME_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_TYPE_1 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_TYPE_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_DATA_1 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_DATA_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_NAME_2 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_NAME_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_TYPE_2 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_TYPE_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_DATA_2 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_DATA_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_NAME_3 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_NAME_3 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_TYPE_3 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_TYPE_3 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHMENT_FILE_DATA_3 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHMENT_FILE_DATA_3 = "BBBBBBBBBB";

    @Autowired
    private FilesNotesRepository filesNotesRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restFilesNotesMockMvc;

    private FilesNotes filesNotes;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        FileService fileService = null;
        final FilesNotesResource filesNotesResource = new FilesNotesResource(filesNotesRepository,fileService);
        this.restFilesNotesMockMvc = MockMvcBuilders.standaloneSetup(filesNotesResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static FilesNotes createEntity(EntityManager em) {
        FilesNotes filesNotes = new FilesNotes()
            .idRemedyGlpi(DEFAULT_ID_REMEDY_GLPI)
            .typeTransaccion(DEFAULT_TYPE_TRANSACCION)
            .subTypeTransaction(DEFAULT_SUB_TYPE_TRANSACTION)
            .idReferenciaCliente(DEFAULT_ID_REFERENCIA_CLIENTE)
            .company(DEFAULT_COMPANY)
            .workLogSummary(DEFAULT_WORK_LOG_SUMMARY)
            .workInfoNotes(DEFAULT_WORK_INFO_NOTES)
            .attachmentFileName1(DEFAULT_ATTACHMENT_FILE_NAME_1)
            .attachmentFileType1(DEFAULT_ATTACHMENT_FILE_TYPE_1)
            .attachmentFileData1(DEFAULT_ATTACHMENT_FILE_DATA_1)
            .attachmentFileName2(DEFAULT_ATTACHMENT_FILE_NAME_2)
            .attachmentFileType2(DEFAULT_ATTACHMENT_FILE_TYPE_2)
            .attachmentFileData2(DEFAULT_ATTACHMENT_FILE_DATA_2)
            .attachmentFileName3(DEFAULT_ATTACHMENT_FILE_NAME_3)
            .attachmentFileType3(DEFAULT_ATTACHMENT_FILE_TYPE_3)
            .attachmentFileData3(DEFAULT_ATTACHMENT_FILE_DATA_3);
        return filesNotes;
    }

    @Before
    public void initTest() {
        filesNotes = createEntity(em);
    }

    @Test
    @Transactional
    public void createFilesNotes() throws Exception {
        int databaseSizeBeforeCreate = filesNotesRepository.findAll().size();

        // Create the FilesNotes
        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isCreated());

        // Validate the FilesNotes in the database
        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeCreate + 1);
        FilesNotes testFilesNotes = filesNotesList.get(filesNotesList.size() - 1);
        assertThat(testFilesNotes.getIdRemedyGlpi()).isEqualTo(DEFAULT_ID_REMEDY_GLPI);
        assertThat(testFilesNotes.getTypeTransaccion()).isEqualTo(DEFAULT_TYPE_TRANSACCION);
        assertThat(testFilesNotes.getSubTypeTransaction()).isEqualTo(DEFAULT_SUB_TYPE_TRANSACTION);
        assertThat(testFilesNotes.getIdReferenciaCliente()).isEqualTo(DEFAULT_ID_REFERENCIA_CLIENTE);
        assertThat(testFilesNotes.getCompany()).isEqualTo(DEFAULT_COMPANY);
        assertThat(testFilesNotes.getWorkLogSummary()).isEqualTo(DEFAULT_WORK_LOG_SUMMARY);
        assertThat(testFilesNotes.getWorkInfoNotes()).isEqualTo(DEFAULT_WORK_INFO_NOTES);
        assertThat(testFilesNotes.getAttachmentFileName1()).isEqualTo(DEFAULT_ATTACHMENT_FILE_NAME_1);
        assertThat(testFilesNotes.getAttachmentFileType1()).isEqualTo(DEFAULT_ATTACHMENT_FILE_TYPE_1);
        assertThat(testFilesNotes.getAttachmentFileData1()).isEqualTo(DEFAULT_ATTACHMENT_FILE_DATA_1);
        assertThat(testFilesNotes.getAttachmentFileName2()).isEqualTo(DEFAULT_ATTACHMENT_FILE_NAME_2);
        assertThat(testFilesNotes.getAttachmentFileType2()).isEqualTo(DEFAULT_ATTACHMENT_FILE_TYPE_2);
        assertThat(testFilesNotes.getAttachmentFileData2()).isEqualTo(DEFAULT_ATTACHMENT_FILE_DATA_2);
        assertThat(testFilesNotes.getAttachmentFileName3()).isEqualTo(DEFAULT_ATTACHMENT_FILE_NAME_3);
        assertThat(testFilesNotes.getAttachmentFileType3()).isEqualTo(DEFAULT_ATTACHMENT_FILE_TYPE_3);
        assertThat(testFilesNotes.getAttachmentFileData3()).isEqualTo(DEFAULT_ATTACHMENT_FILE_DATA_3);
    }

    @Test
    @Transactional
    public void createFilesNotesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = filesNotesRepository.findAll().size();

        // Create the FilesNotes with an existing ID
        filesNotes.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isBadRequest());

        // Validate the FilesNotes in the database
        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkIdRemedyGlpiIsRequired() throws Exception {
        int databaseSizeBeforeTest = filesNotesRepository.findAll().size();
        // set the field null
        filesNotes.setIdRemedyGlpi(null);

        // Create the FilesNotes, which fails.

        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isBadRequest());

        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTypeTransaccionIsRequired() throws Exception {
        int databaseSizeBeforeTest = filesNotesRepository.findAll().size();
        // set the field null
        filesNotes.setTypeTransaccion(null);

        // Create the FilesNotes, which fails.

        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isBadRequest());

        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSubTypeTransactionIsRequired() throws Exception {
        int databaseSizeBeforeTest = filesNotesRepository.findAll().size();
        // set the field null
        filesNotes.setSubTypeTransaction(null);

        // Create the FilesNotes, which fails.

        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isBadRequest());

        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIdReferenciaClienteIsRequired() throws Exception {
        int databaseSizeBeforeTest = filesNotesRepository.findAll().size();
        // set the field null
        filesNotes.setIdReferenciaCliente(null);

        // Create the FilesNotes, which fails.

        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isBadRequest());

        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCompanyIsRequired() throws Exception {
        int databaseSizeBeforeTest = filesNotesRepository.findAll().size();
        // set the field null
        filesNotes.setCompany(null);

        // Create the FilesNotes, which fails.

        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isBadRequest());

        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkWorkLogSummaryIsRequired() throws Exception {
        int databaseSizeBeforeTest = filesNotesRepository.findAll().size();
        // set the field null
        filesNotes.setWorkLogSummary(null);

        // Create the FilesNotes, which fails.

        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isBadRequest());

        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkWorkInfoNotesIsRequired() throws Exception {
        int databaseSizeBeforeTest = filesNotesRepository.findAll().size();
        // set the field null
        filesNotes.setWorkInfoNotes(null);

        // Create the FilesNotes, which fails.

        restFilesNotesMockMvc.perform(post("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isBadRequest());

        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllFilesNotes() throws Exception {
        // Initialize the database
        filesNotesRepository.saveAndFlush(filesNotes);

        // Get all the filesNotesList
        restFilesNotesMockMvc.perform(get("/api/files-notes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(filesNotes.getId().intValue())))
            .andExpect(jsonPath("$.[*].idRemedyGlpi").value(hasItem(DEFAULT_ID_REMEDY_GLPI.toString())))
            .andExpect(jsonPath("$.[*].typeTransaccion").value(hasItem(DEFAULT_TYPE_TRANSACCION.toString())))
            .andExpect(jsonPath("$.[*].subTypeTransaction").value(hasItem(DEFAULT_SUB_TYPE_TRANSACTION.toString())))
            .andExpect(jsonPath("$.[*].idReferenciaCliente").value(hasItem(DEFAULT_ID_REFERENCIA_CLIENTE.toString())))
            .andExpect(jsonPath("$.[*].company").value(hasItem(DEFAULT_COMPANY.toString())))
            .andExpect(jsonPath("$.[*].workLogSummary").value(hasItem(DEFAULT_WORK_LOG_SUMMARY.toString())))
            .andExpect(jsonPath("$.[*].workInfoNotes").value(hasItem(DEFAULT_WORK_INFO_NOTES.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileName1").value(hasItem(DEFAULT_ATTACHMENT_FILE_NAME_1.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileType1").value(hasItem(DEFAULT_ATTACHMENT_FILE_TYPE_1.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileData1").value(hasItem(DEFAULT_ATTACHMENT_FILE_DATA_1.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileName2").value(hasItem(DEFAULT_ATTACHMENT_FILE_NAME_2.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileType2").value(hasItem(DEFAULT_ATTACHMENT_FILE_TYPE_2.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileData2").value(hasItem(DEFAULT_ATTACHMENT_FILE_DATA_2.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileName3").value(hasItem(DEFAULT_ATTACHMENT_FILE_NAME_3.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileType3").value(hasItem(DEFAULT_ATTACHMENT_FILE_TYPE_3.toString())))
            .andExpect(jsonPath("$.[*].attachmentFileData3").value(hasItem(DEFAULT_ATTACHMENT_FILE_DATA_3.toString())));
    }

    @Test
    @Transactional
    public void getFilesNotes() throws Exception {
        // Initialize the database
        filesNotesRepository.saveAndFlush(filesNotes);

        // Get the filesNotes
        restFilesNotesMockMvc.perform(get("/api/files-notes/{id}", filesNotes.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(filesNotes.getId().intValue()))
            .andExpect(jsonPath("$.idRemedyGlpi").value(DEFAULT_ID_REMEDY_GLPI.toString()))
            .andExpect(jsonPath("$.typeTransaccion").value(DEFAULT_TYPE_TRANSACCION.toString()))
            .andExpect(jsonPath("$.subTypeTransaction").value(DEFAULT_SUB_TYPE_TRANSACTION.toString()))
            .andExpect(jsonPath("$.idReferenciaCliente").value(DEFAULT_ID_REFERENCIA_CLIENTE.toString()))
            .andExpect(jsonPath("$.company").value(DEFAULT_COMPANY.toString()))
            .andExpect(jsonPath("$.workLogSummary").value(DEFAULT_WORK_LOG_SUMMARY.toString()))
            .andExpect(jsonPath("$.workInfoNotes").value(DEFAULT_WORK_INFO_NOTES.toString()))
            .andExpect(jsonPath("$.attachmentFileName1").value(DEFAULT_ATTACHMENT_FILE_NAME_1.toString()))
            .andExpect(jsonPath("$.attachmentFileType1").value(DEFAULT_ATTACHMENT_FILE_TYPE_1.toString()))
            .andExpect(jsonPath("$.attachmentFileData1").value(DEFAULT_ATTACHMENT_FILE_DATA_1.toString()))
            .andExpect(jsonPath("$.attachmentFileName2").value(DEFAULT_ATTACHMENT_FILE_NAME_2.toString()))
            .andExpect(jsonPath("$.attachmentFileType2").value(DEFAULT_ATTACHMENT_FILE_TYPE_2.toString()))
            .andExpect(jsonPath("$.attachmentFileData2").value(DEFAULT_ATTACHMENT_FILE_DATA_2.toString()))
            .andExpect(jsonPath("$.attachmentFileName3").value(DEFAULT_ATTACHMENT_FILE_NAME_3.toString()))
            .andExpect(jsonPath("$.attachmentFileType3").value(DEFAULT_ATTACHMENT_FILE_TYPE_3.toString()))
            .andExpect(jsonPath("$.attachmentFileData3").value(DEFAULT_ATTACHMENT_FILE_DATA_3.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingFilesNotes() throws Exception {
        // Get the filesNotes
        restFilesNotesMockMvc.perform(get("/api/files-notes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFilesNotes() throws Exception {
        // Initialize the database
        filesNotesRepository.saveAndFlush(filesNotes);
        int databaseSizeBeforeUpdate = filesNotesRepository.findAll().size();

        // Update the filesNotes
        FilesNotes updatedFilesNotes = filesNotesRepository.findOne(filesNotes.getId());
        // Disconnect from session so that the updates on updatedFilesNotes are not directly saved in db
        em.detach(updatedFilesNotes);
        updatedFilesNotes
            .idRemedyGlpi(UPDATED_ID_REMEDY_GLPI)
            .typeTransaccion(UPDATED_TYPE_TRANSACCION)
            .subTypeTransaction(UPDATED_SUB_TYPE_TRANSACTION)
            .idReferenciaCliente(UPDATED_ID_REFERENCIA_CLIENTE)
            .company(UPDATED_COMPANY)
            .workLogSummary(UPDATED_WORK_LOG_SUMMARY)
            .workInfoNotes(UPDATED_WORK_INFO_NOTES)
            .attachmentFileName1(UPDATED_ATTACHMENT_FILE_NAME_1)
            .attachmentFileType1(UPDATED_ATTACHMENT_FILE_TYPE_1)
            .attachmentFileData1(UPDATED_ATTACHMENT_FILE_DATA_1)
            .attachmentFileName2(UPDATED_ATTACHMENT_FILE_NAME_2)
            .attachmentFileType2(UPDATED_ATTACHMENT_FILE_TYPE_2)
            .attachmentFileData2(UPDATED_ATTACHMENT_FILE_DATA_2)
            .attachmentFileName3(UPDATED_ATTACHMENT_FILE_NAME_3)
            .attachmentFileType3(UPDATED_ATTACHMENT_FILE_TYPE_3)
            .attachmentFileData3(UPDATED_ATTACHMENT_FILE_DATA_3);

        restFilesNotesMockMvc.perform(put("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedFilesNotes)))
            .andExpect(status().isOk());

        // Validate the FilesNotes in the database
        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeUpdate);
        FilesNotes testFilesNotes = filesNotesList.get(filesNotesList.size() - 1);
        assertThat(testFilesNotes.getIdRemedyGlpi()).isEqualTo(UPDATED_ID_REMEDY_GLPI);
        assertThat(testFilesNotes.getTypeTransaccion()).isEqualTo(UPDATED_TYPE_TRANSACCION);
        assertThat(testFilesNotes.getSubTypeTransaction()).isEqualTo(UPDATED_SUB_TYPE_TRANSACTION);
        assertThat(testFilesNotes.getIdReferenciaCliente()).isEqualTo(UPDATED_ID_REFERENCIA_CLIENTE);
        assertThat(testFilesNotes.getCompany()).isEqualTo(UPDATED_COMPANY);
        assertThat(testFilesNotes.getWorkLogSummary()).isEqualTo(UPDATED_WORK_LOG_SUMMARY);
        assertThat(testFilesNotes.getWorkInfoNotes()).isEqualTo(UPDATED_WORK_INFO_NOTES);
        assertThat(testFilesNotes.getAttachmentFileName1()).isEqualTo(UPDATED_ATTACHMENT_FILE_NAME_1);
        assertThat(testFilesNotes.getAttachmentFileType1()).isEqualTo(UPDATED_ATTACHMENT_FILE_TYPE_1);
        assertThat(testFilesNotes.getAttachmentFileData1()).isEqualTo(UPDATED_ATTACHMENT_FILE_DATA_1);
        assertThat(testFilesNotes.getAttachmentFileName2()).isEqualTo(UPDATED_ATTACHMENT_FILE_NAME_2);
        assertThat(testFilesNotes.getAttachmentFileType2()).isEqualTo(UPDATED_ATTACHMENT_FILE_TYPE_2);
        assertThat(testFilesNotes.getAttachmentFileData2()).isEqualTo(UPDATED_ATTACHMENT_FILE_DATA_2);
        assertThat(testFilesNotes.getAttachmentFileName3()).isEqualTo(UPDATED_ATTACHMENT_FILE_NAME_3);
        assertThat(testFilesNotes.getAttachmentFileType3()).isEqualTo(UPDATED_ATTACHMENT_FILE_TYPE_3);
        assertThat(testFilesNotes.getAttachmentFileData3()).isEqualTo(UPDATED_ATTACHMENT_FILE_DATA_3);
    }

    @Test
    @Transactional
    public void updateNonExistingFilesNotes() throws Exception {
        int databaseSizeBeforeUpdate = filesNotesRepository.findAll().size();

        // Create the FilesNotes

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restFilesNotesMockMvc.perform(put("/api/files-notes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(filesNotes)))
            .andExpect(status().isCreated());

        // Validate the FilesNotes in the database
        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteFilesNotes() throws Exception {
        // Initialize the database
        filesNotesRepository.saveAndFlush(filesNotes);
        int databaseSizeBeforeDelete = filesNotesRepository.findAll().size();

        // Get the filesNotes
        restFilesNotesMockMvc.perform(delete("/api/files-notes/{id}", filesNotes.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<FilesNotes> filesNotesList = filesNotesRepository.findAll();
        assertThat(filesNotesList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FilesNotes.class);
        FilesNotes filesNotes1 = new FilesNotes();
        filesNotes1.setId(1L);
        FilesNotes filesNotes2 = new FilesNotes();
        filesNotes2.setId(filesNotes1.getId());
        assertThat(filesNotes1).isEqualTo(filesNotes2);
        filesNotes2.setId(2L);
        assertThat(filesNotes1).isNotEqualTo(filesNotes2);
        filesNotes1.setId(null);
        assertThat(filesNotes1).isNotEqualTo(filesNotes2);
    }
}
