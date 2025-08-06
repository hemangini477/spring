package com.rmk.controller;

import com.rmk.model.Catalog;
import com.rmk.model.Product;
import com.rmk.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    @Qualifier("catalogservice")
    CatalogService catalogService;

    @PostMapping(path = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean addProductToCatalog(@RequestParam("catalogId") Integer catalogId, @RequestBody Product product) {
        return catalogService.addProduct(catalogId, product);
    }

    @DeleteMapping(path = "/removeProduct")
    public boolean removeProductFromCatalog(@RequestParam("catalogid") Integer catalogId,
                                            @RequestParam("productsku") String sku) {
        return catalogService.removeProduct(catalogId, sku);
    }

    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Product> listProducts(@RequestParam("catalogid") Integer catalogId) {
        return catalogService.listCatalogProducts(catalogId);
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Catalog> getAll() {
        return catalogService.listCatalog();
    }
}
