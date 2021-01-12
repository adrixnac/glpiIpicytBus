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
        log.debug("ACTUAL DATE {}", actualSysDate);
        String year = actualSysDate.substring(0,4);
        String month = actualSysDate.substring(5,7);
        String day =  actualSysDate.substring(8,10);
        String hour = actualSysDate.substring(11,13);
        String minute = actualSysDate.substring(14,16);
        String second = actualSysDate.substring(17,19);

        log.debug("Anio {}", year);
        log.debug("Month {}", month);
        log.debug("day  {}", day);
        log.debug("Anio {}", hour);
        log.debug("Month {}", minute);
        log.debug("day  {}", second);

        String horaParse = null;

       return LocalDateTime.parse(
            year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.of("America/Mexico_City")).toInstant();

    }

}
