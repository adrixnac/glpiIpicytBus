package mx.edu.ipicyt.imssipicytsd.soap;

public class Ticket {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ticket(){
        super();
    }

    @Override
    public String toString() {
        return "Ticket{" +
            "id=" + id +
            '}';
    }
}
