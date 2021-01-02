package mx.edu.ipicyt.imssipicytsd.web.rest;

import mx.edu.ipicyt.imssipicytsd.IpicytBussApp;

import mx.edu.ipicyt.imssipicytsd.domain.SubtypeTransaction;
import mx.edu.ipicyt.imssipicytsd.repository.SubtypeTransactionRepository;
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
 * Test class for the SubtypeTransactionResource REST controller.
 *
 * @see SubtypeTransactionResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IpicytBussApp.class)
public class SubtypeTransactionResourceIntTest {

    private static final String DEFAULT_SUB_TYPE_TRANSACTION_REMEDY = "AAAAAAAAAA";
    private static final String UPDATED_SUB_TYPE_TRANSACTION_REMEDY = "BBBBBBBBBB";

    private static final String DEFAULT_SUB_TYPE_TRANSACTION_GLPI = "AAAAAAAAAA";
    private static final String UPDATED_SUB_TYPE_TRANSACTION_GLPI = "BBBBBBBBBB";

    private static final Integer DEFAULT_SUB_TYPE_TRANSACTION_ID = 1;
    private static final Integer UPDATED_SUB_TYPE_TRANSACTION_ID = 2;

    @Autowired
    private SubtypeTransactionRepository subtypeTransactionRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSubtypeTransactionMockMvc;

    private SubtypeTransaction subtypeTransaction;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SubtypeTransactionResource subtypeTransactionResource = new SubtypeTransactionResource(subtypeTransactionRepository);
        this.restSubtypeTransactionMockMvc = MockMvcBuilders.standaloneSetup(subtypeTransactionResource)
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
    public static SubtypeTransaction createEntity(EntityManager em) {
        SubtypeTransaction subtypeTransaction = new SubtypeTransaction()
            .subTypeTransactionRemedy(DEFAULT_SUB_TYPE_TRANSACTION_REMEDY)
            .subTypeTransactionGlpi(DEFAULT_SUB_TYPE_TRANSACTION_GLPI)
            .subTypeTransactionId(DEFAULT_SUB_TYPE_TRANSACTION_ID);
        return subtypeTransaction;
    }

    @Before
    public void initTest() {
        subtypeTransaction = createEntity(em);
    }

    @Test
    @Transactional
    public void createSubtypeTransaction() throws Exception {
        int databaseSizeBeforeCreate = subtypeTransactionRepository.findAll().size();

        // Create the SubtypeTransaction
        restSubtypeTransactionMockMvc.perform(post("/api/subtype-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subtypeTransaction)))
            .andExpect(status().isCreated());

        // Validate the SubtypeTransaction in the database
        List<SubtypeTransaction> subtypeTransactionList = subtypeTransactionRepository.findAll();
        assertThat(subtypeTransactionList).hasSize(databaseSizeBeforeCreate + 1);
        SubtypeTransaction testSubtypeTransaction = subtypeTransactionList.get(subtypeTransactionList.size() - 1);
        assertThat(testSubtypeTransaction.getSubTypeTransactionRemedy()).isEqualTo(DEFAULT_SUB_TYPE_TRANSACTION_REMEDY);
        assertThat(testSubtypeTransaction.getSubTypeTransactionGlpi()).isEqualTo(DEFAULT_SUB_TYPE_TRANSACTION_GLPI);
        assertThat(testSubtypeTransaction.getSubTypeTransactionId()).isEqualTo(DEFAULT_SUB_TYPE_TRANSACTION_ID);
    }

    @Test
    @Transactional
    public void createSubtypeTransactionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = subtypeTransactionRepository.findAll().size();

        // Create the SubtypeTransaction with an existing ID
        subtypeTransaction.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSubtypeTransactionMockMvc.perform(post("/api/subtype-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subtypeTransaction)))
            .andExpect(status().isBadRequest());

        // Validate the SubtypeTransaction in the database
        List<SubtypeTransaction> subtypeTransactionList = subtypeTransactionRepository.findAll();
        assertThat(subtypeTransactionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkSubTypeTransactionRemedyIsRequired() throws Exception {
        int databaseSizeBeforeTest = subtypeTransactionRepository.findAll().size();
        // set the field null
        subtypeTransaction.setSubTypeTransactionRemedy(null);

        // Create the SubtypeTransaction, which fails.

        restSubtypeTransactionMockMvc.perform(post("/api/subtype-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subtypeTransaction)))
            .andExpect(status().isBadRequest());

        List<SubtypeTransaction> subtypeTransactionList = subtypeTransactionRepository.findAll();
        assertThat(subtypeTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSubTypeTransactionGlpiIsRequired() throws Exception {
        int databaseSizeBeforeTest = subtypeTransactionRepository.findAll().size();
        // set the field null
        subtypeTransaction.setSubTypeTransactionGlpi(null);

        // Create the SubtypeTransaction, which fails.

        restSubtypeTransactionMockMvc.perform(post("/api/subtype-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subtypeTransaction)))
            .andExpect(status().isBadRequest());

        List<SubtypeTransaction> subtypeTransactionList = subtypeTransactionRepository.findAll();
        assertThat(subtypeTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSubTypeTransactionIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = subtypeTransactionRepository.findAll().size();
        // set the field null
        subtypeTransaction.setSubTypeTransactionId(null);

        // Create the SubtypeTransaction, which fails.

        restSubtypeTransactionMockMvc.perform(post("/api/subtype-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subtypeTransaction)))
            .andExpect(status().isBadRequest());

        List<SubtypeTransaction> subtypeTransactionList = subtypeTransactionRepository.findAll();
        assertThat(subtypeTransactionList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllSubtypeTransactions() throws Exception {
        // Initialize the database
        subtypeTransactionRepository.saveAndFlush(subtypeTransaction);

        // Get all the subtypeTransactionList
        restSubtypeTransactionMockMvc.perform(get("/api/subtype-transactions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(subtypeTransaction.getId().intValue())))
            .andExpect(jsonPath("$.[*].subTypeTransactionRemedy").value(hasItem(DEFAULT_SUB_TYPE_TRANSACTION_REMEDY.toString())))
            .andExpect(jsonPath("$.[*].subTypeTransactionGlpi").value(hasItem(DEFAULT_SUB_TYPE_TRANSACTION_GLPI.toString())))
            .andExpect(jsonPath("$.[*].subTypeTransactionId").value(hasItem(DEFAULT_SUB_TYPE_TRANSACTION_ID)));
    }

    @Test
    @Transactional
    public void getSubtypeTransaction() throws Exception {
        // Initialize the database
        subtypeTransactionRepository.saveAndFlush(subtypeTransaction);

        // Get the subtypeTransaction
        restSubtypeTransactionMockMvc.perform(get("/api/subtype-transactions/{id}", subtypeTransaction.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(subtypeTransaction.getId().intValue()))
            .andExpect(jsonPath("$.subTypeTransactionRemedy").value(DEFAULT_SUB_TYPE_TRANSACTION_REMEDY.toString()))
            .andExpect(jsonPath("$.subTypeTransactionGlpi").value(DEFAULT_SUB_TYPE_TRANSACTION_GLPI.toString()))
            .andExpect(jsonPath("$.subTypeTransactionId").value(DEFAULT_SUB_TYPE_TRANSACTION_ID));
    }

    @Test
    @Transactional
    public void getNonExistingSubtypeTransaction() throws Exception {
        // Get the subtypeTransaction
        restSubtypeTransactionMockMvc.perform(get("/api/subtype-transactions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSubtypeTransaction() throws Exception {
        // Initialize the database
        subtypeTransactionRepository.saveAndFlush(subtypeTransaction);
        int databaseSizeBeforeUpdate = subtypeTransactionRepository.findAll().size();

        // Update the subtypeTransaction
        SubtypeTransaction updatedSubtypeTransaction = subtypeTransactionRepository.findOne(subtypeTransaction.getId());
        // Disconnect from session so that the updates on updatedSubtypeTransaction are not directly saved in db
        em.detach(updatedSubtypeTransaction);
        updatedSubtypeTransaction
            .subTypeTransactionRemedy(UPDATED_SUB_TYPE_TRANSACTION_REMEDY)
            .subTypeTransactionGlpi(UPDATED_SUB_TYPE_TRANSACTION_GLPI)
            .subTypeTransactionId(UPDATED_SUB_TYPE_TRANSACTION_ID);

        restSubtypeTransactionMockMvc.perform(put("/api/subtype-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSubtypeTransaction)))
            .andExpect(status().isOk());

        // Validate the SubtypeTransaction in the database
        List<SubtypeTransaction> subtypeTransactionList = subtypeTransactionRepository.findAll();
        assertThat(subtypeTransactionList).hasSize(databaseSizeBeforeUpdate);
        SubtypeTransaction testSubtypeTransaction = subtypeTransactionList.get(subtypeTransactionList.size() - 1);
        assertThat(testSubtypeTransaction.getSubTypeTransactionRemedy()).isEqualTo(UPDATED_SUB_TYPE_TRANSACTION_REMEDY);
        assertThat(testSubtypeTransaction.getSubTypeTransactionGlpi()).isEqualTo(UPDATED_SUB_TYPE_TRANSACTION_GLPI);
        assertThat(testSubtypeTransaction.getSubTypeTransactionId()).isEqualTo(UPDATED_SUB_TYPE_TRANSACTION_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingSubtypeTransaction() throws Exception {
        int databaseSizeBeforeUpdate = subtypeTransactionRepository.findAll().size();

        // Create the SubtypeTransaction

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restSubtypeTransactionMockMvc.perform(put("/api/subtype-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(subtypeTransaction)))
            .andExpect(status().isCreated());

        // Validate the SubtypeTransaction in the database
        List<SubtypeTransaction> subtypeTransactionList = subtypeTransactionRepository.findAll();
        assertThat(subtypeTransactionList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteSubtypeTransaction() throws Exception {
        // Initialize the database
        subtypeTransactionRepository.saveAndFlush(subtypeTransaction);
        int databaseSizeBeforeDelete = subtypeTransactionRepository.findAll().size();

        // Get the subtypeTransaction
        restSubtypeTransactionMockMvc.perform(delete("/api/subtype-transactions/{id}", subtypeTransaction.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<SubtypeTransaction> subtypeTransactionList = subtypeTransactionRepository.findAll();
        assertThat(subtypeTransactionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SubtypeTransaction.class);
        SubtypeTransaction subtypeTransaction1 = new SubtypeTransaction();
        subtypeTransaction1.setId(1L);
        SubtypeTransaction subtypeTransaction2 = new SubtypeTransaction();
        subtypeTransaction2.setId(subtypeTransaction1.getId());
        assertThat(subtypeTransaction1).isEqualTo(subtypeTransaction2);
        subtypeTransaction2.setId(2L);
        assertThat(subtypeTransaction1).isNotEqualTo(subtypeTransaction2);
        subtypeTransaction1.setId(null);
        assertThat(subtypeTransaction1).isNotEqualTo(subtypeTransaction2);
    }
}
