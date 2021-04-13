package mx.edu.ipicyt.imss.changes;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Work_Info_View_AccessType.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Work_Info_View_AccessType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Internal"/&gt;
 *     &lt;enumeration value="Public"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "Work_Info_View_AccessType")
@XmlEnum
public enum WorkInfoViewAccessType {

    @XmlEnumValue("Internal")
    INTERNAL("Internal"),
    @XmlEnumValue("Public")
    PUBLIC("Public");
    private final String value;

    WorkInfoViewAccessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkInfoViewAccessType fromValue(String v) {
        for (WorkInfoViewAccessType c: WorkInfoViewAccessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
