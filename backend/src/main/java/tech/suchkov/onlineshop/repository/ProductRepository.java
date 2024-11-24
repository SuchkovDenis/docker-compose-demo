package tech.suchkov.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.suchkov.onlineshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}