package tech.suchkov.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.suchkov.onlineshop.entity.Product;
import tech.suchkov.onlineshop.entity.ProductDoc;
import tech.suchkov.onlineshop.repository.ProductElasticsearchRepository;
import tech.suchkov.onlineshop.repository.ProductRepository;

import java.util.*;

import static java.util.Comparator.comparingInt;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductElasticsearchRepository productElasticsearchRepository;

    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Collection<Product> searchProductsViaElastic(String searchText) {
        List<ProductDoc> searchResults = productElasticsearchRepository.searchByQuery(searchText);

        Map<Long, Integer> idsMap = new HashMap<>();
        for (int i = 0; i < searchResults.size(); i++) {
            idsMap.put(searchResults.get(i).getId(), i);
        }

        Set<Long> ids = idsMap.keySet();

        List<Product> productsFromDb = productRepository.findAllById(ids);
        productsFromDb.sort(comparingInt(product -> idsMap.get(product.getId())));

        return productsFromDb;
    }
}