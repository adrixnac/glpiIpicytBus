package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ContactType.
 */
@Entity
@Table(name = "contact_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ContactType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "contact_type_remedy", nullable = false)
    private String contactTypeRemedy;

    @NotNull
    @Column(name = "contact_type_glpi", nullable = false)
    private String contactTypeGlpi;

    @NotNull
    @Column(name = "contact_type_glpi_id", nullable = false)
    private Integer contactTypeGlpiId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactTypeRemedy() {
        return contactTypeRemedy;
    }

    public ContactType contactTypeRemedy(String contactTypeRemedy) {
        this.contactTypeRemedy = contactTypeRemedy;
        return this;
    }

    public void setContactTypeRemedy(String contactTypeRemedy) {
        this.contactTypeRemedy = contactTypeRemedy;
    }

    public String getContactTypeGlpi() {
        return contactTypeGlpi;
    }

    public ContactType contactTypeGlpi(String contactTypeGlpi) {
        this.contactTypeGlpi = contactTypeGlpi;
        return this;
    }

    public void setContactTypeGlpi(String contactTypeGlpi) {
        this.contactTypeGlpi = contactTypeGlpi;
    }

    public Integer getContactTypeGlpiId() {
        return contactTypeGlpiId;
    }

    public ContactType contactTypeGlpiId(Integer contactTypeGlpiId) {
        this.contactTypeGlpiId = contactTypeGlpiId;
        return this;
    }

    public void setContactTypeGlpiId(Integer contactTypeGlpiId) {
        this.contactTypeGlpiId = contactTypeGlpiId;
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
        ContactType contactType = (ContactType) o;
        if (contactType.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), contactType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ContactType{" +
            "id=" + getId() +
            ", contactTypeRemedy='" + getContactTypeRemedy() + "'" +
            ", contactTypeGlpi='" + getContactTypeGlpi() + "'" +
            ", contactTypeGlpiId=" + getContactTypeGlpiId() +
            "}";
    }
}
