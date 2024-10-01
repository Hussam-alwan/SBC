package com.dailyCode.Dream_shop.Category.mapper;

import com.dailyCode.Dream_shop.Category.Dto.CategoryDto;
import com.dailyCode.Dream_shop.Category.Dto.CategoryResponseDto;
import com.dailyCode.Dream_shop.Category.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    public CategoryResponseDto toCategoryResponseDto(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getName()
        );
    }

    public Category toCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.name());
        return category;
    }
}
