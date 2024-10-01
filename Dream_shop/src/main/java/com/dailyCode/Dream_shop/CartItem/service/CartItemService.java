package com.dailyCode.Dream_shop.CartItem.service;

import com.dailyCode.Dream_shop.Cart.model.Cart;
import com.dailyCode.Dream_shop.Cart.repository.CartRepo;
import com.dailyCode.Dream_shop.CartItem.Dto.CartItemDto;
import com.dailyCode.Dream_shop.CartItem.mapper.CartItemMapper;
import com.dailyCode.Dream_shop.CartItem.model.CartItem;
import com.dailyCode.Dream_shop.CartItem.repository.CartItemRepo;
import com.dailyCode.Dream_shop.Product.model.Product;
import com.dailyCode.Dream_shop.Product.repository.ProductRepo;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartItemService {
    private final CartItemRepo cartItemRepo;
    private final CartItemMapper cartItemMapper;
    private final ProductRepo productRepo;
    private final CartRepo cartRepo;

    public void deleteCartItemById(Long id) {
        if(cartItemRepo.existsById(id))  cartItemRepo.deleteById(id);
        else throw new EntityNotFoundException("Cart item not found");
    }

    public CartItemDto addItemToCart(Long id, Long productId, Integer quantity) {
        Cart cart= cartRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        Product product=productRepo.findById(productId).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        CartItem cartItem= cart.getCartItems().stream().filter(cartItem1 -> cartItem1.getProduct().getId().equals(productId)).findFirst().orElse(null);
        if(cartItem==null) {
            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cart.getCartItems().add(cartItem);
            cartItemRepo.save(cartItem);
        }
        else {
            cartItem.setQuantity(cartItem.getQuantity()+quantity);
            cartItemRepo.save(cartItem);
        }
        cartItem.setTotalPrice();
        //cart.addItemToCart(cartItem);
        cartItemRepo.save(cartItem);
        return cartItemMapper.toCartItemDto(cartItem);
    }

    public void removeItemFromCart(Long id, Long productId) {
        Cart cart= cartRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        CartItem cartItem = getCartItemById(id,productId);
        cart.getCartItems().remove(cartItem);
        cartRepo.save(cart);
    }
    public void updateItemQuantity(Long id, Long productId, Integer quantity) {
//        Cart cart= cartRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
//        cart.getCartItems().stream().filter(cartItem1 -> cartItem1.getProduct().getId().equals(productId)).findFirst().isPresent(
//                cartItem -> {cartItem.setQuantity(quantity);
//                cartItem.setUnitPrice(cartItem.getProduct().getPrice());
//                cartItem.setTotalPrice();
//                }
//
//        );

    }
    public CartItem getCartItemById(Long id,Long productId) {
        Cart cart= cartRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        CartItem cartItem= cart.getCartItems().stream().filter(cartItem1 -> cartItem1.getProduct().getId().equals(productId)).findFirst().orElse(null);
        if(cartItem==null) {
            throw new EntityNotFoundException("Cart item not found");
        }
        return cartItem;
    }
}
