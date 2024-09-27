package com.dailyCode.Dream_shop.OrderItem.repository;

import com.dailyCode.Dream_shop.OrderItem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
