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
        String year= actualSysDate.substring(6,10) ;
        log.debug("- AÑO-  {}", year);

        String month = actualSysDate.substring(0,2);
        log.debug(" MES {}", month);

        String day = actualSysDate.substring(3,5);
        log.debug(" day {}", day);

        String hour = actualSysDate.substring(11,13);
        log.debug(" hour {}", hour);

        String minute = actualSysDate.substring(14,16);
        log.debug(" minute {}", minute);

        String second = actualSysDate.substring(17,19);
        log.debug(" second {}", second);

        return LocalDateTime.parse(
            actualSysDate.substring(6,10)+"-"+actualSysDate.substring(0,2)+"-"+actualSysDate.substring(3,5)+" "+actualSysDate.substring(11,13)+":"+actualSysDate.substring(14,16)+":"+actualSysDate.substring(17,19), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("America/Mexico_City")).toInstant();

    }

}
