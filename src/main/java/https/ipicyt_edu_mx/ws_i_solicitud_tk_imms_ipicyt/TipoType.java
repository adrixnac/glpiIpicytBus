//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.03.23 a las 11:57:49 AM CST 
//


package https.ipicyt_edu_mx.ws_i_solicitud_tk_imms_ipicyt;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Incidente"/>
 *     &lt;enumeration value="WorkOrder"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoType")
@XmlEnum
public enum TipoType {

    @XmlEnumValue("Incidente")
    INCIDENTE("Incidente"),
    @XmlEnumValue("WorkOrder")
    WORK_ORDER("WorkOrder");
    private final String value;

    TipoType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoType fromValue(String v) {
        for (TipoType c: TipoType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
