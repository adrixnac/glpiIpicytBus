package mx.edu.ipicyt.imssipicytsd.service.util;

import mx.edu.ipicyt.imssipicytsd.domain.*;
import mx.edu.ipicyt.imssipicytsd.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
@Service
public class BussinessRules {

    private PriorityRepository priorityRepository;
    private SubtypeTransactionRepository subtypeTransactionRepository;
    private ImpactRepository impactRepository;
    private UrgencyRepository urgencyRepository;
    private ProductCatRepository productCatRepository;
    private RequestTypeRepository requestTypeRepository;
    private final Logger log = LoggerFactory.getLogger(BussinessRules.class);


    public BussinessRules(SubtypeTransactionRepository subtypeTransactionRepository,
                          ImpactRepository impactRepository,
                          UrgencyRepository urgencyRepository,
                          ProductCatRepository productCatRepository,
                          RequestTypeRepository requestTypeRepository,
                          PriorityRepository priorityRepository) {
        this.subtypeTransactionRepository = subtypeTransactionRepository;
        this.impactRepository = impactRepository;
        this.urgencyRepository = urgencyRepository;
        this.productCatRepository = productCatRepository;
        this.requestTypeRepository = requestTypeRepository;
        this.priorityRepository = priorityRepository;
    }

    public String JsonGLPI (Ticket ticket){
        Utils utils = new Utils();
        log.debug("-- TICKET tipo de Solicitud --  {}", ticket.getGlpiTicketsRequesttypesId() );
        String jsonString ="{ " +
                "\"input\": { " +
                    "\"name\" : \"" + this.procesaTitulo(ticket.getIdRemedyGlpi() , ticket.getIdReferenciaCliente(),  ticket.getGlpiTicketsName()) + "\"," +
                    "\"date\" : \"" + this.procesaDate(ticket.getActualSysDate()) + "\"," +
                    "\"content\" : \"" + this.procesaContent(ticket.getGlpiTicketsContent()) + "." + utils.unformatText(ticket.getNotes())  + this.procesaCatProd(ticket) +"\"," +
                    "\"status\" : " + this.procesaStatus(ticket.getSubTypeTransaction()) + "," +
                    "\"urgency\" : " + this.procesaUrgency(ticket.getUrgency()) + "," +
                    "\"impact\" : " + this.procesaImpact(ticket.getImpact()) + "," +
                    "\"itilcategories_id\" : " + this.procesaCat(ticket.getProdCat01(), ticket.getProdCat02(), ticket.getProdCat03()) + "," +
                    "\"requesttypes_id\" :" + this.procesaRequestTypesId(ticket.getGlpiTicketsRequesttypesId()) + "," +
                    "\"type\" :" + this.procesaRequestTypesId(ticket.getGlpiTicketsRequesttypesId()) + "," +
                    "\"global_validation\":" + "7," +
                    "\"locations_id\":"+  "2";
        jsonString += "}}";

        return jsonString;
    }


    private Integer procesaRequestTypesId(String glpiTicketsRequesttypesIdString) {
        log.debug("Procesa tipo de solicitud {}", glpiTicketsRequesttypesIdString);
        Integer glpiTicketsRequesttypesId = null;
        RequestType requestType  = requestTypeRepository.findFirstByRequestTypeRemedyEquals(glpiTicketsRequesttypesIdString);
        if( requestType != null){
            glpiTicketsRequesttypesId = requestType.getRequestTypeGlpiId();
        }else{
            glpiTicketsRequesttypesId = 0;
        }

        log.debug("Procesa tipo de solicitud {}", glpiTicketsRequesttypesId);
        return glpiTicketsRequesttypesId;

    }

    private Integer procesaCat(String catOpString1, String catOpString2, String catOpString3) {
        Integer catOp = 1;
        String productCatStructure = "";
        log.debug("Procesa categoria 1 {}", catOpString1);
        log.debug("Procesa categoria 2 {}", catOpString2);
        log.debug("Procesa categoria 3 {}", catOpString3);

        ProductCat productCat1 = productCatRepository.findFirstByProductCatGlpi(catOpString1);
        ProductCat productCat2 = productCatRepository.findFirstByProductCatGlpi(catOpString2);
        ProductCat productCat3 = productCatRepository.findFirstByProductCatGlpi(catOpString3);
        log.debug("productCat1 {}", productCat1);
        log.debug("productCat2 {}", productCat2);
        log.debug("productCat3 {}", productCat3);
        productCatStructure = "{\""+productCat1.getProductCatGlpiId()+"\":"+productCat1.getProductCatGlpiId()+",\""+productCat2.getProductCatGlpiId()+"\":"+productCat2.getProductCatGlpiId()+"}";
        log.debug("Json de Categorías {}", productCatStructure);
        log.debug("productCat3.getProductCatGlpiId() {}", productCat3.getProductCatGlpiId());
        ProductCat productCatResult = productCatRepository.findFirstByProductCatGlpiIdAndProductCatStructureContains(productCat3.getProductCatGlpiId(),productCatStructure);
        log.debug("producto Resultado  {}", productCatResult);

        return productCatResult.getProductCatGlpiId();

    }

    private Integer procesaImpact(String impactString) {
        Integer impact = null;
        Impact impactObj = impactRepository.findFirstByImpactRemedyEquals(impactString);
        if (impactObj != null) {
            impact = Integer.valueOf(impactObj.getImpactGlpiId());
        } else {
            impact =0;
        }

        return impact;
    }

    private Integer procesaUrgency(String urgencyString) {
        Integer urgency = null;
        log.debug("URGENCY {}", urgencyString);
        Urgency urgencyObj = urgencyRepository.findFirstByUrgencyRemedyEquals(urgencyString);

        if(urgencyObj != null){
            urgency = Integer.valueOf(urgencyObj.getUrgencyGlpiId());
        }else{
            urgency = 0;
        }
        return urgency;

    }

    private Integer procesaStatus(String subTypeTransaction) {
        Integer status = null;
        SubtypeTransaction  subtypeTransactionObj = subtypeTransactionRepository.findFirstBySubTypeTransactionRemedyEquals(subTypeTransaction);
        if(subtypeTransactionObj != null){
            status =  subtypeTransactionObj.getSubTypeTransactionId();
        } else {
            return 0;
        }
        return status;
    }

    private String procesaContent(String glpiTicketsContent) {
        return glpiTicketsContent.trim();
    }

    private String procesaDate(Instant actualSysDate) {
        String year = String.format("%04d",actualSysDate.atZone(ZoneOffset.UTC).getYear());
        String month = String.format("%02d",actualSysDate.atZone(ZoneOffset.UTC).getMonthValue());
        String day = String.format("%02d",actualSysDate.atZone(ZoneOffset.UTC).getDayOfMonth());
        log.debug(" --- HORA ---- {}",actualSysDate.atZone(ZoneOffset.UTC).getHour() -6);
        String hour = String.format("%02d", actualSysDate.atZone(ZoneOffset.UTC).getHour()-6);
        String minutes = String.format("%02d",actualSysDate.atZone(ZoneOffset.UTC).getMinute());
        String seconds = String.format("%02d",actualSysDate.atZone(ZoneOffset.UTC).getSecond());
        return year+"-"+month+"-"+day+ " "+hour+":"+minutes+":"+seconds;
    }

    private String procesaTitulo(String idRemedyGlpi,  String idReferenciaCliente, String glpiTicketsName) {
        return idReferenciaCliente + " - " + idRemedyGlpi + ", " + glpiTicketsName;
    }

    private String procesaCatProd(Ticket ticket){
        String cateProd = " ";
        cateProd = "<<" + ticket.getCatOp01() + "> " + ticket.getCatOp02() + " > " + ticket.getCatOp03() + ">>";
        return cateProd;
    }


}
