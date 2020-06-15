package com.application.repository;

import com.application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.description like :description")
    List<Product> findProductByDescription(@Param("description") String description);

    List<Product> findProductByPriceBetween(Double minPrice, Double maxPrice);
}
