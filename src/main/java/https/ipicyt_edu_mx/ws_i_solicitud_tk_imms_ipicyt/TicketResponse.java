//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.01.02 a las 11:13:27 AM CST 
//


package https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="type_transaccion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Id_referencia_cliente" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="glpi_tickets.id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status_transaccion.id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="result_message" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "TicketResponse")
public class TicketResponse {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "type_transaccion")
    protected String typeTransaccion;
    @XmlAttribute(name = "Id_referencia_cliente")
    protected String idReferenciaCliente;
    @XmlAttribute(name = "glpi_tickets.id")
    protected String glpiTicketsId;
    @XmlAttribute(name = "status_transaccion.id")
    protected String statusTransaccionId;
    @XmlAttribute(name = "result_message")
    protected String resultMessage;

    /**
     * Obtiene el valor de la propiedad value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define el valor de la propiedad value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
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
     * Obtiene el valor de la propiedad glpiTicketsId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlpiTicketsId() {
        return glpiTicketsId;
    }

    /**
     * Define el valor de la propiedad glpiTicketsId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlpiTicketsId(String value) {
        this.glpiTicketsId = value;
    }

    /**
     * Obtiene el valor de la propiedad statusTransaccionId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusTransaccionId() {
        return statusTransaccionId;
    }

    /**
     * Define el valor de la propiedad statusTransaccionId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusTransaccionId(String value) {
        this.statusTransaccionId = value;
    }

    /**
     * Obtiene el valor de la propiedad resultMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * Define el valor de la propiedad resultMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultMessage(String value) {
        this.resultMessage = value;
    }

}
