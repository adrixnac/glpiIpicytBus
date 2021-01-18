package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Priority.
 */
@Entity
@Table(name = "priority")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Priority implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "priority_remedy", nullable = false)
    private String priorityRemedy;

    @NotNull
    @Column(name = "priority_glpi", nullable = false)
    private String priorityGlpi;

    @NotNull
    @Column(name = "priority_glpi_id", nullable = false)
    private Integer priorityGlpiId;

    @ManyToOne
    private Urgency urgency;

    @ManyToOne
    private Impact impact;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPriorityRemedy() {
        return priorityRemedy;
    }

    public Priority priorityRemedy(String priorityRemedy) {
        this.priorityRemedy = priorityRemedy;
        return this;
    }

    public void setPriorityRemedy(String priorityRemedy) {
        this.priorityRemedy = priorityRemedy;
    }

    public String getPriorityGlpi() {
        return priorityGlpi;
    }

    public Priority priorityGlpi(String priorityGlpi) {
        this.priorityGlpi = priorityGlpi;
        return this;
    }

    public void setPriorityGlpi(String priorityGlpi) {
        this.priorityGlpi = priorityGlpi;
    }

    public Integer getPriorityGlpiId() {
        return priorityGlpiId;
    }

    public Priority priorityGlpiId(Integer priorityGlpiId) {
        this.priorityGlpiId = priorityGlpiId;
        return this;
    }

    public void setPriorityGlpiId(Integer priorityGlpiId) {
        this.priorityGlpiId = priorityGlpiId;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public Priority urgency(Urgency urgency) {
        this.urgency = urgency;
        return this;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public Impact getImpact() {
        return impact;
    }

    public Priority impact(Impact impact) {
        this.impact = impact;
        return this;
    }

    public void setImpact(Impact impact) {
        this.impact = impact;
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
        Priority priority = (Priority) o;
        if (priority.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), priority.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Priority{" +
            "id=" + getId() +
            ", priorityRemedy='" + getPriorityRemedy() + "'" +
            ", priorityGlpi='" + getPriorityGlpi() + "'" +
            ", priorityGlpiId=" + getPriorityGlpiId() +
            "}";
    }
}
