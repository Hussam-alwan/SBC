package com.dailyCode.Dream_shop.Product.Dto;

import com.dailyCode.Dream_shop.Category.model.Category;
import com.dailyCode.Dream_shop.Image.Dto.ImageDto;

import java.math.BigDecimal;
import java.util.List;

public record ProductDto(
        Long id,
        String name,
        String brand,
        BigDecimal price,
        Integer inventory,
        String description,
        Category category,
        List<ImageDto> images
) {
}
