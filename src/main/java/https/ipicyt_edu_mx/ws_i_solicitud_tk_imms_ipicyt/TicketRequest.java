//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.01.20 a las 12:54:41 AM CST 
//


package https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_remedy_glpi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type_transaccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sub_type_transaction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Id_referencia_cliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Company" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProdCat01" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProdCat02" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProdCat03" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombre_producto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CatOp01" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CatOp02" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CatOp03" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="glpi_tickets.requesttypes_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contact_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Impact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="urgency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="glpi_tickets.name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="glpi_tickets.content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="actual_sys_date" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[01][0-9]/[0-3][0-9]//[0-9]{4} [0-2][0-9]:[0-5][0-9]:[0-6][0-9]-0600"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="caller" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="calle_email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="caller_phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id_glpi" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ticket_IPICYT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Attachment.FileName1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Attachment.FileType1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Attachment.FileData1" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="Attachment.FileName2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Attachment.FileType2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Attachment.FileData2" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="Attachment.FileName3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Attachment.FileType3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Attachment.FileData3" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idRemedyGlpi",
    "typeTransaccion",
    "subTypeTransaction",
    "idReferenciaCliente",
    "company",
    "prodCat01",
    "prodCat02",
    "prodCat03",
    "nombreProducto",
    "catOp01",
    "catOp02",
    "catOp03",
    "glpiTicketsRequesttypesId",
    "contactType",
    "impact",
    "urgency",
    "glpiTicketsName",
    "glpiTicketsContent",
    "notes",
    "priority",
    "actualSysDate",
    "caller",
    "calleEmail",
    "callerPhone",
    "idGlpi",
    "ticketIPICYT",
    "attachmentFileName1",
    "attachmentFileType1",
    "attachmentFileData1",
    "attachmentFileName2",
    "attachmentFileType2",
    "attachmentFileData2",
    "attachmentFileName3",
    "attachmentFileType3",
    "attachmentFileData3"
})
@XmlRootElement(name = "TicketRequest")
public class TicketRequest {

    @XmlElement(name = "id_remedy_glpi", required = true)
    protected String idRemedyGlpi;
    @XmlElement(name = "type_transaccion", required = true)
    protected String typeTransaccion;
    @XmlElement(name = "sub_type_transaction", required = true)
    protected String subTypeTransaction;
    @XmlElement(name = "Id_referencia_cliente", required = true)
    protected String idReferenciaCliente;
    @XmlElement(name = "Company", required = true)
    protected String company;
    @XmlElement(name = "ProdCat01", required = true)
    protected String prodCat01;
    @XmlElement(name = "ProdCat02", required = true)
    protected String prodCat02;
    @XmlElement(name = "ProdCat03", required = true)
    protected String prodCat03;
    @XmlElement(name = "nombre_producto", required = true)
    protected String nombreProducto;
    @XmlElement(name = "CatOp01", required = true)
    protected String catOp01;
    @XmlElement(name = "CatOp02", required = true)
    protected String catOp02;
    @XmlElement(name = "CatOp03", required = true)
    protected String catOp03;
    @XmlElement(name = "glpi_tickets.requesttypes_id", required = true)
    protected String glpiTicketsRequesttypesId;
    @XmlElement(name = "contact_type", required = true)
    protected String contactType;
    @XmlElement(name = "Impact")
    protected String impact;
    protected String urgency;
    @XmlElement(name = "glpi_tickets.name", required = true)
    protected String glpiTicketsName;
    @XmlElement(name = "glpi_tickets.content", required = true)
    protected String glpiTicketsContent;
    @XmlElement(required = true)
    protected String notes;
    @XmlElement(required = true)
    protected String priority;
    @XmlElement(name = "actual_sys_date")
    protected String actualSysDate;
    @XmlElement(required = true)
    protected String caller;
    @XmlElement(name = "calle_email", required = true)
    protected String calleEmail;
    @XmlElement(name = "caller_phone", required = true)
    protected String callerPhone;
    @XmlElement(name = "id_glpi", required = true)
    protected String idGlpi;
    @XmlElement(name = "Ticket_IPICYT", required = true)
    protected String ticketIPICYT;
    @XmlElement(name = "Attachment.FileName1", required = true)
    protected String attachmentFileName1;
    @XmlElement(name = "Attachment.FileType1", required = true)
    protected String attachmentFileType1;
    @XmlElement(name = "Attachment.FileData1", required = true)
    protected byte[] attachmentFileData1;
    @XmlElement(name = "Attachment.FileName2", required = true)
    protected String attachmentFileName2;
    @XmlElement(name = "Attachment.FileType2", required = true)
    protected String attachmentFileType2;
    @XmlElement(name = "Attachment.FileData2", required = true)
    protected byte[] attachmentFileData2;
    @XmlElement(name = "Attachment.FileName3", required = true)
    protected String attachmentFileName3;
    @XmlElement(name = "Attachment.FileType3", required = true)
    protected String attachmentFileType3;
    @XmlElement(name = "Attachment.FileData3", required = true)
    protected byte[] attachmentFileData3;

    /**
     * Obtiene el valor de la propiedad idRemedyGlpi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRemedyGlpi() {
        return idRemedyGlpi;
    }

    /**
     * Define el valor de la propiedad idRemedyGlpi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRemedyGlpi(String value) {
        this.idRemedyGlpi = value;
    }

    /**
     * Obtiene el valor de la propiedad typeTransaccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeTransaccion() {
        return typeTransaccion;
    }

    /**
     * Define el valor de la propiedad typeTransaccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeTransaccion(String value) {
        this.typeTransaccion = value;
    }

    /**
     * Obtiene el valor de la propiedad subTypeTransaction.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTypeTransaction() {
        return subTypeTransaction;
    }

    /**
     * Define el valor de la propiedad subTypeTransaction.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTypeTransaction(String value) {
        this.subTypeTransaction = value;
    }

    /**
     * Obtiene el valor de la propiedad idReferenciaCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdReferenciaCliente() {
        return idReferenciaCliente;
    }

    /**
     * Define el valor de la propiedad idReferenciaCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdReferenciaCliente(String value) {
        this.idReferenciaCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad company.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Define el valor de la propiedad company.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Obtiene el valor de la propiedad prodCat01.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdCat01() {
        return prodCat01;
    }

    /**
     * Define el valor de la propiedad prodCat01.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdCat01(String value) {
        this.prodCat01 = value;
    }

    /**
     * Obtiene el valor de la propiedad prodCat02.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdCat02() {
        return prodCat02;
    }

    /**
     * Define el valor de la propiedad prodCat02.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdCat02(String value) {
        this.prodCat02 = value;
    }

    /**
     * Obtiene el valor de la propiedad prodCat03.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdCat03() {
        return prodCat03;
    }

    /**
     * Define el valor de la propiedad prodCat03.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdCat03(String value) {
        this.prodCat03 = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreProducto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Define el valor de la propiedad nombreProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreProducto(String value) {
        this.nombreProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad catOp01.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatOp01() {
        return catOp01;
    }

    /**
     * Define el valor de la propiedad catOp01.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatOp01(String value) {
        this.catOp01 = value;
    }

    /**
     * Obtiene el valor de la propiedad catOp02.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatOp02() {
        return catOp02;
    }

    /**
     * Define el valor de la propiedad catOp02.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatOp02(String value) {
        this.catOp02 = value;
    }

    /**
     * Obtiene el valor de la propiedad catOp03.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatOp03() {
        return catOp03;
    }

    /**
     * Define el valor de la propiedad catOp03.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatOp03(String value) {
        this.catOp03 = value;
    }

    /**
     * Obtiene el valor de la propiedad glpiTicketsRequesttypesId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlpiTicketsRequesttypesId() {
        return glpiTicketsRequesttypesId;
    }

    /**
     * Define el valor de la propiedad glpiTicketsRequesttypesId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlpiTicketsRequesttypesId(String value) {
        this.glpiTicketsRequesttypesId = value;
    }

    /**
     * Obtiene el valor de la propiedad contactType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactType() {
        return contactType;
    }

    /**
     * Define el valor de la propiedad contactType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactType(String value) {
        this.contactType = value;
    }

    /**
     * Obtiene el valor de la propiedad impact.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpact() {
        return impact;
    }

    /**
     * Define el valor de la propiedad impact.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpact(String value) {
        this.impact = value;
    }

    /**
     * Obtiene el valor de la propiedad urgency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrgency() {
        return urgency;
    }

    /**
     * Define el valor de la propiedad urgency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrgency(String value) {
        this.urgency = value;
    }

    /**
     * Obtiene el valor de la propiedad glpiTicketsName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlpiTicketsName() {
        return glpiTicketsName;
    }

    /**
     * Define el valor de la propiedad glpiTicketsName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlpiTicketsName(String value) {
        this.glpiTicketsName = value;
    }

    /**
     * Obtiene el valor de la propiedad glpiTicketsContent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlpiTicketsContent() {
        return glpiTicketsContent;
    }

    /**
     * Define el valor de la propiedad glpiTicketsContent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlpiTicketsContent(String value) {
        this.glpiTicketsContent = value;
    }

    /**
     * Obtiene el valor de la propiedad notes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Define el valor de la propiedad notes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Obtiene el valor de la propiedad priority.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Define el valor de la propiedad priority.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

    /**
     * Obtiene el valor de la propiedad actualSysDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualSysDate() {
        return actualSysDate;
    }

    /**
     * Define el valor de la propiedad actualSysDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualSysDate(String value) {
        this.actualSysDate = value;
    }

    /**
     * Obtiene el valor de la propiedad caller.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaller() {
        return caller;
    }

    /**
     * Define el valor de la propiedad caller.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaller(String value) {
        this.caller = value;
    }

    /**
     * Obtiene el valor de la propiedad calleEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalleEmail() {
        return calleEmail;
    }

    /**
     * Define el valor de la propiedad calleEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalleEmail(String value) {
        this.calleEmail = value;
    }

    /**
     * Obtiene el valor de la propiedad callerPhone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallerPhone() {
        return callerPhone;
    }

    /**
     * Define el valor de la propiedad callerPhone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallerPhone(String value) {
        this.callerPhone = value;
    }

    /**
     * Obtiene el valor de la propiedad idGlpi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdGlpi() {
        return idGlpi;
    }

    /**
     * Define el valor de la propiedad idGlpi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdGlpi(String value) {
        this.idGlpi = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketIPICYT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketIPICYT() {
        return ticketIPICYT;
    }

    /**
     * Define el valor de la propiedad ticketIPICYT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketIPICYT(String value) {
        this.ticketIPICYT = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileName1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentFileName1() {
        return attachmentFileName1;
    }

    /**
     * Define el valor de la propiedad attachmentFileName1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentFileName1(String value) {
        this.attachmentFileName1 = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileType1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentFileType1() {
        return attachmentFileType1;
    }

    /**
     * Define el valor de la propiedad attachmentFileType1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentFileType1(String value) {
        this.attachmentFileType1 = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileData1.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAttachmentFileData1() {
        return attachmentFileData1;
    }

    /**
     * Define el valor de la propiedad attachmentFileData1.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAttachmentFileData1(byte[] value) {
        this.attachmentFileData1 = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileName2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentFileName2() {
        return attachmentFileName2;
    }

    /**
     * Define el valor de la propiedad attachmentFileName2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentFileName2(String value) {
        this.attachmentFileName2 = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileType2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentFileType2() {
        return attachmentFileType2;
    }

    /**
     * Define el valor de la propiedad attachmentFileType2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentFileType2(String value) {
        this.attachmentFileType2 = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileData2.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAttachmentFileData2() {
        return attachmentFileData2;
    }

    /**
     * Define el valor de la propiedad attachmentFileData2.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAttachmentFileData2(byte[] value) {
        this.attachmentFileData2 = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileName3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentFileName3() {
        return attachmentFileName3;
    }

    /**
     * Define el valor de la propiedad attachmentFileName3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentFileName3(String value) {
        this.attachmentFileName3 = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileType3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentFileType3() {
        return attachmentFileType3;
    }

    /**
     * Define el valor de la propiedad attachmentFileType3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentFileType3(String value) {
        this.attachmentFileType3 = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentFileData3.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAttachmentFileData3() {
        return attachmentFileData3;
    }

    /**
     * Define el valor de la propiedad attachmentFileData3.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAttachmentFileData3(byte[] value) {
        this.attachmentFileData3 = value;
    }

}
