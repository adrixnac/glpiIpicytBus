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
                    "\"content\" : \"" + this.procesaContent(ticket.getGlpiTicketsContent()) + "." + utils.unformatText(ticket.getNotes())  + "\"," +
                    "\"status\" : " + this.procesaStatus(ticket.getSubTypeTransaction()) + "," +
                    "\"urgency\" : " + this.procesaUrgency(ticket.getUrgency()) + "," +
                    "\"impact\" : " + this.procesaImpact(ticket.getImpact()) + "," +
                    "\"itilcategories_id\" : " + this.procesaCat(ticket.getCatOp03()) + "," +
                    "\"requesttypes_id\" :" + this.procesaRequestTypesId(ticket.getGlpiTicketsRequesttypesId()) + "," +
                    "\"type\" :" + this.procesaRequestTypesId(ticket.getGlpiTicketsRequesttypesId()) + "," +
                    "\"global_validation\":" + "7," +
                    "\"locations_id\":"+  "2";
        jsonString += "}}";

        return jsonString;
    }

    private String procesaPriority(String urgency, String impact) {
        log.debug("---- procesaPriority --- URGENCY {}", urgency);
        log.debug("---- procesaPriority --- IMPACT {}", impact);
        String priority = "4";
        String muyAltaUrgencia = "1";
        String altaUrgencia = "2";
        String mediaUrgencia = "3";
        String bajaUrgencia = "4";
        String muyAltaImpacto = "1";
        String altaImpacto = "1";
        String medioImpacto = "1";
        String bajoImpacto = "1";

        if (urgency.equals(muyAltaUrgencia) && impact.equals(muyAltaImpacto))  return "5";
        if (urgency.equals(muyAltaUrgencia) && impact.equals(altaImpacto)    )  return "5";
        if (urgency.equals(altaUrgencia) && impact.equals(muyAltaImpacto))  return "5";

        if (urgency.equals(muyAltaUrgencia) && impact == medioImpacto   )  return "4";
        if (urgency == muyAltaUrgencia && impact == bajoImpacto    )  return "4";
        if (urgency == altaUrgencia    && impact == altaImpacto    )  return "4";
        if (urgency == mediaUrgencia   && impact == muyAltaImpacto )  return "4";
        if (urgency == altaUrgencia    && impact == medioImpacto   )  return "4";

        if (urgency == altaUrgencia    && impact == bajoImpacto    )  return "3";
        if (urgency == mediaUrgencia   && impact == altaImpacto    )  return "3";
        if (urgency == mediaUrgencia   && impact == medioImpacto   )  return "3";
        if (urgency == mediaUrgencia   && impact == bajoImpacto    )  return "3";

        if (urgency == bajaUrgencia    && impact == muyAltaImpacto )  return "2";
        if (urgency == bajaUrgencia    && impact == altaImpacto    )  return "2";
        if (urgency == bajaUrgencia    && impact == medioImpacto   )  return "2";
        if (urgency == bajaUrgencia    && impact == bajoImpacto    )  return "2";

        return priority;
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


}
