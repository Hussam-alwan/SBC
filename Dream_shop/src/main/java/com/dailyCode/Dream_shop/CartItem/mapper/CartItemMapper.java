package com.dailyCode.Dream_shop.CartItem.mapper;

import com.dailyCode.Dream_shop.CartItem.Dto.CartItemDto;
import com.dailyCode.Dream_shop.CartItem.model.CartItem;
import com.dailyCode.Dream_shop.Product.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CartItemMapper {

    public CartItemDto toCartItemDto(CartItem cartItem) {
        return new CartItemDto(
                cartItem.getId(),
                cartItem.getQuantity(),
                cartItem.getUnitPrice(),
                cartItem.getProduct().getId()
        );
    }

    public CartItem toCartItem(CartItemDto cartItemDto) {
         CartItem cartItem = new CartItem();

        cartItem.setId(cartItemDto.itemId());
        cartItem.setQuantity(cartItemDto.quantity());
        cartItem.setUnitPrice(cartItemDto.unitPrice());
        cartItem.setProduct(new Product());
        return cartItem;
    }

}
