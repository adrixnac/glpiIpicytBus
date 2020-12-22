package mx.edu.ipicyt.imssipicytsd.service.util;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapeoValores {

    Map<String, String> subTypeTransaction = Stream.of(new String[][]{
        {"llave", "valor"},
        {"llave-1", "valor-1"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    Map<String, String> glpiTicketsRequesttypesId = Stream.of(new String[][]{
        {"llave", "valor"},
        {"llave-1", "valor-1"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    Map<String, String> contactType = Stream.of(new String[][]{
        {"llave", "valor"},
        {"llave-1", "valor-1"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    Map<String, String> impact = Stream.of(new String[][]{
        {"llave", "valor"},
        {"llave-1", "valor-1"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    Map<String, String> urgency = Stream.of(new String[][]{
        {"llave", "valor"},
        {"llave-1", "valor-1"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    Map<String, String> typeTransaccion = Stream.of(new String[][]{
        {"llave", "valor"},
        {"llave-1", "valor-1"}
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

}
