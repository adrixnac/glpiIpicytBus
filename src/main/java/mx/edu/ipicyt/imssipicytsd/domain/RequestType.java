package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RequestType.
 */
@Entity
@Table(name = "request_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RequestType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "request_type_remedy", nullable = false)
    private String requestTypeRemedy;

    @NotNull
    @Column(name = "request_type_glpi", nullable = false)
    private String requestTypeGlpi;

    @NotNull
    @Column(name = "request_type_glpi_id", nullable = false)
    private Integer requestTypeGlpiId;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestTypeRemedy() {
        return requestTypeRemedy;
    }

    public RequestType requestTypeRemedy(String requestTypeRemedy) {
        this.requestTypeRemedy = requestTypeRemedy;
        return this;
    }

    public void setRequestTypeRemedy(String requestTypeRemedy) {
        this.requestTypeRemedy = requestTypeRemedy;
    }

    public String getRequestTypeGlpi() {
        return requestTypeGlpi;
    }

    public RequestType requestTypeGlpi(String requestTypeGlpi) {
        this.requestTypeGlpi = requestTypeGlpi;
        return this;
    }

    public void setRequestTypeGlpi(String requestTypeGlpi) {
        this.requestTypeGlpi = requestTypeGlpi;
    }

    public Integer getRequestTypeGlpiId() {
        return requestTypeGlpiId;
    }

    public RequestType requestTypeGlpiId(Integer requestTypeGlpiId) {
        this.requestTypeGlpiId = requestTypeGlpiId;
        return this;
    }

    public void setRequestTypeGlpiId(Integer requestTypeGlpiId) {
        this.requestTypeGlpiId = requestTypeGlpiId;
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
        RequestType requestType = (RequestType) o;
        if (requestType.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), requestType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RequestType{" +
            "id=" + getId() +
            ", requestTypeRemedy='" + getRequestTypeRemedy() + "'" +
            ", requestTypeGlpi='" + getRequestTypeGlpi() + "'" +
            ", requestTypeGlpiId=" + getRequestTypeGlpiId() +
            "}";
    }
}
