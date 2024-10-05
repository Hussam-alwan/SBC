package com.dailyCode.Dream_shop.Cart.service;

import com.dailyCode.Dream_shop.Cart.model.Cart;
import com.dailyCode.Dream_shop.Cart.repository.CartRepo;
import com.dailyCode.Dream_shop.CartItem.repository.CartItemRepo;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepo cartRepository;
    private final CartItemRepo cartItemRepository;
    private final AtomicLong cartIdGenerator = new AtomicLong(0);


    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        return cartRepository.save(cart);
    }


    @Transactional
    public void clearCart(Long id) {
        Cart cart = getCart(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.getItem().clear();
        cartRepository.deleteById(id);

    }

    public BigDecimal getTotalPrice(Long id) {
        Cart cart = getCart(id);
        return cart.getTotalAmount();
    }

    public Long initializeNewCart() {
        Cart newCart = new Cart();
        Long newCartId = cartIdGenerator.incrementAndGet();
        newCart.setId(newCartId);
        return cartRepository.save(newCart).getId();

    }

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }
}