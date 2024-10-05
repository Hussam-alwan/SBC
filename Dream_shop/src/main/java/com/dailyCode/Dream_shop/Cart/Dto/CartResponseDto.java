package com.dailyCode.Dream_shop.Cart.Dto;

import com.dailyCode.Dream_shop.CartItem.Dto.CartItemDto;

import java.math.BigDecimal;
import java.util.Set;

public record CartResponseDto(
    Long id,
    Set<CartItemDto> items,
    BigDecimal totalAmount
) {
}
