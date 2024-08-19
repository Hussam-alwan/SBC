package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepositories categoryRepositories;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepositories.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepositories.save(category);
    }

    @Override
    public String deleteCategory(long categoryId) {
        Category existingCategory = categoryRepositories.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryRepositories.delete(existingCategory);
        return "Category with category ID: " + categoryId + " deleted successfully!";
    }

    @Override
    public Category updateCategory(Category category, long categoryId) {
        Category existingCategory = categoryRepositories.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        category.setCategoryId(categoryId);
        return categoryRepositories.save(category);
    }
}
