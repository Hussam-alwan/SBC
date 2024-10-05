package com.dailyCode.Dream_shop.Category.service;

import com.dailyCode.Dream_shop.Category.Dto.CategoryDto;
import com.dailyCode.Dream_shop.Category.Dto.CategoryResponseDto;
import com.dailyCode.Dream_shop.Category.mapper.CategoryMapper;
import com.dailyCode.Dream_shop.Category.model.Category;
import com.dailyCode.Dream_shop.Category.repository.CategoryRepo;
import com.dailyCode.Dream_shop.exceptions.EntityAlreadyExist;
import com.dailyCode.Dream_shop.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepo categoryRepo;

    public CategoryResponseDto addCategory(CategoryDto categoryDto) {
        if(categoryRepo.existsByName(categoryDto.name())) throw new EntityAlreadyExist("Category already exists");
        Category category= categoryMapper.toCategory(categoryDto);
        category.setName(categoryDto.name());
        categoryRepo.save(category);
        return categoryMapper.toCategoryResponseDto(category);
    }
    public List<CategoryResponseDto> getAllCategory(){
        return categoryRepo.findAll().stream().map(categoryMapper::toCategoryResponseDto).toList();
    }
    public CategoryResponseDto getCategoryById(Long id){
        if(!categoryRepo.existsById(id)) throw new EntityNotFoundException("Category not found");
        return categoryMapper.toCategoryResponseDto(Objects.requireNonNull(categoryRepo.findById(id).orElse(null)));
    }
    public CategoryResponseDto updateCategory(CategoryDto categoryDto,Long id){
        if(!categoryRepo.existsById(id)) throw new EntityNotFoundException("Category not found");
        Category category= new Category();
        category.setId(id);
        category.setName(categoryDto.name());
        categoryRepo.save(category);
        return categoryMapper.toCategoryResponseDto(category);
    }

    public void deleteCategoryById(Long id){
        categoryRepo.findById(id).ifPresentOrElse(categoryRepo::delete,() -> {
            throw new EntityNotFoundException("Category not found");
        });
    }
    public CategoryResponseDto getCategoryByName(String name){
        if(!categoryRepo.existsByName(name)) throw new EntityNotFoundException("Category not found");
        return categoryMapper.toCategoryResponseDto(Objects.requireNonNull(categoryRepo.findByName(name)));
    }


}
