package com.dailyCode.Dream_shop.CartItem.Dto;

import com.dailyCode.Dream_shop.Product.Dto.ProductDto;

import java.math.BigDecimal;

public record CartItemDto(
        Long itemId,
        Integer quantity,
        BigDecimal unitPrice,
        ProductDto product
) {}