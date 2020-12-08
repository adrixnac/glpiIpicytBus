package mx.edu.ipicyt.imssipicytsd.domain;

public class Session {
    String session_token;

    public String getSession_token() {
        return session_token;
    }

    public void setSession_token(String session_token) {
        this.session_token = session_token;
    }

    public Session() { }


    @Override
    public String toString() {
        return "Session{" +
            "session_token='" + session_token + '\'' +
            '}';
    }
}
