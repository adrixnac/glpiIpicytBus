package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Impact.
 */
@Entity
@Table(name = "impact")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Impact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "impact_remedy", nullable = false)
    private String impactRemedy;

    @NotNull
    @Column(name = "impact_glpi", nullable = false)
    private String impactGlpi;

    @NotNull
    @Column(name = "impact_glpi_id", nullable = false)
    private String impactGlpiId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImpactRemedy() {
        return impactRemedy;
    }

    public Impact impactRemedy(String impactRemedy) {
        this.impactRemedy = impactRemedy;
        return this;
    }

    public void setImpactRemedy(String impactRemedy) {
        this.impactRemedy = impactRemedy;
    }

    public String getImpactGlpi() {
        return impactGlpi;
    }

    public Impact impactGlpi(String impactGlpi) {
        this.impactGlpi = impactGlpi;
        return this;
    }

    public void setImpactGlpi(String impactGlpi) {
        this.impactGlpi = impactGlpi;
    }

    public String getImpactGlpiId() {
        return impactGlpiId;
    }

    public Impact impactGlpiId(String impactGlpiId) {
        this.impactGlpiId = impactGlpiId;
        return this;
    }

    public void setImpactGlpiId(String impactGlpiId) {
        this.impactGlpiId = impactGlpiId;
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
        Impact impact = (Impact) o;
        if (impact.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), impact.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Impact{" +
            "id=" + getId() +
            ", impactRemedy='" + getImpactRemedy() + "'" +
            ", impactGlpi='" + getImpactGlpi() + "'" +
            ", impactGlpiId='" + getImpactGlpiId() + "'" +
            "}";
    }
}
