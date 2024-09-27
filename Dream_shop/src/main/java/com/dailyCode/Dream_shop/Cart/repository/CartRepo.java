package com.dailyCode.Dream_shop.Cart.repository;

import com.dailyCode.Dream_shop.Cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    Cart findByUserId(long userId);

}
