package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController()
@RequestMapping("/api/")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "categories",method=RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategoryList(){
        List<Category> allCategories = categoryService.getAllCategories();
        return  new ResponseEntity<>(allCategories,HttpStatus.OK);
    }
    @PostMapping("public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);

        return new ResponseEntity<>("Category added successfully",HttpStatus.OK);
    }
    @DeleteMapping("admin/category/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId){
           try {
               return new ResponseEntity<>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
           }catch (ResponseStatusException e){
               return new ResponseEntity<>(e.getReason(),e.getStatusCode());
           }
    }
    @PutMapping("public/categories/{categoryId}")
    public ResponseEntity<String>updateCategory(@RequestBody Category category,@PathVariable long categoryId){
        try {
            categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category With  Id : " + categoryId + " has updated" ,HttpStatus.OK);

        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

}
