package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import mx.edu.ipicyt.imssipicytsd.domain.ProductCat;
import mx.edu.ipicyt.imssipicytsd.repository.ProductCatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
@RequestMapping("/api")
public class ProductCatResourceImp {

    private final Logger log = LoggerFactory.getLogger(ProductCatResourceImp.class);
    private static final String ENTITY_NAME = "productCat";
    private final ProductCatRepository productCatRepository;

    public ProductCatResourceImp(ProductCatRepository productCatRepository) {
        this.productCatRepository = productCatRepository;
    }

    /**
     * GET  /product-cats/remedy/:productCatRemedy : get the "id" productCat.
     *
     * @param productCatRemedy the productCatRemedy of the productCat to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productCat, or with status 404 (Not Found)
     */
    @GetMapping("/product-cats/remedy/{productCatRemedy}")
    @Timed
    public ResponseEntity<ProductCat> getProductCat(@PathVariable String productCatRemedy) {
        log.debug("REST request to get ProductCat : {}", productCatRemedy);
        ProductCat productCat = productCatRepository.findProductCatByProductCatRemedy(productCatRemedy);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(productCat));
    }
}
