package com.dailyCode.Dream_shop.OrderItem.Dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Long productId,
        String productName,
        int quantity,
        BigDecimal price
) {}
