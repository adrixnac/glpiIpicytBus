package mx.edu.ipicyt.imss.changes;


import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the mx.gob.imss.client.changes package.
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

    private final static QName _UPDATE_QNAME = new QName("urn:PCT_Actualiza_WS", "UPDATE");
    private final static QName _UPDATEResponse_QNAME = new QName("urn:PCT_Actualiza_WS", "UPDATEResponse");
    private final static QName _AuthenticationInfo_QNAME = new QName("urn:PCT_Actualiza_WS", "AuthenticationInfo");
    private final static QName _OutputMapping1Estado_QNAME = new QName("urn:PCT_Actualiza_WS", "Estado");
    private final static QName _InputMapping1Impact_QNAME = new QName("urn:PCT_Actualiza_WS", "Impact");
    private final static QName _InputMapping1Urgency_QNAME = new QName("urn:PCT_Actualiza_WS", "Urgency");
    private final static QName _InputMapping1Status_QNAME = new QName("urn:PCT_Actualiza_WS", "Status");
    private final static QName _InputMapping1Type_QNAME = new QName("urn:PCT_Actualiza_WS", "Type");
    private final static QName _InputMapping1WorkInfoViewAccess_QNAME = new QName("urn:PCT_Actualiza_WS", "Work_Info_View_Access");
    private final static QName _InputMapping1WorkInfoType_QNAME = new QName("urn:PCT_Actualiza_WS", "Work_Info_Type");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.gob.imss.client.changes
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InputMapping1 }
     *
     */
    public InputMapping1 createInputMapping1() {
        return new InputMapping1();
    }

    /**
     * Create an instance of {@link OutputMapping1 }
     *
     */
    public OutputMapping1 createOutputMapping1() {
        return new OutputMapping1();
    }

    /**
     * Create an instance of {@link AuthenticationInfo }
     *
     */
    public AuthenticationInfo createAuthenticationInfo() {
        return new AuthenticationInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InputMapping1 }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InputMapping1 }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "UPDATE")
    public JAXBElement<InputMapping1> createUPDATE(InputMapping1 value) {
        return new JAXBElement<InputMapping1>(_UPDATE_QNAME, InputMapping1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputMapping1 }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OutputMapping1 }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "UPDATEResponse")
    public JAXBElement<OutputMapping1> createUPDATEResponse(OutputMapping1 value) {
        return new JAXBElement<OutputMapping1>(_UPDATEResponse_QNAME, OutputMapping1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticationInfo }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AuthenticationInfo }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "AuthenticationInfo")
    public JAXBElement<AuthenticationInfo> createAuthenticationInfo(AuthenticationInfo value) {
        return new JAXBElement<AuthenticationInfo>(_AuthenticationInfo_QNAME, AuthenticationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EstadoType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "Estado", scope = OutputMapping1 .class)
    public JAXBElement<EstadoType> createOutputMapping1Estado(EstadoType value) {
        return new JAXBElement<EstadoType>(_OutputMapping1Estado_QNAME, EstadoType.class, OutputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "Impact", scope = InputMapping1 .class)
    public JAXBElement<String> createInputMapping1Impact(String value) {
        return new JAXBElement<String>(_InputMapping1Impact_QNAME, String.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "Urgency", scope = InputMapping1 .class)
    public JAXBElement<String> createInputMapping1Urgency(String value) {
        return new JAXBElement<String>(_InputMapping1Urgency_QNAME, String.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "Status", scope = InputMapping1 .class)
    public JAXBElement<StatusType> createInputMapping1Status(StatusType value) {
        return new JAXBElement<StatusType>(_InputMapping1Status_QNAME, StatusType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TypeType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TypeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "Type", scope = InputMapping1 .class)
    public JAXBElement<TypeType> createInputMapping1Type(TypeType value) {
        return new JAXBElement<TypeType>(_InputMapping1Type_QNAME, TypeType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkInfoViewAccessType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WorkInfoViewAccessType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "Work_Info_View_Access", scope = InputMapping1 .class)
    public JAXBElement<WorkInfoViewAccessType> createInputMapping1WorkInfoViewAccess(WorkInfoViewAccessType value) {
        return new JAXBElement<WorkInfoViewAccessType>(_InputMapping1WorkInfoViewAccess_QNAME, WorkInfoViewAccessType.class, InputMapping1 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WorkInfoTypeType }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WorkInfoTypeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:PCT_Actualiza_WS", name = "Work_Info_Type", scope = InputMapping1 .class)
    public JAXBElement<WorkInfoTypeType> createInputMapping1WorkInfoType(WorkInfoTypeType value) {
        return new JAXBElement<WorkInfoTypeType>(_InputMapping1WorkInfoType_QNAME, WorkInfoTypeType.class, InputMapping1 .class, value);
    }

}
