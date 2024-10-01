package com.dailyCode.Dream_shop.Cart.service;

import com.dailyCode.Dream_shop.Cart.Dto.CartDto;
import com.dailyCode.Dream_shop.Cart.mapper.CartMapper;
import com.dailyCode.Dream_shop.Cart.model.Cart;
import com.dailyCode.Dream_shop.Cart.repository.CartRepo;
import com.dailyCode.Dream_shop.CartItem.repository.CartItemRepo;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class CartService {
    private final CartMapper cartMapper;
    private final CartRepo cartRepo;
    private final CartItemRepo cartItemRepo;

    public CartDto getCartById(long id) {
        Cart cart = cartRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        BigDecimal totalAmount =cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        cartRepo.save(cart);
        return cartMapper.toCartDto(cart);
    }

    @Transactional
    public void clearCart(long id) {
        Cart cart = cartRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
        cartItemRepo.deleteAllByCartId(id);
        cart.getCartItems().clear();
        cartRepo.deleteById(id);
    }
    public BigDecimal getTotalPrice(Long id){
        Cart cart =cartRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Cart not found"));
        return cart.getTotalAmount();
    }
}
