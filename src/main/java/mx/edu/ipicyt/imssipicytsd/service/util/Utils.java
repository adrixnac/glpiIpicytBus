package mx.edu.ipicyt.imssipicytsd.service.util;

import mx.edu.ipicyt.imssipicytsd.web.rest.ContactTypeResourceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Utils {
    private final Logger log = LoggerFactory.getLogger(Utils.class);

    public Instant convertStringToInstant(String actualSysDate)  {
        SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm:ss");

        log.debug("ACTUAL DATE {}", actualSysDate);
        String horaParse = null;
        try {
            horaParse = date24Format.format(date12Format.parse(actualSysDate.substring(11,13)+":"+actualSysDate.substring(14,16)+":"+actualSysDate.substring(17,19)+" "+actualSysDate.substring(20,24).toUpperCase().replace(".","")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return LocalDateTime.parse(
            actualSysDate.substring(6,10)+"-"+actualSysDate.substring(3,5)+"-"+actualSysDate.substring(0,2)+" "+horaParse, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("America/Mexico_City")).toInstant();

    }

}
