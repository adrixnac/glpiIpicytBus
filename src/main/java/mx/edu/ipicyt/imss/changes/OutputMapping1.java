package mx.edu.ipicyt.imss.changes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para OutputMapping1 complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="OutputMapping1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Resultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Estado" type="{urn:PCT_Actualiza_WS}EstadoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputMapping1", propOrder = {
    "resultado",
    "estado"
})
public class OutputMapping1 {

    @XmlElement(name = "Resultado")
    protected String resultado;
    @XmlElementRef(name = "Estado", namespace = "urn:PCT_Actualiza_WS", type = JAXBElement.class, required = false)
    protected JAXBElement<EstadoType> estado;

    /**
     * Obtiene el valor de la propiedad resultado.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     *
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EstadoType }{@code >}
     *
     */
    public JAXBElement<EstadoType> getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EstadoType }{@code >}
     *
     */
    public void setEstado(JAXBElement<EstadoType> value) {
        this.estado = value;
    }

}
