package mx.edu.ipicyt.imssipicytsd.web.rest;

import com.codahale.metrics.annotation.Timed;
import mx.edu.ipicyt.imssipicytsd.domain.ProductCat;

import mx.edu.ipicyt.imssipicytsd.repository.ProductCatRepository;
import mx.edu.ipicyt.imssipicytsd.web.rest.errors.BadRequestAlertException;
import mx.edu.ipicyt.imssipicytsd.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing ProductCat.
 */
@RestController
@RequestMapping("/api")
public class ProductCatResource {

    private final Logger log = LoggerFactory.getLogger(ProductCatResource.class);

    private static final String ENTITY_NAME = "productCat";

    private final ProductCatRepository productCatRepository;

    public ProductCatResource(ProductCatRepository productCatRepository) {
        this.productCatRepository = productCatRepository;
    }

    /**
     * POST  /product-cats : Create a new productCat.
     *
     * @param productCat the productCat to create
     * @return the ResponseEntity with status 201 (Created) and with body the new productCat, or with status 400 (Bad Request) if the productCat has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/product-cats")
    @Timed
    public ResponseEntity<ProductCat> createProductCat(@Valid @RequestBody ProductCat productCat) throws URISyntaxException {
        log.debug("REST request to save ProductCat : {}", productCat);
        if (productCat.getId() != null) {
            throw new BadRequestAlertException("A new productCat cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProductCat result = productCatRepository.save(productCat);
        return ResponseEntity.created(new URI("/api/product-cats/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /product-cats : Updates an existing productCat.
     *
     * @param productCat the productCat to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated productCat,
     * or with status 400 (Bad Request) if the productCat is not valid,
     * or with status 500 (Internal Server Error) if the productCat couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/product-cats")
    @Timed
    public ResponseEntity<ProductCat> updateProductCat(@Valid @RequestBody ProductCat productCat) throws URISyntaxException {
        log.debug("REST request to update ProductCat : {}", productCat);
        if (productCat.getId() == null) {
            return createProductCat(productCat);
        }
        ProductCat result = productCatRepository.save(productCat);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, productCat.getId().toString()))
            .body(result);
    }

    /**
     * GET  /product-cats : get all the productCats.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of productCats in body
     */
    @GetMapping("/product-cats")
    @Timed
    public List<ProductCat> getAllProductCats() {
        log.debug("REST request to get all ProductCats");
        return productCatRepository.findAll();
        }

    /**
     * GET  /product-cats/:id : get the "id" productCat.
     *
     * @param id the id of the productCat to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the productCat, or with status 404 (Not Found)
     */
    @GetMapping("/product-cats/{id}")
    @Timed
    public ResponseEntity<ProductCat> getProductCat(@PathVariable Long id) {
        log.debug("REST request to get ProductCat : {}", id);
        ProductCat productCat = productCatRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(productCat));
    }

    /**
     * DELETE  /product-cats/:id : delete the "id" productCat.
     *
     * @param id the id of the productCat to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/product-cats/{id}")
    @Timed
    public ResponseEntity<Void> deleteProductCat(@PathVariable Long id) {
        log.debug("REST request to delete ProductCat : {}", id);
        productCatRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
