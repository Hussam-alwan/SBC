package com.dailyCode.Dream_shop.CartItem.repository;

import com.dailyCode.Dream_shop.CartItem.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Long> {
    void deleteAllByCartId(Long id);
}
