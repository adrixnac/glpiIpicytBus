package mx.edu.ipicyt.imss.changes;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Work_Info_TypeType.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Work_Info_TypeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="----- Customer Inbound -----"/&gt;
 *     &lt;enumeration value="Customer Communication"/&gt;
 *     &lt;enumeration value="Customer Follow-up"/&gt;
 *     &lt;enumeration value="Customer Status Update"/&gt;
 *     &lt;enumeration value="----- Customer Outbound -----"/&gt;
 *     &lt;enumeration value="Closure Follow Up"/&gt;
 *     &lt;enumeration value="Detail Clarification"/&gt;
 *     &lt;enumeration value="General Information"/&gt;
 *     &lt;enumeration value="Resolution Communications"/&gt;
 *     &lt;enumeration value="Satisfaction Survey"/&gt;
 *     &lt;enumeration value="Status Update"/&gt;
 *     &lt;enumeration value="----- General -----"/&gt;
 *     &lt;enumeration value="Incident Task / Action"/&gt;
 *     &lt;enumeration value="Problem Script"/&gt;
 *     &lt;enumeration value="Working Log"/&gt;
 *     &lt;enumeration value="Email System"/&gt;
 *     &lt;enumeration value="Paging System"/&gt;
 *     &lt;enumeration value="BMC Impact Manager Update"/&gt;
 *     &lt;enumeration value="Chat"/&gt;
 *     &lt;enumeration value="----- Vendor -----"/&gt;
 *     &lt;enumeration value="Vendor Communication"/&gt;
 *     &lt;enumeration value="-----System-----"/&gt;
 *     &lt;enumeration value="Assignment Change"/&gt;
 *     &lt;enumeration value="Priority Change"/&gt;
 *     &lt;enumeration value="Status Change"/&gt;
 *     &lt;enumeration value="Vendor Ticket Status Update"/&gt;
 *     &lt;enumeration value="Note from Vendor"/&gt;
 *     &lt;enumeration value="Vendor Ticket Created via Business Rules"/&gt;
 *     &lt;enumeration value="Ticket Created from Vendor"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "Work_Info_TypeType")
@XmlEnum
public enum WorkInfoTypeType {

    @XmlEnumValue("----- Customer Inbound -----")
    CUSTOMER_INBOUND("----- Customer Inbound -----"),
    @XmlEnumValue("Customer Communication")
    CUSTOMER_COMMUNICATION("Customer Communication"),
    @XmlEnumValue("Customer Follow-up")
    CUSTOMER_FOLLOW_UP("Customer Follow-up"),
    @XmlEnumValue("Customer Status Update")
    CUSTOMER_STATUS_UPDATE("Customer Status Update"),
    @XmlEnumValue("----- Customer Outbound -----")
    CUSTOMER_OUTBOUND("----- Customer Outbound -----"),
    @XmlEnumValue("Closure Follow Up")
    CLOSURE_FOLLOW_UP("Closure Follow Up"),
    @XmlEnumValue("Detail Clarification")
    DETAIL_CLARIFICATION("Detail Clarification"),
    @XmlEnumValue("General Information")
    GENERAL_INFORMATION("General Information"),
    @XmlEnumValue("Resolution Communications")
    RESOLUTION_COMMUNICATIONS("Resolution Communications"),
    @XmlEnumValue("Satisfaction Survey")
    SATISFACTION_SURVEY("Satisfaction Survey"),
    @XmlEnumValue("Status Update")
    STATUS_UPDATE("Status Update"),
    @XmlEnumValue("----- General -----")
    GENERAL("----- General -----"),
    @XmlEnumValue("Incident Task / Action")
    INCIDENT_TASK_ACTION("Incident Task / Action"),
    @XmlEnumValue("Problem Script")
    PROBLEM_SCRIPT("Problem Script"),
    @XmlEnumValue("Working Log")
    WORKING_LOG("Working Log"),
    @XmlEnumValue("Email System")
    EMAIL_SYSTEM("Email System"),
    @XmlEnumValue("Paging System")
    PAGING_SYSTEM("Paging System"),
    @XmlEnumValue("BMC Impact Manager Update")
    BMC_IMPACT_MANAGER_UPDATE("BMC Impact Manager Update"),
    @XmlEnumValue("Chat")
    CHAT("Chat"),
    @XmlEnumValue("----- Vendor -----")
    VENDOR("----- Vendor -----"),
    @XmlEnumValue("Vendor Communication")
    VENDOR_COMMUNICATION("Vendor Communication"),
    @XmlEnumValue("-----System-----")
    SYSTEM("-----System-----"),
    @XmlEnumValue("Assignment Change")
    ASSIGNMENT_CHANGE("Assignment Change"),
    @XmlEnumValue("Priority Change")
    PRIORITY_CHANGE("Priority Change"),
    @XmlEnumValue("Status Change")
    STATUS_CHANGE("Status Change"),
    @XmlEnumValue("Vendor Ticket Status Update")
    VENDOR_TICKET_STATUS_UPDATE("Vendor Ticket Status Update"),
    @XmlEnumValue("Note from Vendor")
    NOTE_FROM_VENDOR("Note from Vendor"),
    @XmlEnumValue("Vendor Ticket Created via Business Rules")
    VENDOR_TICKET_CREATED_VIA_BUSINESS_RULES("Vendor Ticket Created via Business Rules"),
    @XmlEnumValue("Ticket Created from Vendor")
    TICKET_CREATED_FROM_VENDOR("Ticket Created from Vendor");
    private final String value;

    WorkInfoTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkInfoTypeType fromValue(String v) {
        for (WorkInfoTypeType c: WorkInfoTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
