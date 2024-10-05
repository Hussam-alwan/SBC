package com.dailyCode.Dream_shop.Product.Dto;

import java.math.BigDecimal;

public record ProductResponseDto(
        Long id,
        String name,
        String brand,
        BigDecimal price,
        Integer inventory,
        String description,
        Long categoryId
) {}
