package com.dailyCode.Dream_shop.Product.repository;

import com.dailyCode.Dream_shop.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findByCategoryName(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByCategoryNameAndBrand(String category, String brand);

    List<Product> findByName(String name);

    List<Product> findByBrandAndName(String brand,String name);

    long countByBrandAndName(String brand,String name);

    Boolean existsByNameAndBrandAndPrice(String name, String brand, BigDecimal price);


}
