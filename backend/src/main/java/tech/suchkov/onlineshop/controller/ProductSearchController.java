package tech.suchkov.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.suchkov.onlineshop.entity.Product;
import tech.suchkov.onlineshop.service.ProductService;

import java.util.Collection;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductSearchController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Collection<Product> home() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/search")
    public Collection<Product> search(@RequestParam String query) {
        return productService.searchProductsViaElastic(query);
    }
}