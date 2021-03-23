//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.03.23 a las 11:57:49 AM CST 
//


package https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CREATEResponse_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "CREATEResponse");
    private final static QName _AuthenticationInfo_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "AuthenticationInfo");
    private final static QName _CREATE_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "CREATE");
    private final static QName _InputMapping1Urgencia_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Urgencia");
    private final static QName _InputMapping1Impacto_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Impacto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FileResponse }
     * 
     */
    public FileResponse createFileResponse() {
        return new FileResponse();
    }

    /**
     * Create an instance of {@link FileRequest }
     * 
     */
    public FileRequest createFileRequest() {
        return new FileRequest();
    }

    /**
     * Create an instance of {@link TicketResponse }
     * 
     */
    public TicketResponse createTicketResponse() {
        return new TicketResponse();
    }

    /**
     * Create an instance of {@link TicketRequest }
     * 
     */
    public TicketRequest createTicketRequest() {
        return new TicketRequest();
    }

    /**
     * Create an instance of {@link OutputMapping1 }
     * 
     */
    public OutputMapping1 createOutputMapping1() {
        return new OutputMapping1();
    }

    /**
     * Create an instance of {@link InputMapping1 }
     * 
     */
    public InputMapping1 createInputMapping1() {
        return new InputMapping1();
    }

    /**
     * Create an instance of {@link AuthenticationInfo }
     * 
     */
    public AuthenticationInfo createAuthenticationInfo() {
        return new AuthenticationInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "CREATEResponse")
    public JAXBElement<Object> createCREATEResponse(Object value) {
        return new JAXBElement<Object>(_CREATEResponse_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "AuthenticationInfo")
    public JAXBElement<Object> createAuthenticationInfo(Object value) {
        return new JAXBElement<Object>(_AuthenticationInfo_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "CREATE")
    public JAXBElement<Object> createCREATE(Object value) {
        return new JAXBElement<Object>(_CREATE_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Urgencia", scope = InputMapping1 .class)
    public JAXBElement<Object> createInputMapping1Urgencia(Object value) {
        return new JAXBElement<Object>(_InputMapping1Urgencia_QNAME, Object.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Impacto", scope = InputMapping1 .class)
    public JAXBElement<Object> createInputMapping1Impacto(Object value) {
        return new JAXBElement<Object>(_InputMapping1Impacto_QNAME, Object.class, InputMapping1 .class, value);
    }

}
