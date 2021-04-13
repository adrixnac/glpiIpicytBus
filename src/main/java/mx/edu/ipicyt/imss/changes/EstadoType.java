package mx.edu.ipicyt.imss.changes;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EstadoType.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EstadoType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Nuevo"/&gt;
 *     &lt;enumeration value="Procesado"/&gt;
 *     &lt;enumeration value="Error"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "EstadoType")
@XmlEnum
public enum EstadoType {

    @XmlEnumValue("Nuevo")
    NUEVO("Nuevo"),
    @XmlEnumValue("Procesado")
    PROCESADO("Procesado"),
    @XmlEnumValue("Error")
    ERROR("Error");
    private final String value;

    EstadoType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoType fromValue(String v) {
        for (EstadoType c: EstadoType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
