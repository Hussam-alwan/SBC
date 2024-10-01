package com.dailyCode.Dream_shop.Cart.mapper;

import com.dailyCode.Dream_shop.Cart.Dto.CartDto;
import com.dailyCode.Dream_shop.Cart.model.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartMapper {
    public CartDto toCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
            null,
                cart.getTotalAmount()
        );
    }

    public Cart toCart(CartDto cartDto) {
        Cart cart=new Cart();
        cart.setId(cartDto.cartId());
        cart.setTotalAmount(cartDto.totalAmount());
        return cart;
    }

}
