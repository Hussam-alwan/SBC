package com.dailyCode.Dream_shop.Order.repository;

import com.dailyCode.Dream_shop.Order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    List<Order> findByUserId(long userId);

}
