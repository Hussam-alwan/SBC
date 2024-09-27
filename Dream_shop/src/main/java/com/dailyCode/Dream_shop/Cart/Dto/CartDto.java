package com.dailyCode.Dream_shop.Cart.Dto;

import com.dailyCode.Dream_shop.CartItem.Dto.CartItemDto;

import java.math.BigDecimal;
import java.util.Set;

public record CartDto(
        Long cartId,
        Set<CartItemDto> items,
        BigDecimal totalAmount
) {
}
