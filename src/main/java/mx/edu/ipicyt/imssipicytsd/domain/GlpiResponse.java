package mx.edu.ipicyt.imssipicytsd.domain;

public class GlpiResponse {
    String id;
    String message;

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

    @Override
    public String toString() {
        return "GlpiResponse{" +
            "id='" + id + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
