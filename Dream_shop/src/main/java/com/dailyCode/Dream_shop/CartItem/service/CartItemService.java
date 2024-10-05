package com.dailyCode.Dream_shop.CartItem.service;

import com.dailyCode.Dream_shop.Cart.model.Cart;
import com.dailyCode.Dream_shop.Cart.repository.CartRepo;
import com.dailyCode.Dream_shop.Cart.service.CartService;
import com.dailyCode.Dream_shop.CartItem.model.CartItem;
import com.dailyCode.Dream_shop.CartItem.repository.CartItemRepo;
import com.dailyCode.Dream_shop.Product.mapper.ProductMapper;
import com.dailyCode.Dream_shop.Product.service.ProductService;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepo cartItemRepository;
    private final CartRepo cartRepository;
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final CartService cartService;


    public void addItemToCart(Long cartId, Long productId, int quantity) {
        //1. Get the cart
        //2. Get the product
        //3. Check if the product already in the cart
        //4. If Yes, then increase the quantity with the requested quantity
        //5. If No, then initiate a new CartItem entry.
        Cart cart = cartService.getCart(cartId);
        var product = productService.getProductById(productId);
        CartItem cartItem = cart.getItem()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst().orElse(new CartItem());
        if (cartItem.getId() == null) {
            cartItem.setCart(cart);
            cartItem.setProduct(productMapper.toProduct(product));
            cartItem.setQuantity(quantity);
            cartItem.setUnitPrice(product.price());
        }
        else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }
        cartItem.setTotalPrice();
        cart.addItem(cartItem);
        cartItemRepository.save(cartItem);
        cartRepository.save(cart);
    }


    public void removeItemFromCart(Long cartId, Long productId) {
        Cart cart = cartService.getCart(cartId);
        CartItem itemToRemove = getCartItem(cartId, productId);
        cart.removeItem(itemToRemove);
        cartRepository.save(cart);
    }


    public void updateItemQuantity(Long cartId, Long productId, int quantity) {
        Cart cart = cartService.getCart(cartId);
        cart.getItem()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .ifPresent(item -> {
                    item.setQuantity(quantity);
                    item.setUnitPrice(item.getProduct().getPrice());
                    item.setTotalPrice();
                });
        BigDecimal totalAmount = cart.getItem()
                .stream().map(CartItem ::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);
    }


    public CartItem getCartItem(Long cartId, Long productId) {
        Cart cart = cartService.getCart(cartId);
        return  cart.getItem()
                .stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst().orElseThrow(() -> new EntityNotFoundException("Cart item not found"));
    }
}
