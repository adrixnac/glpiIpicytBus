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
 *         &lt;element name="TicketDetails" type="{https://10.100.10.1/WSDL/public/glpi/ws_a_solicitud_tk_imms_ipicyt}TicketDetails"/>
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
    "ticketDetails"
})
@XmlRootElement(name = "GetTicketResponse")
public class GetTicketResponse {

    @XmlElement(name = "TicketDetails", required = true)
    protected TicketDetails ticketDetails;

    /**
     * Obtiene el valor de la propiedad ticketDetails.
     * 
     * @return
     *     possible object is
     *     {@link TicketDetails }
     *     
     */
    public TicketDetails getTicketDetails() {
        return ticketDetails;
    }

    /**
     * Define el valor de la propiedad ticketDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link TicketDetails }
     *     
     */
    public void setTicketDetails(TicketDetails value) {
        this.ticketDetails = value;
    }

}
