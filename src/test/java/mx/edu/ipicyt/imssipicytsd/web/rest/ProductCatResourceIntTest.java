package mx.edu.ipicyt.imssipicytsd.web.rest;

import mx.edu.ipicyt.imssipicytsd.IpicytBussApp;

import mx.edu.ipicyt.imssipicytsd.domain.ProductCat;
import mx.edu.ipicyt.imssipicytsd.repository.ProductCatRepository;
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
 * Test class for the ProductCatResource REST controller.
 *
 * @see ProductCatResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IpicytBussApp.class)
public class ProductCatResourceIntTest {

    private static final String DEFAULT_PRODUCT_CAT_GLPI = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_CAT_GLPI = "BBBBBBBBBB";

    private static final Integer DEFAULT_PRODUCT_CAT_GLPI_ID = 1;
    private static final Integer UPDATED_PRODUCT_CAT_GLPI_ID = 2;

    private static final String DEFAULT_PRODUCT_CAT_STRUCTURE = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_CAT_STRUCTURE = "BBBBBBBBBB";

    @Autowired
    private ProductCatRepository productCatRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restProductCatMockMvc;

    private ProductCat productCat;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ProductCatResource productCatResource = new ProductCatResource(productCatRepository);
        this.restProductCatMockMvc = MockMvcBuilders.standaloneSetup(productCatResource)
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
    public static ProductCat createEntity(EntityManager em) {
        ProductCat productCat = new ProductCat()
            .productCatGlpi(DEFAULT_PRODUCT_CAT_GLPI)
            .productCatGlpiId(DEFAULT_PRODUCT_CAT_GLPI_ID)
            .productCatStructure(DEFAULT_PRODUCT_CAT_STRUCTURE);
        return productCat;
    }

    @Before
    public void initTest() {
        productCat = createEntity(em);
    }

    @Test
    @Transactional
    public void createProductCat() throws Exception {
        int databaseSizeBeforeCreate = productCatRepository.findAll().size();

        // Create the ProductCat
        restProductCatMockMvc.perform(post("/api/product-cats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productCat)))
            .andExpect(status().isCreated());

        // Validate the ProductCat in the database
        List<ProductCat> productCatList = productCatRepository.findAll();
        assertThat(productCatList).hasSize(databaseSizeBeforeCreate + 1);
        ProductCat testProductCat = productCatList.get(productCatList.size() - 1);
        assertThat(testProductCat.getProductCatGlpi()).isEqualTo(DEFAULT_PRODUCT_CAT_GLPI);
        assertThat(testProductCat.getProductCatGlpiId()).isEqualTo(DEFAULT_PRODUCT_CAT_GLPI_ID);
        assertThat(testProductCat.getProductCatStructure()).isEqualTo(DEFAULT_PRODUCT_CAT_STRUCTURE);
    }

    @Test
    @Transactional
    public void createProductCatWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = productCatRepository.findAll().size();

        // Create the ProductCat with an existing ID
        productCat.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductCatMockMvc.perform(post("/api/product-cats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productCat)))
            .andExpect(status().isBadRequest());

        // Validate the ProductCat in the database
        List<ProductCat> productCatList = productCatRepository.findAll();
        assertThat(productCatList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkProductCatGlpiIsRequired() throws Exception {
        int databaseSizeBeforeTest = productCatRepository.findAll().size();
        // set the field null
        productCat.setProductCatGlpi(null);

        // Create the ProductCat, which fails.

        restProductCatMockMvc.perform(post("/api/product-cats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productCat)))
            .andExpect(status().isBadRequest());

        List<ProductCat> productCatList = productCatRepository.findAll();
        assertThat(productCatList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkProductCatGlpiIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = productCatRepository.findAll().size();
        // set the field null
        productCat.setProductCatGlpiId(null);

        // Create the ProductCat, which fails.

        restProductCatMockMvc.perform(post("/api/product-cats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productCat)))
            .andExpect(status().isBadRequest());

        List<ProductCat> productCatList = productCatRepository.findAll();
        assertThat(productCatList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkProductCatStructureIsRequired() throws Exception {
        int databaseSizeBeforeTest = productCatRepository.findAll().size();
        // set the field null
        productCat.setProductCatStructure(null);

        // Create the ProductCat, which fails.

        restProductCatMockMvc.perform(post("/api/product-cats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productCat)))
            .andExpect(status().isBadRequest());

        List<ProductCat> productCatList = productCatRepository.findAll();
        assertThat(productCatList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProductCats() throws Exception {
        // Initialize the database
        productCatRepository.saveAndFlush(productCat);

        // Get all the productCatList
        restProductCatMockMvc.perform(get("/api/product-cats?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(productCat.getId().intValue())))
            .andExpect(jsonPath("$.[*].productCatGlpi").value(hasItem(DEFAULT_PRODUCT_CAT_GLPI.toString())))
            .andExpect(jsonPath("$.[*].productCatGlpiId").value(hasItem(DEFAULT_PRODUCT_CAT_GLPI_ID)))
            .andExpect(jsonPath("$.[*].productCatStructure").value(hasItem(DEFAULT_PRODUCT_CAT_STRUCTURE.toString())));
    }

    @Test
    @Transactional
    public void getProductCat() throws Exception {
        // Initialize the database
        productCatRepository.saveAndFlush(productCat);

        // Get the productCat
        restProductCatMockMvc.perform(get("/api/product-cats/{id}", productCat.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(productCat.getId().intValue()))
            .andExpect(jsonPath("$.productCatGlpi").value(DEFAULT_PRODUCT_CAT_GLPI.toString()))
            .andExpect(jsonPath("$.productCatGlpiId").value(DEFAULT_PRODUCT_CAT_GLPI_ID))
            .andExpect(jsonPath("$.productCatStructure").value(DEFAULT_PRODUCT_CAT_STRUCTURE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProductCat() throws Exception {
        // Get the productCat
        restProductCatMockMvc.perform(get("/api/product-cats/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProductCat() throws Exception {
        // Initialize the database
        productCatRepository.saveAndFlush(productCat);
        int databaseSizeBeforeUpdate = productCatRepository.findAll().size();

        // Update the productCat
        ProductCat updatedProductCat = productCatRepository.findOne(productCat.getId());
        // Disconnect from session so that the updates on updatedProductCat are not directly saved in db
        em.detach(updatedProductCat);
        updatedProductCat
            .productCatGlpi(UPDATED_PRODUCT_CAT_GLPI)
            .productCatGlpiId(UPDATED_PRODUCT_CAT_GLPI_ID)
            .productCatStructure(UPDATED_PRODUCT_CAT_STRUCTURE);

        restProductCatMockMvc.perform(put("/api/product-cats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedProductCat)))
            .andExpect(status().isOk());

        // Validate the ProductCat in the database
        List<ProductCat> productCatList = productCatRepository.findAll();
        assertThat(productCatList).hasSize(databaseSizeBeforeUpdate);
        ProductCat testProductCat = productCatList.get(productCatList.size() - 1);
        assertThat(testProductCat.getProductCatGlpi()).isEqualTo(UPDATED_PRODUCT_CAT_GLPI);
        assertThat(testProductCat.getProductCatGlpiId()).isEqualTo(UPDATED_PRODUCT_CAT_GLPI_ID);
        assertThat(testProductCat.getProductCatStructure()).isEqualTo(UPDATED_PRODUCT_CAT_STRUCTURE);
    }

    @Test
    @Transactional
    public void updateNonExistingProductCat() throws Exception {
        int databaseSizeBeforeUpdate = productCatRepository.findAll().size();

        // Create the ProductCat

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restProductCatMockMvc.perform(put("/api/product-cats")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(productCat)))
            .andExpect(status().isCreated());

        // Validate the ProductCat in the database
        List<ProductCat> productCatList = productCatRepository.findAll();
        assertThat(productCatList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteProductCat() throws Exception {
        // Initialize the database
        productCatRepository.saveAndFlush(productCat);
        int databaseSizeBeforeDelete = productCatRepository.findAll().size();

        // Get the productCat
        restProductCatMockMvc.perform(delete("/api/product-cats/{id}", productCat.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ProductCat> productCatList = productCatRepository.findAll();
        assertThat(productCatList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductCat.class);
        ProductCat productCat1 = new ProductCat();
        productCat1.setId(1L);
        ProductCat productCat2 = new ProductCat();
        productCat2.setId(productCat1.getId());
        assertThat(productCat1).isEqualTo(productCat2);
        productCat2.setId(2L);
        assertThat(productCat1).isNotEqualTo(productCat2);
        productCat1.setId(null);
        assertThat(productCat1).isNotEqualTo(productCat2);
    }
}
