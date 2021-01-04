package mx.edu.ipicyt.imssipicytsd.service.util;

import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.*;
import mx.edu.ipicyt.imssipicytsd.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
@Service
public class BussinessRules {

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
                          RequestTypeRepository requestTypeRepository) {
        this.subtypeTransactionRepository = subtypeTransactionRepository;
        this.impactRepository = impactRepository;
        this.urgencyRepository = urgencyRepository;
        this.productCatRepository = productCatRepository;
        this.requestTypeRepository = requestTypeRepository;
    }

    public String JsonGLPI (Ticket ticket){
        String jsonString ="{ " +
                "\"input\": { " +
                    "\"name\" : \"" + this.procesaTitulo(ticket.getIdRemedyGlpi() , ticket.getIdReferenciaCliente(),  ticket.getGlpiTicketsName()) + "\"," +
                    "\"date\" : \"" + this.procesaDate(ticket.getActualSysDate()) + "\"," +
                    "\"content\" : \"" + this.procesaContent(ticket.getGlpiTicketsContent()) + "\"," +
                    "\"status\" : " + this.procesaStatus(ticket.getSubTypeTransaction()) + "," +
                    "\"urgency\" : " + this.procesaUrgency(ticket.getUrgency()) + "," +
                    "\"impact\" : " + this.procesaImpact(ticket.getImpact()) + "," +
                    "\"itilcategories_id\" : " + this.procesaCat(ticket.getCatOp03()) + "," +
                    "\"requesttypes_id\" :" + this.procesaRequestTypesId(ticket.getGlpiTicketsRequesttypesId()) + "," +
                    "\"type\" :" + this.procesaRequestTypesId(ticket.getGlpiTicketsRequesttypesId()) + "," +
                    "\"global_validation\":" + "2," +
                    "\"locations_id\":"+  "2";
        jsonString += "}}";

        return jsonString;
    }

    private Integer procesaRequestTypesId(String glpiTicketsRequesttypesIdString) {
        Integer glpiTicketsRequesttypesId = null;
        RequestType requestType  = requestTypeRepository.findFirstByRequestTypeRemedyEquals(glpiTicketsRequesttypesIdString);
        if( requestType != null){
            glpiTicketsRequesttypesId = requestType.getRequestTypeGlpiId();
        }else{
            glpiTicketsRequesttypesId = 0;
        }
        return glpiTicketsRequesttypesId;

    }

    private Integer procesaCat(String catOpString) {
        Integer  catOp = null;
        ProductCat productCat = productCatRepository.findFirstByProductCatRemedyEquals(catOpString);
        if(productCat != null) {
            catOp = Integer.valueOf(productCat.getProductCatGlpiId());
        } else {
            catOp = 0;
        }
        return catOp;

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
        log.debug("URGENCY {}", urgencyObj.toString());
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
        return actualSysDate.atZone(ZoneOffset.UTC).getYear()+"-"+actualSysDate.atZone(ZoneOffset.UTC).getMonthValue()+"-"+actualSysDate.atZone(ZoneOffset.UTC).getDayOfMonth()+ " "+actualSysDate.atZone(ZoneOffset.UTC).getHour()+":"+actualSysDate.atZone(ZoneOffset.UTC).getMinute()+":"+actualSysDate.atZone(ZoneOffset.UTC).getSecond();
    }

    private String procesaTitulo(String idRemedyGlpi,  String idReferenciaCliente, String glpiTicketsName) {
        return idReferenciaCliente + " - " + idRemedyGlpi + ", " + glpiTicketsName;
    }


}
