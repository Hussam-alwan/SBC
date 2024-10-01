package com.dailyCode.Dream_shop.OrderItem.repository;
import com.dailyCode.Dream_shop.OrderItem.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {

}
