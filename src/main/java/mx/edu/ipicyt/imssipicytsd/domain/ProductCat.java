package mx.edu.ipicyt.imssipicytsd.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A ProductCat.
 */
@Entity
@Table(name = "product_cat")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProductCat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_cat_glpi", nullable = false)
    private String productCatGlpi;

    @NotNull
    @Column(name = "product_cat_glpi_id", nullable = false)
    private Integer productCatGlpiId;

    @NotNull
    @Column(name = "product_cat_structure", nullable = false)
    private String productCatStructure;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCatGlpi() {
        return productCatGlpi;
    }

    public ProductCat productCatGlpi(String productCatGlpi) {
        this.productCatGlpi = productCatGlpi;
        return this;
    }

    public void setProductCatGlpi(String productCatGlpi) {
        this.productCatGlpi = productCatGlpi;
    }

    public Integer getProductCatGlpiId() {
        return productCatGlpiId;
    }

    public ProductCat productCatGlpiId(Integer productCatGlpiId) {
        this.productCatGlpiId = productCatGlpiId;
        return this;
    }

    public void setProductCatGlpiId(Integer productCatGlpiId) {
        this.productCatGlpiId = productCatGlpiId;
    }

    public String getProductCatStructure() {
        return productCatStructure;
    }

    public ProductCat productCatStructure(String productCatStructure) {
        this.productCatStructure = productCatStructure;
        return this;
    }

    public void setProductCatStructure(String productCatStructure) {
        this.productCatStructure = productCatStructure;
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
        ProductCat productCat = (ProductCat) o;
        if (productCat.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productCat.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductCat{" +
            "id=" + getId() +
            ", productCatGlpi='" + getProductCatGlpi() + "'" +
            ", productCatGlpiId=" + getProductCatGlpiId() +
            ", productCatStructure='" + getProductCatStructure() + "'" +
            "}";
    }
}
