//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.12.08 a las 06:44:28 AM CST 
//


package https._10_100_10_1.wsdl._public.glpi.ws_i_solicitud_tk_imms_ipicyt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="id_remedy_glpi" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
 *         &lt;element name="glpi_tickets.requesttypes_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contact_type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Impact" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="urgency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="actual_sys_date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="caller" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="calle_email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="caller_phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "glpiTicketsRequesttypesId",
    "contactType",
    "impact",
    "urgency",
    "notes",
    "actualSysDate",
    "caller",
    "calleEmail",
    "callerPhone"
})
@XmlRootElement(name = "GetTicketRequest")
public class GetTicketRequest {

    @XmlElement(name = "id_remedy_glpi")
    protected int idRemedyGlpi;
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
    @XmlElement(name = "glpi_tickets.requesttypes_id", required = true)
    protected String glpiTicketsRequesttypesId;
    @XmlElement(name = "contact_type", required = true)
    protected String contactType;
    @XmlElement(name = "Impact", required = true)
    protected String impact;
    @XmlElement(required = true)
    protected String urgency;
    @XmlElement(required = true)
    protected String notes;
    @XmlElement(name = "actual_sys_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar actualSysDate;
    @XmlElement(required = true)
    protected String caller;
    @XmlElement(name = "calle_email", required = true)
    protected String calleEmail;
    @XmlElement(name = "caller_phone", required = true)
    protected String callerPhone;

    /**
     * Obtiene el valor de la propiedad idRemedyGlpi.
     * 
     */
    public int getIdRemedyGlpi() {
        return idRemedyGlpi;
    }

    /**
     * Define el valor de la propiedad idRemedyGlpi.
     * 
     */
    public void setIdRemedyGlpi(int value) {
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
     * Obtiene el valor de la propiedad actualSysDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActualSysDate() {
        return actualSysDate;
    }

    /**
     * Define el valor de la propiedad actualSysDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActualSysDate(XMLGregorianCalendar value) {
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

}
