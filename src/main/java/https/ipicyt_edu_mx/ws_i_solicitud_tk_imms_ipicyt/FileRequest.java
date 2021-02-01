//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.01.31 a las 05:45:32 PM CST 
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
 *         &lt;element name="WorklogSummary" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WorkInfoNotes" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "worklogSummary",
    "workInfoNotes",
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
@XmlRootElement(name = "FileRequest")
public class FileRequest {

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
    @XmlElement(name = "WorklogSummary", required = true)
    protected String worklogSummary;
    @XmlElement(name = "WorkInfoNotes", required = true)
    protected String workInfoNotes;
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
     * Obtiene el valor de la propiedad worklogSummary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorklogSummary() {
        return worklogSummary;
    }

    /**
     * Define el valor de la propiedad worklogSummary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorklogSummary(String value) {
        this.worklogSummary = value;
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
