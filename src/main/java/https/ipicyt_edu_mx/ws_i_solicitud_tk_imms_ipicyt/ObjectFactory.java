//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci\u00f3n de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder\u00e1n si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.04.08 a las 08:02:41 AM CDT 
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

    private final static QName _UPDATEResponseEstado_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Estado");
    private final static QName _UPDATEUrgency_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Urgency");
    private final static QName _UPDATEType_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Type");
    private final static QName _UPDATEWorkInfoType_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Work_Info_Type");
    private final static QName _UPDATEImpact_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Impact");
    private final static QName _UPDATEStatus_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Status");
    private final static QName _UPDATEWorkInfoViewAccess_QNAME = new QName("https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", "Work_Info_View_Access");

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
     * Create an instance of {@link UPDATEResponse }
     * 
     */
    public UPDATEResponse createUPDATEResponse() {
        return new UPDATEResponse();
    }

    /**
     * Create an instance of {@link UPDATE }
     * 
     */
    public UPDATE createUPDATE() {
        return new UPDATE();
    }

    /**
     * Create an instance of {@link TicketRequest }
     * 
     */
    public TicketRequest createTicketRequest() {
        return new TicketRequest();
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
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Estado", scope = UPDATEResponse.class)
    public JAXBElement<Object> createUPDATEResponseEstado(Object value) {
        return new JAXBElement<Object>(_UPDATEResponseEstado_QNAME, Object.class, UPDATEResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Urgency", scope = UPDATE.class)
    public JAXBElement<String> createUPDATEUrgency(String value) {
        return new JAXBElement<String>(_UPDATEUrgency_QNAME, String.class, UPDATE.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Type", scope = UPDATE.class)
    public JAXBElement<String> createUPDATEType(String value) {
        return new JAXBElement<String>(_UPDATEType_QNAME, String.class, UPDATE.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Work_Info_Type", scope = UPDATE.class)
    public JAXBElement<String> createUPDATEWorkInfoType(String value) {
        return new JAXBElement<String>(_UPDATEWorkInfoType_QNAME, String.class, UPDATE.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Impact", scope = UPDATE.class)
    public JAXBElement<String> createUPDATEImpact(String value) {
        return new JAXBElement<String>(_UPDATEImpact_QNAME, String.class, UPDATE.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Status", scope = UPDATE.class)
    public JAXBElement<String> createUPDATEStatus(String value) {
        return new JAXBElement<String>(_UPDATEStatus_QNAME, String.class, UPDATE.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://ipicyt.edu.mx/ws_i_solicitud_tk_imms_ipicyt", name = "Work_Info_View_Access", scope = UPDATE.class)
    public JAXBElement<String> createUPDATEWorkInfoViewAccess(String value) {
        return new JAXBElement<String>(_UPDATEWorkInfoViewAccess_QNAME, String.class, UPDATE.class, value);
    }

}
