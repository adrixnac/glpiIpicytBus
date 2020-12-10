package mx.edu.ipicyt.imssipicytsd.domain;

public class GlpiResponse {
    String id;
    String message;
    String type_transaccion;
    String Id_referencia_cliente;
    String glpi_tickets_id;
    String status_transaccion;
    String result_message;
    public GlpiResponse() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType_transaccion() {
        return type_transaccion;
    }

    public void setType_transaccion(String type_transaccion) {
        this.type_transaccion = type_transaccion;
    }

    public String getId_referencia_cliente() {
        return Id_referencia_cliente;
    }

    public void setId_referencia_cliente(String id_referencia_cliente) {
        Id_referencia_cliente = id_referencia_cliente;
    }

    public String getGlpi_tickets_id() {
        return glpi_tickets_id;
    }

    public void setGlpi_tickets_id(String glpi_tickets_id) {
        this.glpi_tickets_id = glpi_tickets_id;
    }

    public String getStatus_transaccion() {
        return status_transaccion;
    }

    public void setStatus_transaccion(String status_transaccion) {
        this.status_transaccion = status_transaccion;
    }

    public String getResult_message() {
        return result_message;
    }

    public void setResult_message(String result_message) {
        this.result_message = result_message;
    }

    @Override
    public String toString() {
        return "GlpiResponse{" +
            "id='" + id + '\'' +
            ", message='" + message + '\'' +
            ", type_transaccion='" + type_transaccion + '\'' +
            ", Id_referencia_cliente='" + Id_referencia_cliente + '\'' +
            ", glpi_tickets_id='" + glpi_tickets_id + '\'' +
            ", status_transaccion='" + status_transaccion + '\'' +
            ", result_message='" + result_message + '\'' +
            '}';
    }
}
