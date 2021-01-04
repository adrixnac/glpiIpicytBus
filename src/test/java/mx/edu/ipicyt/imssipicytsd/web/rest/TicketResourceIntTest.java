package mx.edu.ipicyt.imssipicytsd.web.rest;

import mx.edu.ipicyt.imssipicytsd.IpicytBussApp;

import mx.edu.ipicyt.imssipicytsd.domain.Ticket;
import mx.edu.ipicyt.imssipicytsd.repository.TicketRepository;
import mx.edu.ipicyt.imssipicytsd.service.TicketIpicytService;
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
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static mx.edu.ipicyt.imssipicytsd.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the TicketResource REST controller.
 *
 * @see TicketResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IpicytBussApp.class)
public class TicketResourceIntTest {

    private static final String DEFAULT_ID_REMEDY_GLPI = "AAAAAAAAAA";
    private static final String UPDATED_ID_REMEDY_GLPI = "BBBBBBBBBB";

    private static final String DEFAULT_SUB_TYPE_TRANSACTION = "AAAAAAAAAA";
    private static final String UPDATED_SUB_TYPE_TRANSACTION = "BBBBBBBBBB";

    private static final String DEFAULT_ID_REFERENCIA_CLIENTE = "AAAAAAAAAA";
    private static final String UPDATED_ID_REFERENCIA_CLIENTE = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_PROD_CAT_01 = "AAAAAAAAAA";
    private static final String UPDATED_PROD_CAT_01 = "BBBBBBBBBB";

    private static final String DEFAULT_PROD_CAT_02 = "AAAAAAAAAA";
    private static final String UPDATED_PROD_CAT_02 = "BBBBBBBBBB";

    private static final String DEFAULT_PROD_CAT_03 = "AAAAAAAAAA";
    private static final String UPDATED_PROD_CAT_03 = "BBBBBBBBBB";

    private static final String DEFAULT_NOMBRE_PRODUCTO = "AAAAAAAAAA";
    private static final String UPDATED_NOMBRE_PRODUCTO = "BBBBBBBBBB";

    private static final String DEFAULT_CAT_OP_01 = "AAAAAAAAAA";
    private static final String UPDATED_CAT_OP_01 = "BBBBBBBBBB";

    private static final String DEFAULT_CAT_OP_02 = "AAAAAAAAAA";
    private static final String UPDATED_CAT_OP_02 = "BBBBBBBBBB";

    private static final String DEFAULT_CAT_OP_03 = "AAAAAAAAAA";
    private static final String UPDATED_CAT_OP_03 = "BBBBBBBBBB";

    private static final String DEFAULT_GLPI_TICKETS_REQUESTTYPES_ID = "AAAAAAAAAA";
    private static final String UPDATED_GLPI_TICKETS_REQUESTTYPES_ID = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_IMPACT = "AAAAAAAAAA";
    private static final String UPDATED_IMPACT = "BBBBBBBBBB";

    private static final String DEFAULT_URGENCY = "AAAAAAAAAA";
    private static final String UPDATED_URGENCY = "BBBBBBBBBB";

    private static final String DEFAULT_GLPI_TICKETS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_GLPI_TICKETS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_GLPI_TICKETS_CONTENT = "AAAAAAAAAA";
    private static final String UPDATED_GLPI_TICKETS_CONTENT = "BBBBBBBBBB";

    private static final String DEFAULT_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_NOTES = "BBBBBBBBBB";

    private static final Instant DEFAULT_ACTUAL_SYS_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ACTUAL_SYS_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_CALLER = "AAAAAAAAAA";
    private static final String UPDATED_CALLER = "BBBBBBBBBB";

    private static final String DEFAULT_CALLER_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_CALLER_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_CALLER_PHONE = "AAAAAAAAAA";
    private static final String UPDATED_CALLER_PHONE = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE_TRANSACCION = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_TRANSACCION = "BBBBBBBBBB";

    private static final String DEFAULT_ID_GLPI = "AAAAAAAAAA";
    private static final String UPDATED_ID_GLPI = "BBBBBBBBBB";

    private static final String DEFAULT_IDTYPE_REQ_SOL = "AAAAAAAAAA";
    private static final String UPDATED_IDTYPE_REQ_SOL = "BBBBBBBBBB";

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restTicketMockMvc;

    private Ticket ticket;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        TicketIpicytService ticketIpicytService = null;
        final TicketResource ticketResource = new TicketResource(ticketRepository, ticketIpicytService);
        this.restTicketMockMvc = MockMvcBuilders.standaloneSetup(ticketResource)
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
    public static Ticket createEntity(EntityManager em) {
        Ticket ticket = new Ticket()
            .idRemedyGlpi(DEFAULT_ID_REMEDY_GLPI)
            .subTypeTransaction(DEFAULT_SUB_TYPE_TRANSACTION)
            .idReferenciaCliente(DEFAULT_ID_REFERENCIA_CLIENTE)
            .company(DEFAULT_COMPANY)
            .prodCat01(DEFAULT_PROD_CAT_01)
            .prodCat02(DEFAULT_PROD_CAT_02)
            .prodCat03(DEFAULT_PROD_CAT_03)
            .nombreProducto(DEFAULT_NOMBRE_PRODUCTO)
            .catOp01(DEFAULT_CAT_OP_01)
            .catOp02(DEFAULT_CAT_OP_02)
            .catOp03(DEFAULT_CAT_OP_03)
            .glpiTicketsRequesttypesId(DEFAULT_GLPI_TICKETS_REQUESTTYPES_ID)
            .contactType(DEFAULT_CONTACT_TYPE)
            .impact(DEFAULT_IMPACT)
            .urgency(DEFAULT_URGENCY)
            .glpiTicketsName(DEFAULT_GLPI_TICKETS_NAME)
            .glpiTicketsContent(DEFAULT_GLPI_TICKETS_CONTENT)
            .notes(DEFAULT_NOTES)
            .actualSysDate(DEFAULT_ACTUAL_SYS_DATE)
            .caller(DEFAULT_CALLER)
            .callerEmail(DEFAULT_CALLER_EMAIL)
            .callerPhone(DEFAULT_CALLER_PHONE)
            .typeTransaccion(DEFAULT_TYPE_TRANSACCION)
            .idGlpi(DEFAULT_ID_GLPI)
            .idtypeReqSol(DEFAULT_IDTYPE_REQ_SOL);
        return ticket;
    }

    @Before
    public void initTest() {
        ticket = createEntity(em);
    }

    @Test
    @Transactional
    public void createTicket() throws Exception {
        int databaseSizeBeforeCreate = ticketRepository.findAll().size();

        // Create the Ticket
        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isCreated());

        // Validate the Ticket in the database
        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeCreate + 1);
        Ticket testTicket = ticketList.get(ticketList.size() - 1);
        assertThat(testTicket.getIdRemedyGlpi()).isEqualTo(DEFAULT_ID_REMEDY_GLPI);
        assertThat(testTicket.getSubTypeTransaction()).isEqualTo(DEFAULT_SUB_TYPE_TRANSACTION);
        assertThat(testTicket.getIdReferenciaCliente()).isEqualTo(DEFAULT_ID_REFERENCIA_CLIENTE);
        assertThat(testTicket.getCompany()).isEqualTo(DEFAULT_COMPANY);
        assertThat(testTicket.getProdCat01()).isEqualTo(DEFAULT_PROD_CAT_01);
        assertThat(testTicket.getProdCat02()).isEqualTo(DEFAULT_PROD_CAT_02);
        assertThat(testTicket.getProdCat03()).isEqualTo(DEFAULT_PROD_CAT_03);
        assertThat(testTicket.getNombreProducto()).isEqualTo(DEFAULT_NOMBRE_PRODUCTO);
        assertThat(testTicket.getCatOp01()).isEqualTo(DEFAULT_CAT_OP_01);
        assertThat(testTicket.getCatOp02()).isEqualTo(DEFAULT_CAT_OP_02);
        assertThat(testTicket.getCatOp03()).isEqualTo(DEFAULT_CAT_OP_03);
        assertThat(testTicket.getGlpiTicketsRequesttypesId()).isEqualTo(DEFAULT_GLPI_TICKETS_REQUESTTYPES_ID);
        assertThat(testTicket.getContactType()).isEqualTo(DEFAULT_CONTACT_TYPE);
        assertThat(testTicket.getImpact()).isEqualTo(DEFAULT_IMPACT);
        assertThat(testTicket.getUrgency()).isEqualTo(DEFAULT_URGENCY);
        assertThat(testTicket.getGlpiTicketsName()).isEqualTo(DEFAULT_GLPI_TICKETS_NAME);
        assertThat(testTicket.getGlpiTicketsContent()).isEqualTo(DEFAULT_GLPI_TICKETS_CONTENT);
        assertThat(testTicket.getNotes()).isEqualTo(DEFAULT_NOTES);
        assertThat(testTicket.getActualSysDate()).isEqualTo(DEFAULT_ACTUAL_SYS_DATE);
        assertThat(testTicket.getCaller()).isEqualTo(DEFAULT_CALLER);
        assertThat(testTicket.getCallerEmail()).isEqualTo(DEFAULT_CALLER_EMAIL);
        assertThat(testTicket.getCallerPhone()).isEqualTo(DEFAULT_CALLER_PHONE);
        assertThat(testTicket.getTypeTransaccion()).isEqualTo(DEFAULT_TYPE_TRANSACCION);
        assertThat(testTicket.getIdGlpi()).isEqualTo(DEFAULT_ID_GLPI);
        assertThat(testTicket.getIdtypeReqSol()).isEqualTo(DEFAULT_IDTYPE_REQ_SOL);
    }

    @Test
    @Transactional
    public void createTicketWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = ticketRepository.findAll().size();

        // Create the Ticket with an existing ID
        ticket.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        // Validate the Ticket in the database
        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkIdRemedyGlpiIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setIdRemedyGlpi(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkSubTypeTransactionIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setSubTypeTransaction(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIdReferenciaClienteIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setIdReferenciaCliente(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCompanyIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setCompany(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkProdCat01IsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setProdCat01(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkProdCat02IsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setProdCat02(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkProdCat03IsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setProdCat03(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCatOp01IsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setCatOp01(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCatOp02IsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setCatOp02(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCatOp03IsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setCatOp03(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkGlpiTicketsRequesttypesIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setGlpiTicketsRequesttypesId(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkContactTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setContactType(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkImpactIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setImpact(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUrgencyIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setUrgency(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkGlpiTicketsNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setGlpiTicketsName(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkActualSysDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setActualSysDate(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCallerIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setCaller(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCallerEmailIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setCallerEmail(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCallerPhoneIsRequired() throws Exception {
        int databaseSizeBeforeTest = ticketRepository.findAll().size();
        // set the field null
        ticket.setCallerPhone(null);

        // Create the Ticket, which fails.

        restTicketMockMvc.perform(post("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isBadRequest());

        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllTickets() throws Exception {
        // Initialize the database
        ticketRepository.saveAndFlush(ticket);

        // Get all the ticketList
        restTicketMockMvc.perform(get("/api/tickets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ticket.getId().intValue())))
            .andExpect(jsonPath("$.[*].idRemedyGlpi").value(hasItem(DEFAULT_ID_REMEDY_GLPI.toString())))
            .andExpect(jsonPath("$.[*].subTypeTransaction").value(hasItem(DEFAULT_SUB_TYPE_TRANSACTION.toString())))
            .andExpect(jsonPath("$.[*].idReferenciaCliente").value(hasItem(DEFAULT_ID_REFERENCIA_CLIENTE.toString())))
            .andExpect(jsonPath("$.[*].company").value(hasItem(DEFAULT_COMPANY.toString())))
            .andExpect(jsonPath("$.[*].prodCat01").value(hasItem(DEFAULT_PROD_CAT_01.toString())))
            .andExpect(jsonPath("$.[*].prodCat02").value(hasItem(DEFAULT_PROD_CAT_02.toString())))
            .andExpect(jsonPath("$.[*].prodCat03").value(hasItem(DEFAULT_PROD_CAT_03.toString())))
            .andExpect(jsonPath("$.[*].nombreProducto").value(hasItem(DEFAULT_NOMBRE_PRODUCTO.toString())))
            .andExpect(jsonPath("$.[*].catOp01").value(hasItem(DEFAULT_CAT_OP_01.toString())))
            .andExpect(jsonPath("$.[*].catOp02").value(hasItem(DEFAULT_CAT_OP_02.toString())))
            .andExpect(jsonPath("$.[*].catOp03").value(hasItem(DEFAULT_CAT_OP_03.toString())))
            .andExpect(jsonPath("$.[*].glpiTicketsRequesttypesId").value(hasItem(DEFAULT_GLPI_TICKETS_REQUESTTYPES_ID.toString())))
            .andExpect(jsonPath("$.[*].contactType").value(hasItem(DEFAULT_CONTACT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].impact").value(hasItem(DEFAULT_IMPACT.toString())))
            .andExpect(jsonPath("$.[*].urgency").value(hasItem(DEFAULT_URGENCY.toString())))
            .andExpect(jsonPath("$.[*].glpiTicketsName").value(hasItem(DEFAULT_GLPI_TICKETS_NAME.toString())))
            .andExpect(jsonPath("$.[*].glpiTicketsContent").value(hasItem(DEFAULT_GLPI_TICKETS_CONTENT.toString())))
            .andExpect(jsonPath("$.[*].notes").value(hasItem(DEFAULT_NOTES.toString())))
            .andExpect(jsonPath("$.[*].actualSysDate").value(hasItem(DEFAULT_ACTUAL_SYS_DATE.toString())))
            .andExpect(jsonPath("$.[*].caller").value(hasItem(DEFAULT_CALLER.toString())))
            .andExpect(jsonPath("$.[*].callerEmail").value(hasItem(DEFAULT_CALLER_EMAIL.toString())))
            .andExpect(jsonPath("$.[*].callerPhone").value(hasItem(DEFAULT_CALLER_PHONE.toString())))
            .andExpect(jsonPath("$.[*].typeTransaccion").value(hasItem(DEFAULT_TYPE_TRANSACCION.toString())))
            .andExpect(jsonPath("$.[*].idGlpi").value(hasItem(DEFAULT_ID_GLPI.toString())))
            .andExpect(jsonPath("$.[*].idtypeReqSol").value(hasItem(DEFAULT_IDTYPE_REQ_SOL.toString())));
    }

    @Test
    @Transactional
    public void getTicket() throws Exception {
        // Initialize the database
        ticketRepository.saveAndFlush(ticket);

        // Get the ticket
        restTicketMockMvc.perform(get("/api/tickets/{id}", ticket.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(ticket.getId().intValue()))
            .andExpect(jsonPath("$.idRemedyGlpi").value(DEFAULT_ID_REMEDY_GLPI.toString()))
            .andExpect(jsonPath("$.subTypeTransaction").value(DEFAULT_SUB_TYPE_TRANSACTION.toString()))
            .andExpect(jsonPath("$.idReferenciaCliente").value(DEFAULT_ID_REFERENCIA_CLIENTE.toString()))
            .andExpect(jsonPath("$.company").value(DEFAULT_COMPANY.toString()))
            .andExpect(jsonPath("$.prodCat01").value(DEFAULT_PROD_CAT_01.toString()))
            .andExpect(jsonPath("$.prodCat02").value(DEFAULT_PROD_CAT_02.toString()))
            .andExpect(jsonPath("$.prodCat03").value(DEFAULT_PROD_CAT_03.toString()))
            .andExpect(jsonPath("$.nombreProducto").value(DEFAULT_NOMBRE_PRODUCTO.toString()))
            .andExpect(jsonPath("$.catOp01").value(DEFAULT_CAT_OP_01.toString()))
            .andExpect(jsonPath("$.catOp02").value(DEFAULT_CAT_OP_02.toString()))
            .andExpect(jsonPath("$.catOp03").value(DEFAULT_CAT_OP_03.toString()))
            .andExpect(jsonPath("$.glpiTicketsRequesttypesId").value(DEFAULT_GLPI_TICKETS_REQUESTTYPES_ID.toString()))
            .andExpect(jsonPath("$.contactType").value(DEFAULT_CONTACT_TYPE.toString()))
            .andExpect(jsonPath("$.impact").value(DEFAULT_IMPACT.toString()))
            .andExpect(jsonPath("$.urgency").value(DEFAULT_URGENCY.toString()))
            .andExpect(jsonPath("$.glpiTicketsName").value(DEFAULT_GLPI_TICKETS_NAME.toString()))
            .andExpect(jsonPath("$.glpiTicketsContent").value(DEFAULT_GLPI_TICKETS_CONTENT.toString()))
            .andExpect(jsonPath("$.notes").value(DEFAULT_NOTES.toString()))
            .andExpect(jsonPath("$.actualSysDate").value(DEFAULT_ACTUAL_SYS_DATE.toString()))
            .andExpect(jsonPath("$.caller").value(DEFAULT_CALLER.toString()))
            .andExpect(jsonPath("$.callerEmail").value(DEFAULT_CALLER_EMAIL.toString()))
            .andExpect(jsonPath("$.callerPhone").value(DEFAULT_CALLER_PHONE.toString()))
            .andExpect(jsonPath("$.typeTransaccion").value(DEFAULT_TYPE_TRANSACCION.toString()))
            .andExpect(jsonPath("$.idGlpi").value(DEFAULT_ID_GLPI.toString()))
            .andExpect(jsonPath("$.idtypeReqSol").value(DEFAULT_IDTYPE_REQ_SOL.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingTicket() throws Exception {
        // Get the ticket
        restTicketMockMvc.perform(get("/api/tickets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTicket() throws Exception {
        // Initialize the database
        ticketRepository.saveAndFlush(ticket);
        int databaseSizeBeforeUpdate = ticketRepository.findAll().size();

        // Update the ticket
        Ticket updatedTicket = ticketRepository.findOne(ticket.getId());
        // Disconnect from session so that the updates on updatedTicket are not directly saved in db
        em.detach(updatedTicket);
        updatedTicket
            .idRemedyGlpi(UPDATED_ID_REMEDY_GLPI)
            .subTypeTransaction(UPDATED_SUB_TYPE_TRANSACTION)
            .idReferenciaCliente(UPDATED_ID_REFERENCIA_CLIENTE)
            .company(UPDATED_COMPANY)
            .prodCat01(UPDATED_PROD_CAT_01)
            .prodCat02(UPDATED_PROD_CAT_02)
            .prodCat03(UPDATED_PROD_CAT_03)
            .nombreProducto(UPDATED_NOMBRE_PRODUCTO)
            .catOp01(UPDATED_CAT_OP_01)
            .catOp02(UPDATED_CAT_OP_02)
            .catOp03(UPDATED_CAT_OP_03)
            .glpiTicketsRequesttypesId(UPDATED_GLPI_TICKETS_REQUESTTYPES_ID)
            .contactType(UPDATED_CONTACT_TYPE)
            .impact(UPDATED_IMPACT)
            .urgency(UPDATED_URGENCY)
            .glpiTicketsName(UPDATED_GLPI_TICKETS_NAME)
            .glpiTicketsContent(UPDATED_GLPI_TICKETS_CONTENT)
            .notes(UPDATED_NOTES)
            .actualSysDate(UPDATED_ACTUAL_SYS_DATE)
            .caller(UPDATED_CALLER)
            .callerEmail(UPDATED_CALLER_EMAIL)
            .callerPhone(UPDATED_CALLER_PHONE)
            .typeTransaccion(UPDATED_TYPE_TRANSACCION)
            .idGlpi(UPDATED_ID_GLPI)
            .idtypeReqSol(UPDATED_IDTYPE_REQ_SOL);

        restTicketMockMvc.perform(put("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedTicket)))
            .andExpect(status().isOk());

        // Validate the Ticket in the database
        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeUpdate);
        Ticket testTicket = ticketList.get(ticketList.size() - 1);
        assertThat(testTicket.getIdRemedyGlpi()).isEqualTo(UPDATED_ID_REMEDY_GLPI);
        assertThat(testTicket.getSubTypeTransaction()).isEqualTo(UPDATED_SUB_TYPE_TRANSACTION);
        assertThat(testTicket.getIdReferenciaCliente()).isEqualTo(UPDATED_ID_REFERENCIA_CLIENTE);
        assertThat(testTicket.getCompany()).isEqualTo(UPDATED_COMPANY);
        assertThat(testTicket.getProdCat01()).isEqualTo(UPDATED_PROD_CAT_01);
        assertThat(testTicket.getProdCat02()).isEqualTo(UPDATED_PROD_CAT_02);
        assertThat(testTicket.getProdCat03()).isEqualTo(UPDATED_PROD_CAT_03);
        assertThat(testTicket.getNombreProducto()).isEqualTo(UPDATED_NOMBRE_PRODUCTO);
        assertThat(testTicket.getCatOp01()).isEqualTo(UPDATED_CAT_OP_01);
        assertThat(testTicket.getCatOp02()).isEqualTo(UPDATED_CAT_OP_02);
        assertThat(testTicket.getCatOp03()).isEqualTo(UPDATED_CAT_OP_03);
        assertThat(testTicket.getGlpiTicketsRequesttypesId()).isEqualTo(UPDATED_GLPI_TICKETS_REQUESTTYPES_ID);
        assertThat(testTicket.getContactType()).isEqualTo(UPDATED_CONTACT_TYPE);
        assertThat(testTicket.getImpact()).isEqualTo(UPDATED_IMPACT);
        assertThat(testTicket.getUrgency()).isEqualTo(UPDATED_URGENCY);
        assertThat(testTicket.getGlpiTicketsName()).isEqualTo(UPDATED_GLPI_TICKETS_NAME);
        assertThat(testTicket.getGlpiTicketsContent()).isEqualTo(UPDATED_GLPI_TICKETS_CONTENT);
        assertThat(testTicket.getNotes()).isEqualTo(UPDATED_NOTES);
        assertThat(testTicket.getActualSysDate()).isEqualTo(UPDATED_ACTUAL_SYS_DATE);
        assertThat(testTicket.getCaller()).isEqualTo(UPDATED_CALLER);
        assertThat(testTicket.getCallerEmail()).isEqualTo(UPDATED_CALLER_EMAIL);
        assertThat(testTicket.getCallerPhone()).isEqualTo(UPDATED_CALLER_PHONE);
        assertThat(testTicket.getTypeTransaccion()).isEqualTo(UPDATED_TYPE_TRANSACCION);
        assertThat(testTicket.getIdGlpi()).isEqualTo(UPDATED_ID_GLPI);
        assertThat(testTicket.getIdtypeReqSol()).isEqualTo(UPDATED_IDTYPE_REQ_SOL);
    }

    @Test
    @Transactional
    public void updateNonExistingTicket() throws Exception {
        int databaseSizeBeforeUpdate = ticketRepository.findAll().size();

        // Create the Ticket

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restTicketMockMvc.perform(put("/api/tickets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ticket)))
            .andExpect(status().isCreated());

        // Validate the Ticket in the database
        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteTicket() throws Exception {
        // Initialize the database
        ticketRepository.saveAndFlush(ticket);
        int databaseSizeBeforeDelete = ticketRepository.findAll().size();

        // Get the ticket
        restTicketMockMvc.perform(delete("/api/tickets/{id}", ticket.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Ticket> ticketList = ticketRepository.findAll();
        assertThat(ticketList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Ticket.class);
        Ticket ticket1 = new Ticket();
        ticket1.setId(1L);
        Ticket ticket2 = new Ticket();
        ticket2.setId(ticket1.getId());
        assertThat(ticket1).isEqualTo(ticket2);
        ticket2.setId(2L);
        assertThat(ticket1).isNotEqualTo(ticket2);
        ticket1.setId(null);
        assertThat(ticket1).isNotEqualTo(ticket2);
    }
}
