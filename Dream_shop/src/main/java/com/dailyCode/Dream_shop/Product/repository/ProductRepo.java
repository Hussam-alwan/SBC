package com.dailyCode.Dream_shop.Product.repository;

import com.dailyCode.Dream_shop.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
