package com.dailyCode.Dream_shop.Product.Dto;

import java.math.BigDecimal;

public record ProductRequestDto(
    String name,
    String brand,
    BigDecimal price,
    Integer inventory,
    String description,
    Long categoryId
) {}
