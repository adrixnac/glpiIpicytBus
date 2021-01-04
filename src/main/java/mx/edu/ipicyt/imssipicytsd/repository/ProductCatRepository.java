package mx.edu.ipicyt.imssipicytsd.repository;

import mx.edu.ipicyt.imssipicytsd.domain.ProductCat;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the ProductCat entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductCatRepository extends JpaRepository<ProductCat, Long> {
    ProductCat findProductCatByProductCatRemedy(String productCatRemedy);
    ProductCat findFirstByProductCatRemedyEquals(String productCatRemedy);
}
