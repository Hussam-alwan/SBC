package com.dailyCode.Dream_shop.Cart.controller;

import com.dailyCode.Dream_shop.Cart.model.Cart;
import com.dailyCode.Dream_shop.Cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping("/{id}/my-cart")
    public Cart getCart(@PathVariable Long id) {
        return this.cartService.getCart(id);
    }
    @DeleteMapping("/{id}/clear")
    public void clearCart(@PathVariable Long id) {
         this.cartService.clearCart(id);
    }
    @GetMapping("/{id}/cart/total-price")
    public BigDecimal getTotalAmount(@PathVariable Long id) {
        return cartService.getTotalPrice(id);
    }
}
