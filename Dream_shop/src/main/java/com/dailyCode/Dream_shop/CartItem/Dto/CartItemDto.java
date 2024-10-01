package com.dailyCode.Dream_shop.CartItem.Dto;

import java.math.BigDecimal;

public record CartItemDto(
        Long itemId,
        Integer quantity,
        BigDecimal unitPrice,
        Long productId
) {}