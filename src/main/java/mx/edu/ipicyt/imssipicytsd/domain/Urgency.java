package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Urgency.
 */
@Entity
@Table(name = "urgency")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Urgency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "urgency_remedy", nullable = false)
    private String urgencyRemedy;

    @NotNull
    @Column(name = "urgency_glpi", nullable = false)
    private String urgencyGlpi;

    @NotNull
    @Column(name = "urgency_glpi_id", nullable = false)
    private Integer urgencyGlpiId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrgencyRemedy() {
        return urgencyRemedy;
    }

    public Urgency urgencyRemedy(String urgencyRemedy) {
        this.urgencyRemedy = urgencyRemedy;
        return this;
    }

    public void setUrgencyRemedy(String urgencyRemedy) {
        this.urgencyRemedy = urgencyRemedy;
    }

    public String getUrgencyGlpi() {
        return urgencyGlpi;
    }

    public Urgency urgencyGlpi(String urgencyGlpi) {
        this.urgencyGlpi = urgencyGlpi;
        return this;
    }

    public void setUrgencyGlpi(String urgencyGlpi) {
        this.urgencyGlpi = urgencyGlpi;
    }

    public Integer getUrgencyGlpiId() {
        return urgencyGlpiId;
    }

    public Urgency urgencyGlpiId(Integer urgencyGlpiId) {
        this.urgencyGlpiId = urgencyGlpiId;
        return this;
    }

    public void setUrgencyGlpiId(Integer urgencyGlpiId) {
        this.urgencyGlpiId = urgencyGlpiId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Urgency urgency = (Urgency) o;
        if (urgency.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), urgency.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Urgency{" +
            "id=" + getId() +
            ", urgencyRemedy='" + getUrgencyRemedy() + "'" +
            ", urgencyGlpi='" + getUrgencyGlpi() + "'" +
            ", urgencyGlpiId=" + getUrgencyGlpiId() +
            "}";
    }
}
