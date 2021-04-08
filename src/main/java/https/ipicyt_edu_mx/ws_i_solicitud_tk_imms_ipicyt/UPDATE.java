//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci\u00f3n de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder\u00e1n si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.04.08 a las 08:02:41 AM CDT 
//


package https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="Impact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Urgency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ticket_Proveedor__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ticket_Number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Resolution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Resolution_Category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Resolution_Category_Tier_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Resolution_Category_Tier_3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closure_Product_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closure_Product_Category_Tier1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closure_Product_Category_Tier2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closure_Product_Category_Tier3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Work_Info_Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Work_Info_View_Access" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Work_Info_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attachment1_attachmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attachment1_attachmentData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Attachment1_attachmentOrigSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Attachment2_attachmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attachment2_attachmentData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Attachment2_attachmentOrigSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Attachment3_attachmentName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attachment3_attachmentData" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="Attachment3_attachmentOrigSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "impact",
    "urgency",
    "action",
    "status",
    "ticketProveedorC",
    "type",
    "ticketNumber",
    "resolution",
    "resolutionCategory",
    "resolutionCategoryTier2",
    "resolutionCategoryTier3",
    "closureProductName",
    "closureProductCategoryTier1",
    "closureProductCategoryTier2",
    "closureProductCategoryTier3",
    "workInfoNotes",
    "workInfoViewAccess",
    "workInfoType",
    "attachment1AttachmentName",
    "attachment1AttachmentData",
    "attachment1AttachmentOrigSize",
    "attachment2AttachmentName",
    "attachment2AttachmentData",
    "attachment2AttachmentOrigSize",
    "attachment3AttachmentName",
    "attachment3AttachmentData",
    "attachment3AttachmentOrigSize"
})
@XmlRootElement(name = "UPDATE")
public class UPDATE {

    @XmlElementRef(name = "Impact", namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", type = JAXBElement.class, required = false)
    protected JAXBElement<String> impact;
    @XmlElementRef(name = "Urgency", namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", type = JAXBElement.class, required = false)
    protected JAXBElement<String> urgency;
    @XmlElement(name = "Action")
    protected String action;
    @XmlElementRef(name = "Status", namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;
    @XmlElement(name = "Ticket_Proveedor__c")
    protected String ticketProveedorC;
    @XmlElementRef(name = "Type", namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", type = JAXBElement.class, required = false)
    protected JAXBElement<String> type;
    @XmlElement(name = "Ticket_Number", required = true, nillable = true)
    protected String ticketNumber;
    @XmlElement(name = "Resolution")
    protected String resolution;
    @XmlElement(name = "Resolution_Category")
    protected String resolutionCategory;
    @XmlElement(name = "Resolution_Category_Tier_2")
    protected String resolutionCategoryTier2;
    @XmlElement(name = "Resolution_Category_Tier_3")
    protected String resolutionCategoryTier3;
    @XmlElement(name = "Closure_Product_Name")
    protected String closureProductName;
    @XmlElement(name = "Closure_Product_Category_Tier1")
    protected String closureProductCategoryTier1;
    @XmlElement(name = "Closure_Product_Category_Tier2")
    protected String closureProductCategoryTier2;
    @XmlElement(name = "Closure_Product_Category_Tier3")
    protected String closureProductCategoryTier3;
    @XmlElement(name = "Work_Info_Notes")
    protected String workInfoNotes;
    @XmlElementRef(name = "Work_Info_View_Access", namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workInfoViewAccess;
    @XmlElementRef(name = "Work_Info_Type", namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workInfoType;
    @XmlElement(name = "Attachment1_attachmentName")
    protected String attachment1AttachmentName;
    @XmlElement(name = "Attachment1_attachmentData")
    protected byte[] attachment1AttachmentData;
    @XmlElement(name = "Attachment1_attachmentOrigSize")
    protected Integer attachment1AttachmentOrigSize;
    @XmlElement(name = "Attachment2_attachmentName")
    protected String attachment2AttachmentName;
    @XmlElement(name = "Attachment2_attachmentData")
    protected byte[] attachment2AttachmentData;
    @XmlElement(name = "Attachment2_attachmentOrigSize")
    protected Integer attachment2AttachmentOrigSize;
    @XmlElement(name = "Attachment3_attachmentName")
    protected String attachment3AttachmentName;
    @XmlElement(name = "Attachment3_attachmentData")
    protected byte[] attachment3AttachmentData;
    @XmlElement(name = "Attachment3_attachmentOrigSize")
    protected Integer attachment3AttachmentOrigSize;

    /**
     * Obtiene el valor de la propiedad impact.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getImpact() {
        return impact;
    }

    /**
     * Define el valor de la propiedad impact.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setImpact(JAXBElement<String> value) {
        this.impact = value;
    }

    /**
     * Obtiene el valor de la propiedad urgency.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUrgency() {
        return urgency;
    }

    /**
     * Define el valor de la propiedad urgency.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUrgency(JAXBElement<String> value) {
        this.urgency = value;
    }

    /**
     * Obtiene el valor de la propiedad action.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Define el valor de la propiedad action.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketProveedorC.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketProveedorC() {
        return ticketProveedorC;
    }

    /**
     * Define el valor de la propiedad ticketProveedorC.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketProveedorC(String value) {
        this.ticketProveedorC = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setType(JAXBElement<String> value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Define el valor de la propiedad ticketNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNumber(String value) {
        this.ticketNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad resolution.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * Define el valor de la propiedad resolution.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolution(String value) {
        this.resolution = value;
    }

    /**
     * Obtiene el valor de la propiedad resolutionCategory.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolutionCategory() {
        return resolutionCategory;
    }

    /**
     * Define el valor de la propiedad resolutionCategory.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolutionCategory(String value) {
        this.resolutionCategory = value;
    }

    /**
     * Obtiene el valor de la propiedad resolutionCategoryTier2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolutionCategoryTier2() {
        return resolutionCategoryTier2;
    }

    /**
     * Define el valor de la propiedad resolutionCategoryTier2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolutionCategoryTier2(String value) {
        this.resolutionCategoryTier2 = value;
    }

    /**
     * Obtiene el valor de la propiedad resolutionCategoryTier3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResolutionCategoryTier3() {
        return resolutionCategoryTier3;
    }

    /**
     * Define el valor de la propiedad resolutionCategoryTier3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResolutionCategoryTier3(String value) {
        this.resolutionCategoryTier3 = value;
    }

    /**
     * Obtiene el valor de la propiedad closureProductName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClosureProductName() {
        return closureProductName;
    }

    /**
     * Define el valor de la propiedad closureProductName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClosureProductName(String value) {
        this.closureProductName = value;
    }

    /**
     * Obtiene el valor de la propiedad closureProductCategoryTier1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClosureProductCategoryTier1() {
        return closureProductCategoryTier1;
    }

    /**
     * Define el valor de la propiedad closureProductCategoryTier1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClosureProductCategoryTier1(String value) {
        this.closureProductCategoryTier1 = value;
    }

    /**
     * Obtiene el valor de la propiedad closureProductCategoryTier2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClosureProductCategoryTier2() {
        return closureProductCategoryTier2;
    }

    /**
     * Define el valor de la propiedad closureProductCategoryTier2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClosureProductCategoryTier2(String value) {
        this.closureProductCategoryTier2 = value;
    }

    /**
     * Obtiene el valor de la propiedad closureProductCategoryTier3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClosureProductCategoryTier3() {
        return closureProductCategoryTier3;
    }

    /**
     * Define el valor de la propiedad closureProductCategoryTier3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClosureProductCategoryTier3(String value) {
        this.closureProductCategoryTier3 = value;
    }

    /**
     * Obtiene el valor de la propiedad workInfoNotes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkInfoNotes() {
        return workInfoNotes;
    }

    /**
     * Define el valor de la propiedad workInfoNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkInfoNotes(String value) {
        this.workInfoNotes = value;
    }

    /**
     * Obtiene el valor de la propiedad workInfoViewAccess.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkInfoViewAccess() {
        return workInfoViewAccess;
    }

    /**
     * Define el valor de la propiedad workInfoViewAccess.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkInfoViewAccess(JAXBElement<String> value) {
        this.workInfoViewAccess = value;
    }

    /**
     * Obtiene el valor de la propiedad workInfoType.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkInfoType() {
        return workInfoType;
    }

    /**
     * Define el valor de la propiedad workInfoType.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkInfoType(JAXBElement<String> value) {
        this.workInfoType = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment1AttachmentName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachment1AttachmentName() {
        return attachment1AttachmentName;
    }

    /**
     * Define el valor de la propiedad attachment1AttachmentName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachment1AttachmentName(String value) {
        this.attachment1AttachmentName = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment1AttachmentData.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAttachment1AttachmentData() {
        return attachment1AttachmentData;
    }

    /**
     * Define el valor de la propiedad attachment1AttachmentData.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAttachment1AttachmentData(byte[] value) {
        this.attachment1AttachmentData = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment1AttachmentOrigSize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAttachment1AttachmentOrigSize() {
        return attachment1AttachmentOrigSize;
    }

    /**
     * Define el valor de la propiedad attachment1AttachmentOrigSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAttachment1AttachmentOrigSize(Integer value) {
        this.attachment1AttachmentOrigSize = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment2AttachmentName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachment2AttachmentName() {
        return attachment2AttachmentName;
    }

    /**
     * Define el valor de la propiedad attachment2AttachmentName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachment2AttachmentName(String value) {
        this.attachment2AttachmentName = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment2AttachmentData.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAttachment2AttachmentData() {
        return attachment2AttachmentData;
    }

    /**
     * Define el valor de la propiedad attachment2AttachmentData.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAttachment2AttachmentData(byte[] value) {
        this.attachment2AttachmentData = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment2AttachmentOrigSize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAttachment2AttachmentOrigSize() {
        return attachment2AttachmentOrigSize;
    }

    /**
     * Define el valor de la propiedad attachment2AttachmentOrigSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAttachment2AttachmentOrigSize(Integer value) {
        this.attachment2AttachmentOrigSize = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment3AttachmentName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachment3AttachmentName() {
        return attachment3AttachmentName;
    }

    /**
     * Define el valor de la propiedad attachment3AttachmentName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachment3AttachmentName(String value) {
        this.attachment3AttachmentName = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment3AttachmentData.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getAttachment3AttachmentData() {
        return attachment3AttachmentData;
    }

    /**
     * Define el valor de la propiedad attachment3AttachmentData.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setAttachment3AttachmentData(byte[] value) {
        this.attachment3AttachmentData = value;
    }

    /**
     * Obtiene el valor de la propiedad attachment3AttachmentOrigSize.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAttachment3AttachmentOrigSize() {
        return attachment3AttachmentOrigSize;
    }

    /**
     * Define el valor de la propiedad attachment3AttachmentOrigSize.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAttachment3AttachmentOrigSize(Integer value) {
        this.attachment3AttachmentOrigSize = value;
    }

}
