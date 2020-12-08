//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.12.08 a las 06:44:28 AM CST 
//


package https._10_100_10_1.wsdl._public.glpi.ws_a_solicitud_tk_imms_ipicyt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TicketDetails complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TicketDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type_transaccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Id_referencia_cliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="glpi_tickets.id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="status_transaccion.id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="result_message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketDetails", propOrder = {
    "typeTransaccion",
    "idReferenciaCliente",
    "glpiTicketsId",
    "statusTransaccionId",
    "resultMessage"
})
public class TicketDetails {

    @XmlElement(name = "type_transaccion", required = true)
    protected String typeTransaccion;
    @XmlElement(name = "Id_referencia_cliente", required = true)
    protected String idReferenciaCliente;
    @XmlElement(name = "glpi_tickets.id")
    protected int glpiTicketsId;
    @XmlElement(name = "status_transaccion.id", required = true)
    protected String statusTransaccionId;
    @XmlElement(name = "result_message", required = true)
    protected String resultMessage;

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
     */
    public int getGlpiTicketsId() {
        return glpiTicketsId;
    }

    /**
     * Define el valor de la propiedad glpiTicketsId.
     * 
     */
    public void setGlpiTicketsId(int value) {
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
