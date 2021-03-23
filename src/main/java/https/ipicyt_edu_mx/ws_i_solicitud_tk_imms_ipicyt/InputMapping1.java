//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.03.23 a las 11:57:49 AM CST 
//


package https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InputMapping1 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InputMapping1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Impacto" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Urgencia" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Accion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProdCat01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProdCat02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProdCat03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nombre_producto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CatOp01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CatOp02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CatOp03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Ticket_Proveedor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tipo" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputMapping1", propOrder = {
    "impacto",
    "urgencia",
    "descripcion",
    "accion",
    "notas",
    "prodCat01",
    "prodCat02",
    "prodCat03",
    "nombreProducto",
    "catOp01",
    "catOp02",
    "catOp03",
    "estado",
    "ticketProveedor",
    "tipo"
})
public class InputMapping1 {

    @XmlElementRef(name = "Impacto", namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", type = JAXBElement.class, required = false)
    protected JAXBElement<Object> impacto;
    @XmlElementRef(name = "Urgencia", namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", type = JAXBElement.class, required = false)
    protected JAXBElement<Object> urgencia;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "Accion")
    protected String accion;
    @XmlElement(name = "Notas")
    protected String notas;
    @XmlElement(name = "ProdCat01")
    protected String prodCat01;
    @XmlElement(name = "ProdCat02")
    protected String prodCat02;
    @XmlElement(name = "ProdCat03")
    protected String prodCat03;
    @XmlElement(name = "Nombre_producto")
    protected String nombreProducto;
    @XmlElement(name = "CatOp01")
    protected String catOp01;
    @XmlElement(name = "CatOp02")
    protected String catOp02;
    @XmlElement(name = "CatOp03")
    protected String catOp03;
    @XmlElement(name = "Estado", required = true, nillable = true)
    protected Object estado;
    @XmlElement(name = "Ticket_Proveedor", required = true)
    protected String ticketProveedor;
    @XmlElement(name = "Tipo", required = true, nillable = true)
    protected Object tipo;

    /**
     * Obtiene el valor de la propiedad impacto.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<Object> getImpacto() {
        return impacto;
    }

    /**
     * Define el valor de la propiedad impacto.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setImpacto(JAXBElement<Object> value) {
        this.impacto = value;
    }

    /**
     * Obtiene el valor de la propiedad urgencia.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<Object> getUrgencia() {
        return urgencia;
    }

    /**
     * Define el valor de la propiedad urgencia.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setUrgencia(JAXBElement<Object> value) {
        this.urgencia = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad accion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Define el valor de la propiedad accion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccion(String value) {
        this.accion = value;
    }

    /**
     * Obtiene el valor de la propiedad notas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Define el valor de la propiedad notas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotas(String value) {
        this.notas = value;
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
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEstado(Object value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad ticketProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketProveedor() {
        return ticketProveedor;
    }

    /**
     * Define el valor de la propiedad ticketProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketProveedor(String value) {
        this.ticketProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTipo(Object value) {
        this.tipo = value;
    }

}
