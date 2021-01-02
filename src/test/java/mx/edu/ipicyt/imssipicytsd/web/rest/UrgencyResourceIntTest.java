package mx.edu.ipicyt.imssipicytsd.web.rest;

import mx.edu.ipicyt.imssipicytsd.IpicytBussApp;

import mx.edu.ipicyt.imssipicytsd.domain.Urgency;
import mx.edu.ipicyt.imssipicytsd.repository.UrgencyRepository;
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
 * Test class for the UrgencyResource REST controller.
 *
 * @see UrgencyResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IpicytBussApp.class)
public class UrgencyResourceIntTest {

    private static final String DEFAULT_URGENCY_REMEDY = "AAAAAAAAAA";
    private static final String UPDATED_URGENCY_REMEDY = "BBBBBBBBBB";

    private static final String DEFAULT_URGENCY_GLPI = "AAAAAAAAAA";
    private static final String UPDATED_URGENCY_GLPI = "BBBBBBBBBB";

    private static final Integer DEFAULT_URGENCY_GLPI_ID = 1;
    private static final Integer UPDATED_URGENCY_GLPI_ID = 2;

    @Autowired
    private UrgencyRepository urgencyRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restUrgencyMockMvc;

    private Urgency urgency;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final UrgencyResource urgencyResource = new UrgencyResource(urgencyRepository);
        this.restUrgencyMockMvc = MockMvcBuilders.standaloneSetup(urgencyResource)
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
    public static Urgency createEntity(EntityManager em) {
        Urgency urgency = new Urgency()
            .urgencyRemedy(DEFAULT_URGENCY_REMEDY)
            .urgencyGlpi(DEFAULT_URGENCY_GLPI)
            .urgencyGlpiId(DEFAULT_URGENCY_GLPI_ID);
        return urgency;
    }

    @Before
    public void initTest() {
        urgency = createEntity(em);
    }

    @Test
    @Transactional
    public void createUrgency() throws Exception {
        int databaseSizeBeforeCreate = urgencyRepository.findAll().size();

        // Create the Urgency
        restUrgencyMockMvc.perform(post("/api/urgencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(urgency)))
            .andExpect(status().isCreated());

        // Validate the Urgency in the database
        List<Urgency> urgencyList = urgencyRepository.findAll();
        assertThat(urgencyList).hasSize(databaseSizeBeforeCreate + 1);
        Urgency testUrgency = urgencyList.get(urgencyList.size() - 1);
        assertThat(testUrgency.getUrgencyRemedy()).isEqualTo(DEFAULT_URGENCY_REMEDY);
        assertThat(testUrgency.getUrgencyGlpi()).isEqualTo(DEFAULT_URGENCY_GLPI);
        assertThat(testUrgency.getUrgencyGlpiId()).isEqualTo(DEFAULT_URGENCY_GLPI_ID);
    }

    @Test
    @Transactional
    public void createUrgencyWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = urgencyRepository.findAll().size();

        // Create the Urgency with an existing ID
        urgency.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUrgencyMockMvc.perform(post("/api/urgencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(urgency)))
            .andExpect(status().isBadRequest());

        // Validate the Urgency in the database
        List<Urgency> urgencyList = urgencyRepository.findAll();
        assertThat(urgencyList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkUrgencyRemedyIsRequired() throws Exception {
        int databaseSizeBeforeTest = urgencyRepository.findAll().size();
        // set the field null
        urgency.setUrgencyRemedy(null);

        // Create the Urgency, which fails.

        restUrgencyMockMvc.perform(post("/api/urgencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(urgency)))
            .andExpect(status().isBadRequest());

        List<Urgency> urgencyList = urgencyRepository.findAll();
        assertThat(urgencyList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUrgencyGlpiIsRequired() throws Exception {
        int databaseSizeBeforeTest = urgencyRepository.findAll().size();
        // set the field null
        urgency.setUrgencyGlpi(null);

        // Create the Urgency, which fails.

        restUrgencyMockMvc.perform(post("/api/urgencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(urgency)))
            .andExpect(status().isBadRequest());

        List<Urgency> urgencyList = urgencyRepository.findAll();
        assertThat(urgencyList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUrgencyGlpiIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = urgencyRepository.findAll().size();
        // set the field null
        urgency.setUrgencyGlpiId(null);

        // Create the Urgency, which fails.

        restUrgencyMockMvc.perform(post("/api/urgencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(urgency)))
            .andExpect(status().isBadRequest());

        List<Urgency> urgencyList = urgencyRepository.findAll();
        assertThat(urgencyList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllUrgencies() throws Exception {
        // Initialize the database
        urgencyRepository.saveAndFlush(urgency);

        // Get all the urgencyList
        restUrgencyMockMvc.perform(get("/api/urgencies?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(urgency.getId().intValue())))
            .andExpect(jsonPath("$.[*].urgencyRemedy").value(hasItem(DEFAULT_URGENCY_REMEDY.toString())))
            .andExpect(jsonPath("$.[*].urgencyGlpi").value(hasItem(DEFAULT_URGENCY_GLPI.toString())))
            .andExpect(jsonPath("$.[*].urgencyGlpiId").value(hasItem(DEFAULT_URGENCY_GLPI_ID)));
    }

    @Test
    @Transactional
    public void getUrgency() throws Exception {
        // Initialize the database
        urgencyRepository.saveAndFlush(urgency);

        // Get the urgency
        restUrgencyMockMvc.perform(get("/api/urgencies/{id}", urgency.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(urgency.getId().intValue()))
            .andExpect(jsonPath("$.urgencyRemedy").value(DEFAULT_URGENCY_REMEDY.toString()))
            .andExpect(jsonPath("$.urgencyGlpi").value(DEFAULT_URGENCY_GLPI.toString()))
            .andExpect(jsonPath("$.urgencyGlpiId").value(DEFAULT_URGENCY_GLPI_ID));
    }

    @Test
    @Transactional
    public void getNonExistingUrgency() throws Exception {
        // Get the urgency
        restUrgencyMockMvc.perform(get("/api/urgencies/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUrgency() throws Exception {
        // Initialize the database
        urgencyRepository.saveAndFlush(urgency);
        int databaseSizeBeforeUpdate = urgencyRepository.findAll().size();

        // Update the urgency
        Urgency updatedUrgency = urgencyRepository.findOne(urgency.getId());
        // Disconnect from session so that the updates on updatedUrgency are not directly saved in db
        em.detach(updatedUrgency);
        updatedUrgency
            .urgencyRemedy(UPDATED_URGENCY_REMEDY)
            .urgencyGlpi(UPDATED_URGENCY_GLPI)
            .urgencyGlpiId(UPDATED_URGENCY_GLPI_ID);

        restUrgencyMockMvc.perform(put("/api/urgencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedUrgency)))
            .andExpect(status().isOk());

        // Validate the Urgency in the database
        List<Urgency> urgencyList = urgencyRepository.findAll();
        assertThat(urgencyList).hasSize(databaseSizeBeforeUpdate);
        Urgency testUrgency = urgencyList.get(urgencyList.size() - 1);
        assertThat(testUrgency.getUrgencyRemedy()).isEqualTo(UPDATED_URGENCY_REMEDY);
        assertThat(testUrgency.getUrgencyGlpi()).isEqualTo(UPDATED_URGENCY_GLPI);
        assertThat(testUrgency.getUrgencyGlpiId()).isEqualTo(UPDATED_URGENCY_GLPI_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingUrgency() throws Exception {
        int databaseSizeBeforeUpdate = urgencyRepository.findAll().size();

        // Create the Urgency

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restUrgencyMockMvc.perform(put("/api/urgencies")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(urgency)))
            .andExpect(status().isCreated());

        // Validate the Urgency in the database
        List<Urgency> urgencyList = urgencyRepository.findAll();
        assertThat(urgencyList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteUrgency() throws Exception {
        // Initialize the database
        urgencyRepository.saveAndFlush(urgency);
        int databaseSizeBeforeDelete = urgencyRepository.findAll().size();

        // Get the urgency
        restUrgencyMockMvc.perform(delete("/api/urgencies/{id}", urgency.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Urgency> urgencyList = urgencyRepository.findAll();
        assertThat(urgencyList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Urgency.class);
        Urgency urgency1 = new Urgency();
        urgency1.setId(1L);
        Urgency urgency2 = new Urgency();
        urgency2.setId(urgency1.getId());
        assertThat(urgency1).isEqualTo(urgency2);
        urgency2.setId(2L);
        assertThat(urgency1).isNotEqualTo(urgency2);
        urgency1.setId(null);
        assertThat(urgency1).isNotEqualTo(urgency2);
    }
}
