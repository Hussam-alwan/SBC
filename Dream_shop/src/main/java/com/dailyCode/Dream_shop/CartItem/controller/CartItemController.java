package com.dailyCode.Dream_shop.CartItem.controller;

import com.dailyCode.Dream_shop.CartItem.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/cartItem")
public class CartItemController {
    private final CartItemService cartItemService;
    @PostMapping("/item/add")
    public void addItemToCart(@RequestParam(required = false) Long cartId,
                                         @RequestParam Long productId,
                                         @RequestParam int quantity) {
        cartItemService.addItemToCart(cartId, productId, quantity);
    }

    @DeleteMapping("/cart/{cartId}/product/{productId}")
    public void removeItemFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        cartItemService.removeItemFromCart(cartId, productId);
    }

    @PutMapping("/cart/{cartId}/product/{productId}")
    public void updateItemQuantity(@PathVariable Long cartId, @PathVariable Long productId, @RequestParam int quantity) {
        cartItemService.updateItemQuantity(cartId, productId, quantity);
    }


}
