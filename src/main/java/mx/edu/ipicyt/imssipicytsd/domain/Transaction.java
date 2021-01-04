package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Transaction.
 */
@Entity
@Table(name = "transaction")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "transaction_remedy", nullable = false)
    private String transactionRemedy;

    @NotNull
    @Column(name = "transaction_glpi", nullable = false)
    private String transactionGlpi;

    @NotNull
    @Column(name = "transaction_glpi_id", nullable = false)
    private Integer transactionGlpiId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionRemedy() {
        return transactionRemedy;
    }

    public Transaction transactionRemedy(String transactionRemedy) {
        this.transactionRemedy = transactionRemedy;
        return this;
    }

    public void setTransactionRemedy(String transactionRemedy) {
        this.transactionRemedy = transactionRemedy;
    }

    public String getTransactionGlpi() {
        return transactionGlpi;
    }

    public Transaction transactionGlpi(String transactionGlpi) {
        this.transactionGlpi = transactionGlpi;
        return this;
    }

    public void setTransactionGlpi(String transactionGlpi) {
        this.transactionGlpi = transactionGlpi;
    }

    public Integer getTransactionGlpiId() {
        return transactionGlpiId;
    }

    public Transaction transactionGlpiId(Integer transactionGlpiId) {
        this.transactionGlpiId = transactionGlpiId;
        return this;
    }

    public void setTransactionGlpiId(Integer transactionGlpiId) {
        this.transactionGlpiId = transactionGlpiId;
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
        Transaction transaction = (Transaction) o;
        if (transaction.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), transaction.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Transaction{" +
            "id=" + getId() +
            ", transactionRemedy='" + getTransactionRemedy() + "'" +
            ", transactionGlpi='" + getTransactionGlpi() + "'" +
            ", transactionGlpiId=" + getTransactionGlpiId() +
            "}";
    }
}
