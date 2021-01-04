package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A SubtypeTransaction.
 */
@Entity
@Table(name = "subtype_transaction")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SubtypeTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "sub_type_transaction_remedy", nullable = false)
    private String subTypeTransactionRemedy;

    @NotNull
    @Column(name = "sub_type_transaction_glpi", nullable = false)
    private String subTypeTransactionGlpi;

    @NotNull
    @Column(name = "sub_type_transaction_id", nullable = false)
    private Integer subTypeTransactionId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubTypeTransactionRemedy() {
        return subTypeTransactionRemedy;
    }

    public SubtypeTransaction subTypeTransactionRemedy(String subTypeTransactionRemedy) {
        this.subTypeTransactionRemedy = subTypeTransactionRemedy;
        return this;
    }

    public void setSubTypeTransactionRemedy(String subTypeTransactionRemedy) {
        this.subTypeTransactionRemedy = subTypeTransactionRemedy;
    }

    public String getSubTypeTransactionGlpi() {
        return subTypeTransactionGlpi;
    }

    public SubtypeTransaction subTypeTransactionGlpi(String subTypeTransactionGlpi) {
        this.subTypeTransactionGlpi = subTypeTransactionGlpi;
        return this;
    }

    public void setSubTypeTransactionGlpi(String subTypeTransactionGlpi) {
        this.subTypeTransactionGlpi = subTypeTransactionGlpi;
    }

    public Integer getSubTypeTransactionId() {
        return subTypeTransactionId;
    }

    public SubtypeTransaction subTypeTransactionId(Integer subTypeTransactionId) {
        this.subTypeTransactionId = subTypeTransactionId;
        return this;
    }

    public void setSubTypeTransactionId(Integer subTypeTransactionId) {
        this.subTypeTransactionId = subTypeTransactionId;
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
        SubtypeTransaction subtypeTransaction = (SubtypeTransaction) o;
        if (subtypeTransaction.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), subtypeTransaction.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SubtypeTransaction{" +
            "id=" + getId() +
            ", subTypeTransactionRemedy='" + getSubTypeTransactionRemedy() + "'" +
            ", subTypeTransactionGlpi='" + getSubTypeTransactionGlpi() + "'" +
            ", subTypeTransactionId=" + getSubTypeTransactionId() +
            "}";
    }
}
