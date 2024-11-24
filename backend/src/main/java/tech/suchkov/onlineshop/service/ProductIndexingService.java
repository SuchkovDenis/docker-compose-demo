package tech.suchkov.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.suchkov.onlineshop.entity.Product;
import tech.suchkov.onlineshop.entity.ProductDoc;
import tech.suchkov.onlineshop.repository.ProductElasticsearchRepository;
import tech.suchkov.onlineshop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductIndexingService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductElasticsearchRepository productElasticsearchRepository;

    @Transactional(readOnly = true)
    @EventListener(ApplicationReadyEvent.class)
    public void reindexAllProducts() {
        List<Product> products = productRepository.findAll();

        productElasticsearchRepository.saveAll(
                products.stream().map(
                        product -> new ProductDoc(
                                product.getId(),
                                product.getName(),
                                product.getDescription()
                        )
                ).toList()
        );
    }
}
