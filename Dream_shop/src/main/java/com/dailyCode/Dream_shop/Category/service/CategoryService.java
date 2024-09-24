package com.dailyCode.Dream_shop.Category.service;

import com.dailyCode.Dream_shop.Category.mapper.CategoryMapper;
import com.dailyCode.Dream_shop.Category.repository.CategoryRepo;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryMapper categoryMapper, CategoryRepo categoryRepo) {
        this.categoryMapper = categoryMapper;
        this.categoryRepo = categoryRepo;
    }
}
