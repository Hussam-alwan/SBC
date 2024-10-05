package com.dailyCode.Dream_shop.Category.controller;

import com.dailyCode.Dream_shop.Category.Dto.CategoryDto;
import com.dailyCode.Dream_shop.Category.Dto.CategoryResponseDto;
import com.dailyCode.Dream_shop.Category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryResponseDto> getAllCategory(){
        return this.categoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Long id){
        return this.categoryService.getCategoryById(id);
    }

    @GetMapping("/category/{name}")
    public CategoryResponseDto getCategoryByName(@PathVariable String name){
        return this.categoryService.getCategoryByName(name);
    }
    @PostMapping("/add")
    public CategoryResponseDto addCategory(@RequestParam CategoryDto categoryDto){
        return this.categoryService.addCategory(categoryDto);
    }

    @PutMapping("/category/{id}/update")
    public CategoryResponseDto updateCategory(@RequestParam CategoryDto categoryDto,@PathVariable Long id){
        return this.categoryService.updateCategory(categoryDto,id);
    }

    @DeleteMapping("/category/{id}/delete")
    public void deleteCategoryById(@PathVariable Long id){
        this.categoryService.deleteCategoryById(id);
    }
}
