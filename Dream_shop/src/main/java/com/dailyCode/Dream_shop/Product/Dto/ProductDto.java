package com.dailyCode.Dream_shop.Product.Dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductDto(
       @NotEmpty String name,
       @NotEmpty String brand,
       @Positive BigDecimal price,
       @PositiveOrZero Integer inventory,
       @NotEmpty String description,
       @NotNull Long categoryId
) {
}
